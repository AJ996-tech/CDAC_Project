import React, { useState, useEffect } from "react";
import axios from "axios";

import { Link } from "react-router-dom";
import './RouteList.css' 
import RouteRow from "../RouteRow";


const RouteList = () => {

    const [routes, setRoute] = useState([]);

    useEffect(() => {
       loadRoutes();
    }, []);

    const loadRoutes = () => {
        axios.get('http://localhost:8080/route/getroutes').then((response) => {
          const result = response.data
          if (result.status === 'success') {
            setRoute(result.data)
          } else {
            alert('error while loading list of Routes')
          }
        })
      }

     
    
    return(
        <div>
            
        <div className="list1">
            <h3 className="label1">Route List</h3>
            <table className="table table-responsive table-striped table-hover styled-table">
                <thead>
                    <tr>
                        <th>Route Id</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Add Picking Point</th>
                        <th>Add Dropping Point</th>
                        {/* <th>View SubStations</th> */}
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                   {routes.map((route) => {
                       return <RouteRow route = {route}/>
                   })}
                </tbody>
                <br></br>
                <Link to="/agencylist">
          <a className="btn btn-warning">Back To HomePage</a>
        </Link>

            </table>
        </div>
       
        </div>
        
    )
};

export default RouteList;