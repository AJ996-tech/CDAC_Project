import { useState } from 'react'
import {useHistory} from 'react-router-dom'
import axios from 'axios'
import Footer from './../Footer/Footer';
import { url } from './../../common/Constants';
import Navbar from './../Navbar/Navbar';

const AgencyLogIn = () =>{
    const history = useHistory()
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    const LogInAgency = () => {
        if (email.length === 0) {
            alert('Enter Email')
        }else if (password.length === 0) {
            alert('Enter Password')
        }else{
            const data = new FormData()
            data.append('Email', email)
            data.append('Password', password)

            history.push('/agency/home')

            axios.post(url + '/agency/login', data).then((response) => {
                const result = response.data
                if(result.status ==='success'){
                    history.push('/agency/home')
                    alert('Login Successfull!')
                    sessionStorage.setItem("id",result.data.agencyId)
                    history.push('/agency/home')
                }else{
                    history.push('/agencylogin')
                    alert('Login Failed!...Please try again!')
                    console.log(result.error)
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
                                    <h3 className="user">Agency Sign In</h3>
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
                                       <button type="submit" className="btn btn-primary " onClick={LogInAgency}>Sign In</button>
                                    </div>
                                    <div>
                                        <p className="forgot-password text-right">
                                            Forgot <a href="/agencyforgot">password?</a>
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
export default AgencyLogIn