import { Outlet } from "react-router-dom";
import { Nav, NavLink, NavBtnLink, NavBtn, NavMenu } from "./NavbarElements"

export default function StudentNavbar(){
  return(
    <>
      <Nav>
          <NavMenu>
            <NavLink to='view-profile/:email/:password'>Voir profil</NavLink>
            <NavLink to='view-notes'>Résultats</NavLink>
          </NavMenu>
          <NavBtn>
            <NavBtnLink to='..'>Log out</NavBtnLink>
          </NavBtn>
        </Nav>
      <Outlet/>
    </>
    );
}