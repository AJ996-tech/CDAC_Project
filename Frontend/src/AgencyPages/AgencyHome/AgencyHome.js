import { useHistory } from 'react-router-dom'
import axios from 'axios'
import { useState, useEffect } from 'react'
import InnerNavbar from '../InnerNavbar/InnerNavbar'
import { url } from '../Common/Constant';
import './AgencyHome.css'
const AgencyHome=() =>{
       useEffect(() => {       
          getTrips()
        }, [])
    const [trips, setTrips] = useState([])
    let history= useHistory()  
  
     const deleteTrip=(trip)=>{
       console.log(trip)
       sessionStorage.setItem("trip",JSON.stringify(trip))
       history.push("/agency/deleteTrip")
     }
     const editTrip=(trip)=>{
      console.log(trip)
      sessionStorage.setItem("trip",JSON.stringify(trip))
      history.push("/agency/editTrip")
     // history.push("/agency/editTrip",{trip: trip})
    }
    const viewTrip=(trip)=>{
      console.log(trip)
      sessionStorage.setItem("trip",JSON.stringify(trip))
      history.push("/agency/viewTrip")
    }
      const getTrips = () => {
        const id=sessionStorage.getItem("id")
        axios.get(url + '/agency/home/' + id).then((response) => {
          const result = response.data
          if (result.status === 'success') {
            setTrips(result.data)
            history.push('/agency/home')
          } else {
            alert('error while loading list of trips')
          }
        })
    }
   
return(
<div>
            <InnerNavbar/>      
            <div class="container row">
            <div className="list3">
            <h3 className="label1">Recent Trip Schedule</h3>
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
                        <th>###</th>
                        <th>###</th>
                        <th>###</th>
                    </tr>
                </thead>
                <tbody>
                  {
                      trips.map((trip)=>{
                          return (
                              <tr>
                                  <td>{trip.tripId}</td>
                                  <td>{trip.busno}</td>
                                  <td>{trip.busType}</td>
                                  <td>{trip.fromStation}</td>
                                  <td>{trip.toStation}</td>
                                  <td>{trip.date}</td>
                                  <td>{trip.arrivalTime}</td>
                                  <td>{trip.departureTime}</td>
                                  <td>{trip.ticketPrice}</td>
                                  <td><button type="button" className="viewBtn"  onClick={()=>{viewTrip(trip)}}>View</button></td>
                                  <td><button type="button" className="editBtn" onClick={()=>{editTrip(trip)}}>Edit</button></td>
                                  <td><button type="button" className="deleteBtn" onClick={()=>{deleteTrip(trip)}} >Delete</button></td>
                                </tr>
                          )
                      })
                  }

                </tbody>
            </table>
        </div>
            </div>


</div>
);
}


// export default AgencyHome

export default AgencyHome