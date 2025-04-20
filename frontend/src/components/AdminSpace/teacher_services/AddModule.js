import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddModule() {
  let navigate = useNavigate();

  const [module, setModule] = useState({
    nomModule: "",
    idEnseignant: "",
  });

  const [error, setError] = useState("");

  const { nomModule, idEnseignant } = module;

  const onInputChange = (e) => {
    setModule({ ...module, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    try {
      // Vérifier si l'ID de l'enseignant est valide
      const enseignantResponse = await axios.get(`http://localhost:8001/api/enseignants/${idEnseignant}`);
      if (enseignantResponse.status !== 200) {
        setError("L'ID de l'enseignant est invalide");
        return;
      }

      setError(""); // Réinitialiser l'erreur s'il y en avait une précédente

      // Envoyer la requête POST pour ajouter le module
      const moduleResponse = await axios.post("http://localhost:8044/api/modules", module);
      if (moduleResponse.status === 200) {
        navigate("/admin/teacher-services/view-modules");
      } else {
        setError("l'enseignant n'existe");
      }
    } catch (error) {
      setError("Une erreur s'est produite lors de l'ajout du module");
    }
  };


  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <form onSubmit={(e) => onSubmit(e)}>
            {/* Existing fields for student */}
            {/* ... */}

            <h2 className="text-center m-4">Ajouter un module</h2>

            {error && <div className="alert alert-danger">{error}</div>}

            <div className="mb-3">
              <label htmlFor="nomModule" className="form-label">
                Nom du Module
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Entrez le nom du module"
                name="nomModule"
                value={nomModule}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="idEnseignant" className="form-label">
                ID de l'enseignant responsable
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Entrez l'ID de l'enseignant responsable"
                name="idEnseignant"
                value={idEnseignant}
                onChange={(e) => onInputChange(e)}
              />
            </div>

            <button type="submit" className="btn btn-outline-primary">
              Ajouter
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Annuler
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}
