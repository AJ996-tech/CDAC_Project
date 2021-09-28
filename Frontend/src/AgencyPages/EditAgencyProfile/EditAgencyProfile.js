import { useState } from "react"
import {useHistory, useLocation} from 'react-router-dom'
import axios from 'axios'
import './EditAgencyProfile.css'
import { url } from '../Common/Constant'
import InnerNavbar from "../InnerNavbar/InnerNavbar"


const EditAgencyProfile = () => {
    const history = useHistory()
   

    const profile =JSON.parse(sessionStorage.getItem("profile"))
    console.log(profile)
    const[name,setName] = useState(profile.name)
    const[ownerName,setOwnerName] = useState(profile.ownerName)
    const[email,setEmail] = useState(profile.email)
    const[mobileNo,setMobileNo] = useState(profile.mobileNo)
    const[address,setAddress] = useState(profile.address)
    
    const EditProfile =() => {
        if(name.length === 0){
            alert('Enter Name')
        }else if(ownerName.length === 0){
            alert('Enter Owner Name')
        }else if(email.length === 0){
            alert('Enter Email')
        }else if(mobileNo.length === 0){
            alert('Enter Mobile No')
        }else if(address.length === 0){
            alert('Enter Address')
        }else{
            const data = new FormData()
            data.append('name',name)
            data.append('ownerName',ownerName)
            data.append('email',email)
            data.append('mobileNo',mobileNo)
            data.append('address',address)
            
            // history.push('/agency/home')

            const id = sessionStorage.getItem("id")

            axios.put(url + '/agency/update/'+ id, data).then((response) => {
                // console.log(response.data)
                const result = response.data
                // console.log(result)
                if(result.status ==='success'){
                  sessionStorage.removeItem("profile");

                   
                    alert('Updated Successfully!')
                    
                    history.push('/agency/home')
                }else{
                    console.log(result.error)
                    alert('Updation Failed!...Please try again!')
                }
            })
        }
    }

    return (
       

        <div>
        <InnerNavbar/>
        <div class="container row">
          <div className="list3">
            <h3 className="label1">Add New Trip</h3>
  
            <form className="form-control">
              <table className="table table-responsive table-striped table-hover styled-table">
                <thead>
                  <tr>
                    <th></th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td> <label>Name</label></td>
                    <td><div className="form-group">
                                     
                                     <input type="text" className="form-control" value={name}   onChange={(event) => {
                                         setName(event.target.value)
                                     }} />
                                 </div></td>
                  </tr>
                  <tr>
                    <td><label>Owner Name</label> </td>
                    <td> <div className="form-group">
                                    
                                     <input type="text" className="form-control" value= {ownerName}  onChange={(event) => {
                                         setOwnerName(event.target.value)
                                     }} />
                                 </div></td>
                  </tr>
                  <tr>
                    <td><label>Email Address</label></td>
                    <td>  <div className="form-group">
                                    
                                     <input type="email" className="form-control" value={email} onChange={(event) => {
                                         setEmail(event.target.value)
                                     }}/>
                                 </div></td>
                  </tr>
                  <tr>
                    <td><label>Mobile No</label></td>
                    <td><div className="form-group">
                                     
                                     <input type="number" className="form-control" value={mobileNo} onChange={(event) => {
                                         setMobileNo(event.target.value)
                                     }}/>
                                 </div></td>
                  </tr>
                  <tr>
                    <td><label>Address</label></td>
                    <td><div className="form-group">
                                     
                                     <input type="text" className="form-control" value={address}  onChange={(event) => {
                                         setAddress(event.target.value)
                                     }}/>
                                 </div></td>
                  </tr>
                  
                  
                  <tr>
                    <td></td>
                    <td><div className="button">
                      <br />
                      <button type="button" className="addBtn" onClick={EditProfile}>Confirm</button>
                    </div></td>
                  </tr>
                </tbody>
              </table>
            </form>
          </div>
        </div>
  
  
      </div>
  




    )
}
export default EditAgencyProfile