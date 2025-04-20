import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewStudent() {
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
    niveau: "",
    filiere: ""
  });

  const { email, password } = useParams();

  useEffect(() => {
    loadEtudiant();
  }, []);

  const loadEtudiant = async () => {
    const result = await axios.get(`http://localhost:8002/api/etudiants/emailAndPassword?email=${email}&password=${password}`);
    setEtudiant(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Détails de l'étudiant</h2>

          <div className="card">
            <div className="card-header">Détails de l'étudiant:</div>
            <ul className="list-group list-group-flush">
              <li className="list-group-item">
                <b>Nom :</b> {etudiant.nom}
              </li>
              <li className="list-group-item">
                <b>Prénom :</b> {etudiant.prenom}
              </li>
              <li className="list-group-item">
                <b>Genre :</b> {etudiant.genre}
              </li>
              <li className="list-group-item">
                <b>CIN :</b> {etudiant.cin}
              </li>
              <li className="list-group-item">
                <b>CNE :</b> {etudiant.cne}
              </li>
              <li className="list-group-item">
                <b>Apogée :</b> {etudiant.apogee}
              </li>
              <li className="list-group-item">
                <b>Date de naissance :</b> {etudiant.dateDeNaissance}
              </li>
              <li className="list-group-item">
                <b>Téléphone :</b> {etudiant.telephone}
              </li>
              <li className="list-group-item">
                <b>Adresse :</b> {etudiant.adresse}
              </li>
              <li className="list-group-item">
                <b>Email :</b> {etudiant.email}
              </li>
              <li className="list-group-item">
                <b>Niveau :</b> {etudiant.niveau}
              </li>
              <li className="list-group-item">
                <b>Filière :</b> {etudiant.filiere}
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
