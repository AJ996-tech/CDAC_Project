import { useHistory } from 'react-router'

const InnerNavbar= ()=>{
  const history = useHistory()
  const SignOut = () => {
    sessionStorage.clear();
    history.push('/agencylogin')
  }
return(
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="/agency/home">ProBus</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                    <li class="nav-item active">
                          <a class="nav-link" href="/agencyprofile">Profile<span class="sr-only"></span></a>
                        </li>
                        
                        <li class="nav-item active">
                          <a class="nav-link" href="/agency/home">Active Trips<span class="sr-only"></span></a>
                        </li>

                        <li class="nav-item">
                          <a class="nav-link" href="/agency/newTrip">Create Trip</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="/agency/newBus">Add Bus</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="/agency/buses">Show Buses</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="/agency/trips">Show All Trips</a>
                        </li>
                    </ul>
                </div>
                <div className="signout">
                  <button className="btn btn-outline-success button" onClick={SignOut}>Sign Out</button>
                </div>
            </nav>

)
}

export default InnerNavbar