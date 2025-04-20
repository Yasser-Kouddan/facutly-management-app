import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

export default function ViewAllNotes() {
  const [notes, setNotes] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    loadNotes();
  }, []);

  const loadNotes = async () => {
    try {
      const response = await axios.get("http://localhost:8070/api/notes");
      setNotes(response.data);
    } catch (error) {
      console.error("Erreur lors du chargement des notes :", error);
    }
  };

  const deleteNote = async (id) => {
    try {
      await axios.delete(`http://localhost:8070/api/notes/${id}`);
      loadNotes();
    } catch (error) {
      console.error("Erreur lors de la suppression de la note :", error);
    }
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Liste des notes</h2>
        <table className="table border shadow" style={{ paddingLeft: 10, paddingRight: 10 }}>
          <thead>
            <tr>
              <th scope="col">S.N</th>
              <th scope="col">Nom de l'étudiant</th>
              <th scope="col">Prénom de l'étudiant</th>
              <th scope="col">Appogee de l'étudiant</th>
              <th scope="col">Nom du module</th>
              <th scope="col">Valeur de la note</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            {notes.map((note, index) => (
              <tr key={note.id}>
                <th scope="row">{index + 1}</th>
                <td>{note.etudiant.nom}</td>
                <td>{note.etudiant.prenom}</td>
                <td>{note.etudiant.apogee}</td>
                <td>{note.module.nomModule}</td>
                <td>{note.note}</td>
                <td>
                  <button
                    className="btn btn-danger mx-2"
                    onClick={() => deleteNote(note.id)}
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="16"
                      height="16"
                      fill="currentColor"
                      className="bi bi-trash"
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
        <Link to="/teacher/add-note" className="btn btn-primary mt-2">
          Ajouter une note
        </Link>
      
      </div>
    </div>
  );
}
