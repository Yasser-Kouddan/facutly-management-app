import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

export default function AddNote() {
  const [etudiantId, setEtudiantId] = useState("");
  const [moduleId, setModuleId] = useState("");
  const [note, setNote] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8070/api/notes", {
        etudiantId,
        moduleId,
        note
      });
      navigate("/teacher/view-note");
    } catch (error) {
      console.error("Erreur lors de la création de la note :", error);
    }
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Ajouter une note</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label htmlFor="etudiantId" className="form-label">
              ID de l'étudiant
            </label>
            <input
              type="text"
              className="form-control"
              id="etudiantId"
              value={etudiantId}
              onChange={(e) => setEtudiantId(e.target.value)}
            />
          </div>
          <div className="mb-3">
            <label htmlFor="moduleId" className="form-label">
              ID du module
            </label>
            <input
              type="text"
              className="form-control"
              id="moduleId"
              value={moduleId}
              onChange={(e) => setModuleId(e.target.value)}
            />
          </div>
          <div className="mb-3">
            <label htmlFor="note" className="form-label">
              Note
            </label>
            <input
              type="number"
              className="form-control"
              id="note"
              value={note}
              onChange={(e) => setNote(e.target.value)}
            />
          </div>
          <button type="submit" className="btn btn-primary">
            Ajouter
          </button>
        </form>
      </div>
    </div>
  );
}
