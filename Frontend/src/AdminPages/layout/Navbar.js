import React from "react";
import { useHistory } from 'react-router'

const Navbar = () => {
  const history = useHistory()
  const SignOut = () => {
    sessionStorage.clear();
    history.push('/adminlogin')
  }
 
    return(
<nav className="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="/home">ProBus</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                          <a class="nav-link" href="/adminprofile">Profile<span class="sr-only"></span></a>
                        </li>
                        <li class="nav-item active">
                          <a class="nav-link" href="/agencylist">AgencyList <span class="sr-only"></span></a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="/addagency">AddAgency</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="/stationlist">StationList</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="/addstation">AddStation</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="/routelist">RouteList</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="/addroute">AddRoute</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="/userlist">UserList</a>
                        </li>
                    </ul>
                </div>
                <div className="signout">
                    <button className="btn btn-outline-success button" onClick={SignOut}>Sign Out</button>
                </div>
            </nav>
    )
};

export default Navbar;