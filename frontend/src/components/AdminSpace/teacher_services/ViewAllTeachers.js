import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function ViewAllEnseignants() {
  const [enseignants, setEnseignants] = useState([]);
  const [searchQuery, setSearchQuery] = useState("");
  const [filteredEnseignants, setFilteredEnseignants] = useState([]);

  useEffect(() => {
    loadEnseignants();
  }, []);

  useEffect(() => {
    filterEnseignants();
  }, [enseignants, searchQuery]);

  const loadEnseignants = async () => {
    try {
      const response = await axios.get("http://localhost:8001/api/enseignants");
      setEnseignants(response.data);
    } catch (error) {
      console.error("Erreur lors du chargement des enseignants :", error);
    }
  };

  const deleteEnseignant = async (id) => {
    try {
      await axios.delete(`http://localhost:8001/api/enseignants/${id}`);
      loadEnseignants();
    } catch (error) {
      console.error("Erreur lors de la suppression de l'enseignant :", error);
    }
  };

  const filterEnseignants = () => {
    const filtered = enseignants.filter(
      (enseignant) =>
        enseignant.nom.toLowerCase().includes(searchQuery.toLowerCase()) ||
        enseignant.prenom.toLowerCase().includes(searchQuery.toLowerCase())
    );
    setFilteredEnseignants(filtered);
  };

  const handleSearch = (e) => {
    setSearchQuery(e.target.value);
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Liste des enseignants</h2>
        <div className="mb-3">
          <label htmlFor="search" className="form-label">
            Rechercher par nom ou prénom :
          </label>
          <input
            type="text"
            className="form-control"
            id="search"
            value={searchQuery}
            onChange={handleSearch}
          />
        </div>
        <table className="table border shadow" style={{ paddingLeft: 10, paddingRight: 10 }}>
          <thead>
            <tr>
              <th scope="col">S.N</th>
              <th scope="col">Nom</th>
              <th scope="col">Prénom</th>
              <th scope="col">E-mail</th>
              <th scope="col">Département</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            {filteredEnseignants.map((enseignant, index) => (
              <tr key={enseignant.idEnseignant}>
                <th scope="row">{index + 1}</th>
                <td>{enseignant.nom}</td>
                <td>{enseignant.prenom}</td>
                <td>{enseignant.email}</td>
                <td>{enseignant.departement}</td>
                <td>
                  <button
                    className="btn btn-danger mx-2"
                    onClick={() => deleteEnseignant(enseignant.idEnseignant)}
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="16"
                      height="16"
                      fill="currentColor"
                      class="bi bi-trash"
                      viewBox="0 0 16 16"
                    >
                      <path
                        d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"
                      />
                      <path
                        d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"
                      />
                    </svg>
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
