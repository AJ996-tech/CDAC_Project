import React from "react";
import { useState } from "react";
import axios from 'axios'
import { Link} from "react-router-dom";


const AddAgency = () => {

    const [name,setName]=useState("")
    const [address,setAddress]=useState("")
    const [ownerName,setOwnerName]=useState("")
    const [email,setEmail]=useState("")
    const [password,setPassword]=useState("")

    const addAgencyToDB = () =>{
      if(name.length === 0){
        alert('Enter agnecy name')
      }else if(address.length===0){
        alert('Enter agency address')
      }else if(ownerName.length===0){
        alert('Enter agency ownerName')
      }else if(email.length===0){
        alert('Enter agency email id')
      }else if(password.length===0){
        alert('Enter password')
      }else{

        const data = new FormData()

        data.append('name',name)
        data.append('address',address)
        data.append('ownerName',ownerName)
        data.append('email',email)
        data.append('password',password)

       
        console.log(data.getAll)

        axios.post('http://localhost:8080/agency/addagency',data).then ((response) =>{
          const result = response.data
          if(result.status === 'success'){
            alert('successfully added an agency')

           // history.push('/agencylist')
          }else{
            alert('error while adding an agency')
          }
        })
      }
    }

    return(
      
      <div className="list1">
      <div className="container w-50" ><br></br><br></br>
        <h1 className="text-center card cul" >Add New Agency</h1><hr/>
        <form >
          <div className="form-group">
            <label for="inputEmail3" className="col-sm-2 col-form-label"><h3>Name  </h3></label>
            <input type="text"
                   className="form-control form-control-md" 
                   placeholder="Enter Agency Name"
                   onChange={(e) => {
                    setName(e.target.value)
                  }}
            />
          </div>
          <div className="form-group">
            <label for="inputEmail3" class="col-sm-2 col-form-label"><h3>Address</h3></label>
            <input type="text" 
                   className="form-control form-control-md" 
                   placeholder="Enter Agency Address"
                   onChange={(e) => {
                    setAddress(e.target.value)
                  }}
            />
          </div>
          <div className="form-group">
            <label for="inputEmail3" className="col-sm-2 col-form-label"><h3>Owner Name</h3></label>
            <input type="text"
                   className="form-control form-control-md" 
                   placeholder="Enter Agency Owner Name"
                   onChange={(e) => {
                    setOwnerName(e.target.value)
                  }}
            />
          </div>
          <div className="form-group">
            <label for="inputEmail3" className="col-sm-2 col-form-label"><h3>Email Id</h3></label>
            <input type="email"
                   className="form-control form-control-md" 
                   placeholder="Enter Agency Email Id"
                   onChange={(e) => {
                    setEmail(e.target.value)
                  }}
            />
          </div>
          <div className="form-group">
            <label for="inputEmail3" className="col-sm-2 col-form-label"><h3>Password</h3></label>
            <input type="password"
                   className="form-control form-control-md" 
                   placeholder="Enter Password"
                   onChange={(e) => {
                    setPassword(e.target.value)
                  }}
            />
          </div><br></br>
          <button onClick={addAgencyToDB} type="submit" class="btn btn-success"  >Confirm</button>&nbsp;&nbsp;

          <Link to="/agencylist">
          <a className="btn btn-warning">Back</a>
        </Link>

          </form>
          
      </div>
      
      </div>
    );

}

export default AddAgency;