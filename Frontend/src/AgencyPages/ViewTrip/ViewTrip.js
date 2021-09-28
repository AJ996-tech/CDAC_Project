import InnerNavbar from './../InnerNavbar/InnerNavbar';
import { useLocation } from 'react-router-dom';
import { useState, useEffect } from 'react';
import axios from 'axios'
import { url } from '../Common/Constant';
import './ViewTrip.css'
const ViewTrip = () => {
    const [bookedSeats, setBookedSeats] = useState([])
    const [tickets, setTickets] = useState([])

    const trip =JSON.parse(sessionStorage.getItem("trip"))

    useEffect(() => {
        getBookedSeats()
        getTicketDetails()
    }, [])

    const getBookedSeats = () => {
        axios.get(url + '/trip/getseats/' + trip.tripId).then((response) => {
            const result = response.data
            if (result.status === 'success') {
                console.log(result.data)
                setBookedSeats(result.data)
            } else {
                console.log(result.error)
                alert("No Seat Booked")
            }
        })
    }

    const getTicketDetails = () => {
        axios.get(url + '/trip/bookings/' + trip.tripId).then((response) => {
            const result = response.data
            if (result.status === 'success') {
                console.log(result.data)
                setTickets(result.data)
            } else {
                console.log(result.error)

            }
        })
    }




    return (
        <div className="body1">
            <InnerNavbar />
            <div class="container">



                <div className="list1">
                    <h3 className="label1">Trip Details</h3>
                    <div>
                    <table className="table table-responsive table-striped table-hover styled-table">
                        <thead>
                            <tr>
                                <th>Trip Id</th>
                                <th>Bus Number</th>
                                <th>Bus Type</th>
                                <th>From</th>
                                <th>To</th>
                                <th>Date</th>
                                <th>Arrival Time</th>
                                <th>Departure Time</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <td>{trip.tripId}</td>
                                <td>{trip.busno}</td>
                                <td>{trip.busType}</td>
                                <td>{trip.fromStation}</td>
                                <td>{trip.toStation}</td>
                                <td>{trip.date}</td>
                                <td>{trip.arrivalTime}</td>
                                <td>{trip.departureTime}</td>
                                <td>{trip.ticketPrice} /-</td>
                            </tr>
                        </tbody>
                    </table>
                    </div>
                    <div>
                        <tr>
                            <td><h5>Booked Seats :</h5></td>
                            <td className="bs">{
                                bookedSeats.map((bs) => {
                                    return (
                                        bs + " "
                                    )
                                })
                            }
                            </td>
                        </tr>
                    </div>
                    <div>
                        <h5>Booking Details</h5>
                        <table className="table table-responsive table-striped table-hover styled-table">
                            <thead>
                                <th>Ticket ID</th>
                                <th>User ID</th>
                                <th>User Name</th>
                                <th>Picking Point</th>
                                <th>Dropping Point</th>
                                <th>Seats</th>
                                <th>Total</th>

                            </thead>
                            <tbody>
                                {
                                    tickets.map((ticket) => {
                                        return (
                                            <tr>
                                                <td>{ticket.ticketId}</td>
                                                <td>{ticket.userId}</td>
                                                <td>{ticket.name}</td>
                                                <td>{ticket.pickingPoint}</td>
                                                <td>{ticket.droppingPoint}</td>
                                                <td>{ticket.seatNo.map((s) => {
                                                    return (s + " ")
                                                })}</td>
                                                <td> {ticket.totalTicketPrice} /-</td>
                                            </tr>
                                        )
                                    })
                                }
                            </tbody>
                        </table>
                    </div>

                </div>




            </div>


        </div>




    )
}
export default ViewTrip