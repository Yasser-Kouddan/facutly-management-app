import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function ViewAllNotes() {
  const [notes, setNotes] = useState([]);

  useEffect(() => {
    // Obtenez l'e-mail et le mot de passe de l'étudiant à partir de votre système de connexion ou d'une autre source
    const email = "";
    const password = "";
    loadNotes(email, password);
  }, []);

  const loadNotes = async (email, password) => {
    try {
      const response = await axios.get(`http://localhost:8070/api/notes/etudiant?email=${email}&password=${password}`);
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
        <h2>Liste des notees</h2>
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">S.N</th>
              <th scope="col">Note</th>
              <th scope="col">Module</th>

            </tr>
          </thead>
          <tbody>
            {notes.map((note, index) => (
              <tr key={note.id}>
                <th scope="row">{index + 1}</th>
                <td>{note.note}</td>
                <td>{note.module.nomModule}</td>
                
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
