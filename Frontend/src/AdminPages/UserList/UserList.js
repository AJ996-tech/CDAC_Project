import React, { useState, useEffect } from "react";
import axios from "axios";

import { Link } from "react-router-dom";

import './UserList.css' 
import UserRow from "../UserRow";


const UserList = () => {// file name and function name should be same

    const [users, setUser] = useState([]);

    useEffect(() => {
       loadUsers();
    }, []);

    const loadUsers = () => {
        axios.get('http://localhost:8080/user/userlist').then((response) => {
          const result = response.data
          if (result.status === 'success') {
            setUser(result.data)
          } else {
            alert('error while loading list of agency')
          }
        })
      }

    return(
      <div>
            <div>
            
        </div>
        <div className="list1">
            <h3 className="label1">User List</h3>
            <table className="table table-responsive table-striped table-hover styled-table">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Address</th>
                        <th>Gender</th>
                        <th>Email Id</th>
                        <th>Mobile No</th>   
                        <th>Action</th>   
                    </tr>
                </thead>
               
                <tbody>
                   {users.map((user) => {
                       return <UserRow user = {user}/>
                   })}
                </tbody><br></br>
                <Link to="/agencylist">
          <a className="btn btn-warning">Back To HomePage</a>
        </Link>


            </table>
        </div>
       
        </div>
    )

}

export default UserList;