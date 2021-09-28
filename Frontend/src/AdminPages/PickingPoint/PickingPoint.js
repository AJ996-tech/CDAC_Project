import React from "react";
import { useState, useEffect } from "react";
import { useHistory } from 'react-router-dom';
import axios from 'axios'
import { Link } from "react-router-dom";
import './PickingPoint.css'

const AddPickingPoint = () => {
    const [name,setName]=useState("")
    const history = useHistory();
    const[pickingPoints, setPickingPoint] =useState([])
    
    const routeId = sessionStorage.getItem("routeId")

    useEffect(() => {
        getPickingPoints();
     }, []);
 
     const getPickingPoints = () => {
         axios.get('http://localhost:8080/route/getpickingpoint/'+ routeId).then((response) => {
           const result = response.data
           if (result.status === 'success') {
            setPickingPoint(result.data)
           } else {
             alert('error while loading list of Routes')
           }
         })
       }

    const addStationToDB = () =>{
      if(name.length === 0){
        alert('Enter station name')
      }else{
        const data = new FormData()
        data.append('name',name)
        // data.append('routeId',routeId)

        axios.post('http://localhost:8080/route/addpickingpoint/'+ routeId,data).then ((response) =>{
          const result = response.data
          if(result.status === 'success'){
            alert('successfully added station')
            history.push('/routelist')
          }else{
            alert('error while adding station')
          }
        })
      }
    }

    return(
      <div>
          <div className="container w-50">
          <div class="col-md-4"></div>
        <h1 className="text-center mb-4">Add New Picking Point</h1><hr/>
        <form >
          <div className="form-group">
            <label for="inputEmail3" class="col-sm-2 col-form-label"><h3>Name  </h3></label>
            <input type="text"
                   className="form-control form-control-md" 
                   placeholder="Enter Station Name"
                   onChange={(e) => {
                    setName(e.target.value)
                  }}
            />
          </div>
          <button onClick={addStationToDB} type="submit" class="btn btn-success">Confirm</button>
          
          <Link to="/routelist">
          <a className="btn btn-warning">Back</a>
        </Link>
          </form>
      </div>
      
      <div className="list2">
            <h3 className="label1">Picking Point List</h3>
            <table className="table table-responsive table-striped table-hover">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Id</th>
                    <th></th>
                   <th>Name</th>
                    </tr>
                </thead>
                <tbody>
              {pickingPoints.map((point)=>{
                  return(
                      <tr>
                          <td></td>
                          <td></td>
                          <td>{point.id}</td>
                          <td></td>
                          <td>{point.name}</td>
                      </tr>
                  )
              })}
          </tbody>
            </table>
        </div>
      </div>
      
    )

}

export default AddPickingPoint;