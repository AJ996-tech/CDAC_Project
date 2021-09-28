import InnerNavbar from "../InnerNavbar/InnerNavbar"
import {useState} from "react"
import axios from 'axios'
import { url } from "../Common/Constant"
import { useHistory } from "react-router-dom"
import './AgencyPassword.css'
const AgencyPassword =()=>{
    const [oldPassword, setOldPassword] = useState("")
    const [newPassword, setNewPassword] = useState("")
    const [confirmPassword, setConfirmPassword] = useState("")
    let history= useHistory()
    const changePassword = () => {
        if (oldPassword.length === 0) {
            alert('Enter old Password')
        }else if(newPassword.length === 0){
            alert('Enter New Password')
        }else if(confirmPassword.length === 0){
            alert('Enter Confirm Password')
        }else if(confirmPassword !== newPassword){
            alert('Please enter password again!')
        }else{
            const data = new FormData()
            const id = sessionStorage.getItem("id")
            data.append('id',id)
            data.append('oldPassword',oldPassword)
            data.append('newPassword',newPassword)

            history.push('/agency/home')

            axios.post(url + '/agency/changePassword',data).then((response) => {
                const result = response.data
                if(result.status ==='success'){
                    alert('Password Changed Successfully!')
                    history.push('/agency/home')
                }else{
                    console.log(result.error)
                    alert('Invalid input!')
                }
            })
        }
    }

return(
    <div className="body1">

   <InnerNavbar/>
    <div class="container row">
        <div className="list3">
            <h3 className="label1">Change Password</h3>
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
                        <td><label>Old Password</label></td>
                        <td><div className="form-group">
                    <input type="password" className="form-control" placeholder="Enter Password" onChange={(event) => {
                        setOldPassword(event.target.value)
                    }}/>
                </div></td> 
                    </tr>
                    <tr>
                        <td><label>New Password</label></td>
                        <td><div className="form-group">
                    <input type="password" className="form-control" placeholder="Enter Password" onChange={(event) => {
                        setNewPassword(event.target.value)
                    }}/>
                </div></td> 
                    </tr>
                    <tr>
                        <td><label>Confirm Password</label></td>
                        <td><div className="form-group">
                    <input type="password" className="form-control" placeholder="Enter Password" onChange={(event) => {
                        setConfirmPassword(event.target.value)
                    }}/>
                </div></td> 
                    </tr>
                    <tr>
                        <td></td>
                        <td><button type="submit" className="passBtn" onClick={changePassword}>Change</button></td>
                    </tr>
                </tbody>
            </table>
            </form>
        </div>

    </div>


</div>
)
}

export default AgencyPassword