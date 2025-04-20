import { Outlet } from "react-router-dom";
import { Nav, NavLink, NavBtnLink, NavBtn, NavMenu } from "./NavbarElements"

export default function AdminNavbar(){
    return(
    <>
      <Nav>
          <NavMenu>
            <NavLink to='teacher-services/view-teachers'>Liste des enseingants</NavLink>
            <NavLink to='teacher-services/add-teacher'>Ajouter un enseingant</NavLink>
            <NavLink to='teacher-services/add-module'>Ajouter un module</NavLink>
            <NavLink to='teacher-services/view-modules'>Liste des modules</NavLink>
            <NavLink to='student-services/view-students'>Liste des étudiants</NavLink>
            <NavLink to='student-services/add-student'>Ajouter un étudiant</NavLink>
          </NavMenu>
            <NavBtn>
                <NavBtnLink to='..'>Log out</NavBtnLink>
            </NavBtn>
        </Nav>
      <Outlet/>
    </>
    );
}