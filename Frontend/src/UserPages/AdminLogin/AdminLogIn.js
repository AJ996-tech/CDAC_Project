import { useState } from 'react'
import {useHistory} from 'react-router-dom'
import axios from 'axios'
import Footer from './../Footer/Footer'
import { url } from './../../common/Constants';
import Navbar from './../Navbar/Navbar';

const AdminLogIn = () =>{
    const history = useHistory()
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    const LogInAdmin = () => {
        if (email.length === 0) {
            alert('Enter Email')
        }else if (password.length === 0) {
            alert('Enter Password')
        }else{
            const data = new FormData()
            data.append('Email',email)
            data.append('Password',password)

            history.push('/agencylist')

            axios.post(url + '/admin/login', data).then((response) => {
                const result = response.data
                if(result.status ==='success'){
                    alert('Login Successfull!')
                    sessionStorage.setItem("id", result.data.adminId)
                    history.push('/agencylist')
                }else{
                    console.log(result.error)
                    alert('Login Failed!...Please try again!')
                }
            })
        }
    }
    return (
        <div>
            <Navbar/>
            <div class="container-fluid p">
                <div class="row">
                    <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <div className="div1 p-3 mb-2 bg-secondary text-white">
                                <form className="form-control">
                                    <h3 className="user">Admin Sign In</h3>
                                    <div className="form-group">
                                        <label>Email</label>
                                        <input type="email" className="form-control" placeholder="Enter Email" onChange={(e)=>{
                                            setEmail(e.target.value);
                                        }}/>
                                    </div>
                                    <div className="form-group">
                                        <label>Password</label>
                                        <input type="password" className="form-control" placeholder="Enter Password" onChange={(e)=>{
                                            setPassword(e.target.value);
                                        }}/>
                                    </div>
                                    <div className="button1">
                                       <button type="submit" className="btn btn-primary " onClick={LogInAdmin}>Sign In</button>
                                    </div>
                                    <div>
                                        <p className="forgot-password text-right">
                                            Forgot <a href="/adminforgot">password?</a>
                                        </p>
                                    </div>
                                </form>
                            </div>
                        </div>
                    <div class="col-md-4"></div>
                </div>
            </div>
            <Footer/>
        </div>
    );
}
export default AdminLogIn