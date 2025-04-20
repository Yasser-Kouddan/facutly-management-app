import { Outlet } from "react-router-dom";
import { Nav, NavLink, NavBtnLink, NavBtn, NavMenu } from "./NavbarElements"

export default function TeacherNavbar(){
  return(
    <>
      <Nav>
          <NavMenu>
            <NavLink to='view-note'>Liste des étudiants</NavLink>
            <NavLink to='add-note'>Ajouter une note</NavLink>
            <NavLink to='view-profile/admin123/secretpassword'>Voir profil</NavLink>
          </NavMenu>
          <NavBtn>
            <NavBtnLink to='..'>Log out</NavBtnLink>
          </NavBtn>
        </Nav>
      <Outlet/>
    </>
    );
}