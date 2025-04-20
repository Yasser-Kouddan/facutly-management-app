import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddStudent() {
  let navigate = useNavigate();

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

  const {
    nom,
    prenom,
    genre,
    cin,
    cne,
    apogee,
    dateDeNaissance,
    telephone,
    adresse,
    email,
    password,
    niveau,
    filiere,
  } = etudiant;

  const onInputChange = (e) => {
    setEtudiant({ ...etudiant, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8002/api/etudiants", etudiant);
    navigate("/admin/student-services/view-students");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Ajouter un étudiant</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="nom" className="form-label">
                Nom
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Entrez le nom"
                name="nom"
                value={nom}
                onChange={(e) => onInputChange(e)}
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
                value={prenom}
                onChange={(e) => onInputChange(e)}
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
                  checked={genre === "Féminin"}
                  onChange={(e) => onInputChange(e)}
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
                  checked={genre === "Masculin"}
                  onChange={(e) => onInputChange(e)}
                />
                <label className="form-check-label" htmlFor="genreMasculin">
                  Masculin
                </label>
              </div>
            </div>
            <div className="mb-3">
              <label htmlFor="cin" className="form-label">
                CIN
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Entrez le CIN"
                name="cin"
                value={cin}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="cne" className="form-label">
                CNE
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Entrez le CNE"
                name="cne"
                value={cne}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="apogee" className="form-label">
                Apogée
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Entrez l'apogée"
                name="apogee"
                value={apogee}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="dateDeNaissance" className="form-label">
                Date de naissance
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Entrez la date de naissance"
                name="dateDeNaissance"
                value={dateDeNaissance}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="telephone" className="form-label">
                Téléphone
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Entrez le numéro de téléphone"
                name="telephone"
                value={telephone}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="adresse" className="form-label">
                Adresse
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Entrez l'adresse"
                name="adresse"
                value={adresse}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="niveau" className="form-label">
                Niveau
              </label>
              <select
                className="form-select"
                name="niveau"
                value={niveau}
                onChange={(e) => onInputChange(e)}
              >
                <option value="">Sélectionnez le niveau</option>
                <option value="DEUST">DEUST</option>
                <option value="LST">LST</option>
                <option value="MST">MST</option>
              </select>
            </div>
            

            <div className="mb-3">
              <label htmlFor="filiere" className="form-label">
                Filière
              </label>
              {niveau === "DEUST" && (
                <select
                  className="form-select"
                  name="filiere"
                  value={filiere}
                  onChange={(e) => onInputChange(e)}
                >
                  <option value="">Sélectionnez la filière</option>
                  <option value="MIPC">MIPC</option>
                  <option value="GEGM">GEGM</option>
                  <option value="BCG">BCG</option>
                </select>
              )}
              {niveau === "LST" && (
                <select
                  className="form-select"
                  name="filiere"
                  value={filiere}
                  onChange={(e) => onInputChange(e)}
                >
                  <option value="">Sélectionnez la filière</option>
                  <option value="Mathématique">Mathématique</option>
                  <option value="Informatique">Informatique</option>
                  <option value="IEEA">IEEA</option>
                  <option value="Mécanique">Mécanique</option>
                </select>
              )}
              {niveau === "MST" && (
                <select
                  className="form-select"
                  name="filiere"
                  value={filiere}
                  onChange={(e) => onInputChange(e)}
                >
                  <option value="">Sélectionnez la filière</option>
                  <option value="Informatique décisionnelle">Informatique décisionnelle</option>
                  <option value="Génie Mathématique et Applications">Génie Mathématique et Applications</option>
                  <option value="Géomatique Environnementale">Géomatique Environnementale</option>
                </select>
              )}
            </div>

            <div className="mb-3">
              <label htmlFor="email" className="form-label">
                E-mail
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Entrez l'adresse e-mail"
                name="email"
                value={email}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="password" className="form-label">
                Mot de passe
              </label>
              <input
                type="password"
                className="form-control"
                placeholder="Entrez le mot de passe"
                name="password"
                value={password}
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
