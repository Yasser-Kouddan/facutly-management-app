import React, { useEffect, useState } from "react";
import axios from "axios";
import {  useNavigate, useParams } from "react-router-dom";

export default function EditEtudiant() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [etudiant, setEtudiant] = useState({
    nom: "",
    prenom: "",
    genre: "",
    cin: "",
    cne: "",
    apogee: "",
    dateDeNaissance: "",
    telephone: "",
    adresse: "",
    email: "",
    password: "",
    niveau: "",
    filiere: "",
  });

  useEffect(() => {
    loadEtudiant();
  }, []);

  const loadEtudiant = async () => {
    try {
      const response = await axios.get(`http://localhost:8002/api/etudiants/${id}`);
      setEtudiant(response.data);
    } catch (error) {
      console.error("Erreur lors du chargement de l'étudiant :", error);
    }
  };

  const handleChange = (e) => {
    setEtudiant({ ...etudiant, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.put(`http://localhost:8002/api/etudiants/${id}`, etudiant);
      navigate.push("/");
    } catch (error) {
      console.error("Erreur lors de la mise à jour de l'étudiant :", error);
    }
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Modifier les informations de l'étudiant</h2>

          <form onSubmit={handleSubmit}>
            <div className="mb-3">
              <label htmlFor="nom" className="form-label">
                Nom
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Entrez le nom"
                name="nom"
                value={etudiant.nom}
                onChange={handleChange}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="prenom" className="form-label">
                Prénom
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Entrez le prénom"
                name="prenom"
                value={etudiant.prenom}
                onChange={handleChange}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="genre" className="form-label">
                Genre
              </label>
              <div className="form-check">
                <input
                  className="form-check-input"
                  type="radio"
                  name="genre"
                  id="genreFeminin"
                  value="Féminin"
                  checked={etudiant.genre === "Féminin"}
                  onChange={handleChange}
                />
                <label className="form-check-label" htmlFor="genreFeminin">
                  Féminin
                </label>
              </div>
              <div className="form-check">
                <input
                  className="form-check-input"
                  type="radio"
                  name="genre"
                  id="genreMasculin"
                  value="Masculin"
                  checked={etudiant.genre === "Masculin"}
                  onChange={handleChange}
                />
                <label className="form-check-label" htmlFor="genreMasculin">
                  Masculin
                </label>
              </div>
            </div>
            {/* Autres champs de formulaire similaires */}
            <button type="submit" className="btn btn-outline-primary">
              Enregistrer
            </button>
            <button className="btn btn-outline-danger mx-2" onClick={() =>navigate.push("/")}>
              Annuler
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
