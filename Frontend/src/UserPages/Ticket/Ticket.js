import './Ticket.css'
import axios from 'axios'
import { useState} from 'react'
import UserNavbar from './../UserNavbar/UserNavbar';
import UserLogIn from './../UserLogIn/UserLogIn';
import { url } from './../../common/Constants';

const Ticket = () => {
    const ticket = JSON.parse(sessionStorage.getItem("result"))
    const [email, setEmail] = useState("")

    const SendEmail = () => {
        if(email.length === 0) {
            alert("Enter Email")
        }else{
            axios.post(url + "/ticket/sendemail/"+ email).then((response)=>{
                const result = response.data
                if(result.status === 'success'){
                    console.log(result.data)
                }else{
                    console.log(result.error)
                }
            })
        }
    }

    if(sessionStorage.getItem("id")!==null){
    return (
        <div>
            <UserNavbar/>
            <div className="container">
           <div className="row">
                <div className="col-md-3"></div>
                    <div className="col-md-6 tdiv">
                        <h3 className="label">Happy Journey!</h3>
                        <table className="table table-responsive">
                            <tr>
                                <td>
                                    <th>Ticket Id :</th>
                                    <td className="td">{ticket.ticketId}</td>
                                </td>
                                <td>
                                    <th>Date :</th>
                                    <td className="td">{ticket.date}</td>
                                </td>
                                <td>
                                    <th>Price :</th>
                                    <td className="td">{ticket.ticketPrice * ticket.seatNo.length} /-</td>
                                </td>
                            </tr>
                        </table>
                        <table className="table table-bordered table-condensed ticket1">
                            <tr>
                                <td colspan="2">
                                   <th>Name :</th>
                                   <td></td>
                                   <td className="td">{ticket.name}</td>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <th>From :</th>
                                    <td></td>
                                    <td className="td">{ticket.fromStation}</td>
                                </td>
                                <td></td>
                                <td>
                                    <th>To :</th>
                                    <td></td>
                                    <td className="td">{ticket.toStation}</td>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <th>Seat No :</th>
                                    <td></td>
                                    <td className="td">{
                                        ticket.seatNo.map((sNo)=>{
                                            return(
                                                sNo + "  "
                                            )
                                        })}</td>
                                </td>
                                <td></td>
                                <td>
                                    <th>Bus No :</th>
                                    <td></td>
                                    <td className="td">{ticket.busNo}</td>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <th>Picking Point :</th>
                                    <td></td>
                                    <td className="td">{ticket.pickingPoint}</td>
                                </td>
                                <td></td>
                                <td>
                                    <th>Dropping Point :</th>
                                    <td></td>
                                    <td className="td">{ticket.droppingPoint}</td>
                                </td>
                            </tr>
                        </table>
                        <div className="p-3 mb-2 bg-primary text-white">
                            <form className="form-control">
                                <h3 className="user">Send Email</h3><br/>
                                <div className="form-group">
                                    <label>Email Address</label>
                                    <input type="email" className="form-control" placeholder="Enter Email" onChange={(e)=>{
                                            setEmail(e.target.value);
                                        }}/>
                                </div>
                                <div className="button1">
                                   <button type="submit" className="btn-primary" onClick={SendEmail}>Confirm</button>
                                </div>
                            </form>
                        </div>
                    </div>
                <div className="col-md-3"></div>
            </div>
        </div>
        </div>
    )}else{return(<UserLogIn/>)}
}
export default Ticket