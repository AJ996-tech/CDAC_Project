import { useState } from "react"
import {useHistory, useLocation} from 'react-router-dom'
import axios from 'axios'
import './EditAdminProfile.css'
import { url } from '../../common/Constants';

const EditAdminProfile = () => {
    const history = useHistory()
    const location = useLocation()
    const profile = location.state.profile
    
    const[name,setName] = useState(profile.name)
    const[email,setEmail] = useState(profile.email)

    const EditProfile =() => {
        if(name.length === 0){
            alert('Enter Name')
        }else if(email.length === 0){
            alert('Enter Email')
        }else{
            const data = new FormData()
            data.append('name',name)
            data.append('email',email)
            
            history.push('/agencylist')

            const id = sessionStorage.getItem("id")

            axios.put(url + '/admin/update/'+ id, data).then((response) => {
                // console.log(response.data)
                const result = response.data
                // console.log(result)
                if(result.status ==='success'){
                    alert('Updated Successfully!')
                    history.push('/agencylist')
                }else{
                    console.log(result.error)
                    alert('Updation Failed!...Please try again!')
                }
            })
        }
    }

    return (
        <div class="container">
            <div class="row">
                <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <div className="edit p-3 mb-2 bg-secondary text-white">
                            <form className="form-control">
                                <h3 className="user">Update Info</h3>
                                <div className="form-group">
                                    <label>Name</label>
                                    <input type="text" className="form-control" placeholder="First Name"  value={name} onChange={(event) => {
                                        setName(event.target.value)
                                    }} />
                                </div>
                                <div className="form-group">
                                    <label>Email Address</label>
                                    <input type="email" className="form-control" placeholder="Enter Email" value={email} onChange={(event) => {
                                        setEmail(event.target.value)
                                    }}/>
                                </div>
                                <div className="button1">
                                   <button type="submit" className="btn-primary" onClick={EditProfile}>Update</button>
                                </div>
                            </form>
                        </div>
                    </div>
                <div class="col-md-4"></div>
            </div>
        </div>
    )
}
export default EditAdminProfile