import './Footer.css'
import { Link} from "react-router-dom";

const Footer = () => {
   return(
    <div  className="footer1 container-fluid responsive">
      <div>
        <footer>
          <div>
            <h3 class="text-muted mb-md-0">ProBus e-Ticket</h3>
          </div>
          <div >    
              <Link to="/">FAQ</Link>  | &nbsp;
              <Link to="/">Blog</Link>  | &nbsp;
              <Link to="/">Offers</Link>  | &nbsp;
              <Link to="/">Privacy Policy</Link>  | &nbsp;
              <Link to="/">Terms And Conditions</Link>
          </div>
          <div>
            <small>
              <span>&#174;</span> ProBus All Rights Reserved.
            </small>
          </div>
        </footer>
      </div>
    </div>
   )
}
export default Footer