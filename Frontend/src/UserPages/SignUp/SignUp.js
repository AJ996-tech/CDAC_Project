import { useState } from "react"
import {useHistory} from 'react-router-dom'
import axios from 'axios'
import './SignUp.css'
import { url } from './../../common/Constants';

const SignUp = () => {
    const[firstName,setFirstName] = useState("")
    const[lastName,setLastName] = useState("")
    const[gender,setGender] = useState("")
    const[email,setEmail] = useState("")
    const[mobileNo,setMobileNo] = useState("")
    const[address,setAddress] = useState("")
    const[password,setPassword] = useState("")

    const history = useHistory()

    const SignUpUser =() => {
        if(firstName.length === 0){
            alert('Enter First Name')
        }else if(lastName.length === 0){
            alert('Enter Last Name')
        }else if(gender.length === 0){
            alert('Enter Gender')
        }else if(email.length === 0){
            alert('Enter Email')
        }else if(password.length === 0){
            alert('Enter Password')
        }else if(mobileNo.length === 0){
            alert('Enter Mobile No')
        }else if(address.length === 0){
            alert('Enter Address')
        }else{
            console.log(`First Name : ${firstName}`)
            console.log(`Last Name : ${lastName}`)
            console.log(`Gender : ${gender}`)
            console.log(`Email : ${email}`)
            console.log(`Password: ${password}`)
            console.log(`Mobile No: ${mobileNo}`)
            console.log(`Address: ${address}`)

            const data = new FormData()
            data.append('firstName',firstName)
            data.append('lastName',lastName)
            data.append('gender',gender)
            data.append('email',email)
            data.append('password',password)
            data.append('mobileNo',mobileNo)
            data.append('address',address)

            history.push('/userlogin')

            axios.post(url + '/user/register', data).then((response) => {
                console.log(response.data)
                const result = response.data
                console.log(result)
                if(result.status ==='success'){
                    alert('Registered Successfully!')
                    history.push('/userlogin')
                }else{
                    console.log(result.error)
                    alert('Regisration Failed!...Please try again!')
                }
            })
        }
    }

    return (
        <div class="container p1">
            <div class="row">
                <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <div className="p-3 mb-2 bg-secondary text-white">
                            <form className="form-control">
                                <h3 className="user">Sign Up</h3>
                                <div className="form-group">
                                    <label>First Name</label>
                                    <input type="text" className="form-control" placeholder="First Name" onChange={(event) => {
                                        setFirstName(event.target.value)
                                    }} />
                                </div>
                                <div className="form-group">
                                    <label>Last Name</label>
                                    <input type="text" className="form-control" placeholder="Last Name" onChange={(event) => {
                                        setLastName(event.target.value)
                                    }} />
                                </div>
                                <div className="form-group">
                                    <label>Gender</label><br/>
                                    <div class="form-check form-check-inline">
                                      <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="M" onChange={(event) => {
                                        setGender(event.target.value)
                                    }}/>
                                      <label class="form-check-label">Male</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                      <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="F" onChange={(event) => {
                                        setGender(event.target.value)
                                    }}/>
                                      <label class="form-check-label">Female</label>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label>Email Address</label>
                                    <input type="email" className="form-control" placeholder="Enter Email" onChange={(event) => {
                                        setEmail(event.target.value)
                                    }}/>
                                </div>
                                <div className="form-group">
                                    <label>Password</label>
                                    <input type="password" className="form-control" placeholder="Enter Password" onChange={(event) => {
                                        setPassword(event.target.value)
                                    }}/>
                                </div>
                                <div className="form-group">
                                    <label>Mobile No</label>
                                    <input type="number" className="form-control" placeholder="Enter Mobile No" onChange={(event) => {
                                        setMobileNo(event.target.value)
                                    }}/>
                                </div>
                                <div className="form-group">
                                    <label>Address</label>
                                    <input type="text" className="form-control" placeholder="Enter City" onChange={(event) => {
                                        setAddress(event.target.value)
                                    }}/>
                                </div>
                                <div className="button1">
                                   <button type="submit" className="btn-primary" onClick={SignUpUser}>Sign Up</button>
                                </div>
                                <p className="user">
                                    Already registered <a href="userlogin">Sign In?</a>
                                </p>
                            </form>
                        </div>
                    </div>
                <div class="col-md-4"></div>
            </div>
        </div>
    )
}
export default SignUp