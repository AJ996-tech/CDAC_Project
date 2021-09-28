import {Link} from "react-router-dom";

const Navbar = () =>{
  return(
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <Link className="navbar-brand" to="/home">ProBus</Link>
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
      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav">
          <li className="nav-item active">
            <Link className="nav-link" to="/userlogin">Home <span className="sr-only"></span></Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/adminlogin">Admin</Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/agencylogin">Agency</Link>
          </li>
        </ul>
      </div>
     </nav>
  )
}
export default Navbar