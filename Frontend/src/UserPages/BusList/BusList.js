import {useState , useEffect} from 'react'
import {useHistory } from 'react-router'
import axios from 'axios'
import  './BusList.css'
import { url } from './../../common/Constants';
import UserNavbar from './../UserNavbar/UserNavbar';
import Footer from './../Footer/Footer';
import UserLogIn from './../UserLogIn/UserLogIn';  

const BusList = () => {
    const fromStation = sessionStorage.getItem("fromStation")
    const toStation = sessionStorage.getItem("toStation")
    const date = sessionStorage.getItem("date")
    const history = useHistory()
    const [buses,setBuses] = useState([])

    useEffect(() => {
        getBuses()
    },[])

    const getBuses = () => {
        const data = new FormData()
        data.append("fromStation",fromStation)
        data.append("toStation",toStation)
        data.append("date",date)

        axios.post(url + '/trip/buses',data).then((response) => {
            const result = response.data
            if(result.status ==='success'){
                //alert('Successfull!')
                setBuses(result.data)
            }else{
                console.log(result.error)
                alert('Failed!...Please try again!')
            }
        })
    }
function ViewSeats(bus){
    sessionStorage.setItem("bus",JSON.stringify(bus))
    history.push('/seatselection')
}
if(sessionStorage.getItem("id")!==null){
    return(
        <div>
            <UserNavbar/>
        <div className="container row">
        <div className="col-md-4"></div>
        <div className="col-md-4 list11">
            <h3 className="label1">Available Buses</h3>
            <table className="table table-responsive table-striped table-hover styled-table">
                <thead>
                    <tr>
                        <th>Agency Name</th>
                        <th>Bus No</th>
                        <th>Bus Type</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Departure Time</th>
                        <th>Arrival Time</th>
                        <th>Date</th>
                        <th>Price</th>
                        <th>View</th>
                    </tr>
                </thead>
                <tbody>
                        {buses.map((bus)=>{
                            return(
                                <tr>
                                <td>{bus.name}</td>
                                <td>{bus.busNo}</td>
                                <td>{bus.busType}</td>
                                <td>{bus.fromStation}</td>
                                <td>{bus.toStation}</td>
                                <td>{bus.departureTime}</td>
                                <td>{bus.arrivalTime}</td>
                                <td>{bus.date}</td>
                                <td>{bus.ticketPrice}</td>
                                <td><button type="submit" className="btn btn-outline-success" onClick={()=>{ViewSeats(bus)}}>View Seats</button></td>
                                </tr>
                            )
                        })}
                </tbody>
            </table>
        </div>
        <div className="col-md-4"></div>
        </div>
        <Footer/>
        </div>
    )}else{return(<UserLogIn/>)}
}
export default BusList