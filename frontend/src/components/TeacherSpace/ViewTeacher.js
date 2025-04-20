import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";


export default function ViewTeacher() {
  const [enseignant, setEnseignant] = useState({
    nom: "",
    prenom: "",
    email: "",
    departement: "",
  });

  const { email, password } = useParams();

  useEffect(() => {
    loadEnseignant();
  }, []);

  const loadEnseignant = async () => {
    try {
      const result = await axios.get(`http://localhost:8001/api/enseignants/emailAndPassword?email=${email}&password=${password}`);
      setEnseignant(result.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Détails de l'enseignant</h2>

          <div className="card">
            <div className="card-header">
              Détails de l'enseignant
            </div>
            <ul className="list-group list-group-flush">
              <li className="list-group-item">
                <b>Nom :</b> {enseignant.nom}
              </li>
              <li className="list-group-item">
                <b>Prénom :</b> {enseignant.prenom}
              </li>
              <li className="list-group-item">
                <b>Email :</b> {enseignant.email}
              </li>
              <li className="list-group-item">
                <b>Département :</b> {enseignant.departement}
              </li>
            </ul>
          </div>

          <Link className="btn btn-primary my-2" to={"/"}>
            Retour à la page d'accueil
          </Link>
        </div>
      </div>
    </div>
  );
}
