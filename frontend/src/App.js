import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { Routes, Route } from 'react-router-dom';
import TeacherContext from "./components/TeacherSpace/TeacherContext";

// navbars
import MainNavbar from './components/navbars/MainNavbar';
import AdminNavbar from './components/navbars/AdminNavbar';
import StudentNavbar from './components/navbars/StudentNavbar';
import TeacherNavbar from './components/navbars/TeacherNavbar';

// Login screens
import LoginAdmin from "./components/Auth/LoginAdmin";
import LoginTeacher from "./components/Auth/LoginTeacher";
import LoginStudent from "./components/Auth/LoginStudent";

// components
import HomePage from "./components/HomePage";
import { ViewStudent, ViewAllNotes } from './components/StudentSpace';
import { AddNote, ViewTeacher, ViewAllStudentsNotes } from './components/TeacherSpace';
import {
  ViewAllStudents,
  AddStudent,
  AddModule,
  ViewAllModules,
  AddTeacher,
  ViewAllTeachers,
  EditStudent,
} from './components/AdminSpace';

function App() {
  return (
    <>
      
    
    <Routes>
      
      <Route path='/' element={<><MainNavbar/><HomePage/></>}/>
      
       
        <Route path='/login/*'>
          <Route path='admin' element={<LoginAdmin />} />
          <Route path='student' element={<LoginStudent />} />
          <Route path='teacher' element={<LoginTeacher />} />
        </Route>
        <Route path='/admin/*' element={<AdminNavbar />}>
          <Route path='student-services/*'>
            <Route path='add-student' element={<AddStudent />} />
            <Route path='edit-student/:id' element={<EditStudent/>} />
            <Route path='view-students' element={<ViewAllStudents />} />
          </Route>
          <Route path='teacher-services/*'>
            <Route path='add-teacher' element={<AddTeacher />} />
            <Route path='add-module' element={<AddModule />} />
            <Route path='view-modules' element={<ViewAllModules />} />
            <Route path='view-teachers' element={<ViewAllTeachers />} />
          </Route>
        </Route>
        

        <Route path='/student/*' element={<StudentNavbar />}>
          <Route path='view-profile/:email/:password' element={<ViewStudent />} />
          <Route path='view-notes' element={<ViewAllNotes />} />
        </Route>

        <Route path='/teacher/*' element={<TeacherNavbar />}>
          <Route path='view-profile/:email/:password' element={<ViewTeacher />} />
          <Route path='view-note' element={<ViewAllStudentsNotes />} />
          <Route path='add-note' element={<AddNote />} />
        </Route>
      </Routes>
    
      
    </>
  );
}

export default App;
