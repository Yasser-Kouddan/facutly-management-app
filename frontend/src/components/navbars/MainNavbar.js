import { Outlet } from "react-router-dom";
import { Nav, NavLink, NavMenu } from "./NavbarElements"

export default function MainNavbar(){
    return(
      <>
        <Nav>
            <NavMenu>
              <NavLink to='login/admin'>Espace admin</NavLink>
              <NavLink to='login/teacher'>Espace enseignant</NavLink>
              <NavLink to='login/student'>Espace étudiant</NavLink>
            </NavMenu> 
          </Nav>
        <Outlet/>
      </>
    );
}