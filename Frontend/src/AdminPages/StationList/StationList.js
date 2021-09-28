import React, { useState, useEffect } from "react";
import axios from "axios";

import { Link } from "react-router-dom";
import './StationList.css' 
import StationRow from "../StationRow";


const StationList = () => {

    const [stations, setStation] = useState([]);

    useEffect(() => {
       loadStations();
    }, []);

    const loadStations = () => {
        axios.get('http://localhost:8080/station/stationlist').then((response) => {
          const result = response.data
          if (result.status === 'success') {
            setStation(result.data)
          } else {
            alert('error while loading list of station')
          }
        })
      }

     
    
    return(
        <div>
            
        <div className="list1">
            <h3 className="label1">Station List</h3>
            <table className="table table-responsive table-striped table-hover styled-table">
                <thead>
                    <tr>
                        <th>Station Id</th>
                        <th>Station Name</th>
                        <th>Station City</th>
                        <th>Action</th>
                        
                    </tr>
                </thead>
                <tbody>
                   {stations.map((station) => {
                       return <StationRow station = {station}/>
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
}

export default StationList;