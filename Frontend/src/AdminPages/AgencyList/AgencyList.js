import React, { useState, useEffect } from "react";
import axios from "axios";
import Navbar from '../layout/Navbar'
import './AgencyList.css' 
import AgencyRow from "../AgencyRow";

const AgencyList = () => {

    const [agencies, setAgency] = useState([]);

    useEffect(() => {
       loadAgencies();
    }, []);

    const loadAgencies = () => {
        axios.get('http://localhost:8080/agency/agencylist').then((response) => {
          const result = response.data
          if (result.status === 'success') {
            setAgency(result.data)
          } else {
            alert('error while loading list of agency')
          }
        })
      }

     
    
    return(
        <div>
            <div>
            <Navbar/>
        </div>
        <div className="list1">
            <h3 className="label1">Agency List</h3>
            <table className="table table-responsive table-striped table-hover styled-table">
                <thead>
                    <tr>
                        <th>Agency Id</th>
                        <th>Agency Name</th>
                        <th>Agency Address</th>
                        <th>Owner Name</th>
                        <th>Email Id</th>
                        <th>Action</th>
                       
                        
                    </tr>
                </thead>
                <tbody>
                   {agencies.map((agency) => {
                       return <AgencyRow agency = {agency}/>
                   })}
                </tbody>
            </table>
        </div>
       
        </div>
        
    )
};

export default AgencyList;