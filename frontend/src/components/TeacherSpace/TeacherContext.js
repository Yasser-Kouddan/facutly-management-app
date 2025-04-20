import React, { createContext, useState } from "react";

const TeacherContext = createContext();

const TeacherProvider = ({ children }) => {
  const [teacherData, setTeacherData] = useState({});

  return (
    <TeacherContext.Provider value={{ teacherData, setTeacherData }}>
      {children}
    </TeacherContext.Provider>
  );
};

export default TeacherContext;
