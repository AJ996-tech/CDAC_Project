import './UserNavbar.css'
import { useHistory } from 'react-router'
import {Link} from "react-router-dom"


const UserNavbar = () =>{
  const history = useHistory()
  const SignOut = () => {
    sessionStorage.clear();
    history.push('/userlogin')
  }
  return(
    <div>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <Link className="navbar-brand" to="/routes">ProBus</Link>
      <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
      <div className="collapse navbar-collapse dropdown-content" id="navbarSupportedContent">
        <ul className="navbar-nav">
          <li className="nav-item active">
            <Link className="nav-link" to="/routes">Home<span className="sr-only"></span></Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/profile">Profile</Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/bookings">My Bookings</Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/changepassword">Change Password</Link>
          </li>
        </ul>
      </div>
      <div className="signout">
        <button className="btn btn-outline-success button" onClick={SignOut}>Sign Out</button>
      </div>
    </nav>
   </div>
  )
}
export default UserNavbar