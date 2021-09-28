import React from "react";
import { useState, useEffect } from "react";
import axios from 'axios'
import { Link} from "react-router-dom";
import { url } from './../../common/Constants';
import './AddRoute.css'

const AddRoute = () => {
  const [routeName,setName]=useState("") 
  const [fromStation,setFromStation]=useState("") 
  const [toStation,setToStation]=useState("") 
  const [stations, setStation] = useState([])

  useEffect(() => {
    getStations()
  }, [])

  const getStations = () =>{
    axios.get(url + '/station/routes').then((response) => {
      const result = response.data
            if(result.status ==='success'){
              setStation(result.data)
              // history.push('/routes')
            }else{
              console.log(result.error)
              alert('Bus not found!')
            }
    })
  }

    const addRouteToDB = () =>{
      if(fromStation.length === 0){
        alert('Select From Station Name')
      }else if(toStation.length === 0){
        alert('Select To Station Name')
      }else {
        const data = new FormData()

        data.append('fromStation',fromStation)
        data.append('toStation',toStation)

        console.log(data.getAll)

        axios.post('http://localhost:8080/route/addroute',data).then ((response) =>{
          const result = response.data
          if(result.status === 'success'){
            alert('successfully added route')
           // history.push('/agencylist')
          }else{
            alert('error while adding route')
          }
        })
      }
    }

    return(
      <div className="container w-50">
          <div class="col-md-4"></div><br></br><br></br><br></br>
        <h1 className="text-center card ">Add New route</h1>
        <form >
        <div className="input-group">
            <span className="input-group-text">From</span>
            <input className="form-control" list="datalistOptions" placeholder="Select Source"  onChange={(event) => {setFromStation(event.target.value)}}/>
            <datalist id="datalistOptions">
              {stations.map((station)=>{
                  // return <TripRow station = {station}/>
                  return <option value={station.name}>{station.name}</option>
              })}
            </datalist>
            
            <span className="input-group-text">To</span>
            <input className="form-control" list="datalistOptions" placeholder="Select Destination" onChange={(event) => {setToStation(event.target.value)}}/>
            <datalist id="datalistOptions">
            {stations.map((station)=>{
                  // return <TripRow station = {station}/>
                  return <option value={station.name}>{station.name}</option>
              })}
            </datalist>
          </div>

          <br></br>
          <button onClick={addRouteToDB} type="submit" class="btn btn-success"  >Confirm</button>&nbsp;&nbsp;
          
          <Link to="/routelist">
          <a className="btn btn-warning">Back</a>
        </Link>

          </form>
          
        
      </div>
      
    )

}

export default AddRoute;