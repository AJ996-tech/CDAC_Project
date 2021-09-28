import React from "react";
import { useState } from "react";
import axios from 'axios'


import { Link,useHistory } from "react-router-dom";

const AddStation = () => {// file name and function name should be same

  const [name,setName]=useState("")
    // const [address,setAddress]=useState("")
    const [city,setCity]=useState("")

    const history = useHistory();
    
    const addStationToDB = () =>{
      if(name.length === 0){
        alert('Enter station name')
      }else if(city.length===0){
        alert('Enter station city')
      }else{

        const data = new FormData()

        data.append('name',name)
        // data.append('address',address)
        data.append('city',city)

        console.log(data.getAll)

        axios.post('http://localhost:8080/station/addstation',data).then ((response) =>{
          const result = response.data
          if(result.status === 'success'){
            alert('successfully added station')

           // history.push('/agencylist')
          }else{
            alert('error while adding station')
          }
        })
      }
    }

    return(
      <div className="list1">
      <div className="container w-50">
          <div class="col-md-4"></div><br></br>
        <h1 className="text-center card cul">Add New Station</h1><hr/>
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

          <div className="form-group">
            <label for="inputEmail3" class="col-sm-2 col-form-label"><h3>City</h3></label>
            <input type="text" 
                   className="form-control form-control-md" 
                   placeholder="Enter Station City"
                   onChange={(e) => {
                    setCity(e.target.value)
                  }}
            />
          </div>
          <br></br>
          <button onClick={addStationToDB} type="submit" class="btn btn-success"  >Confirm</button>&nbsp;&nbsp;
          
          <Link to="/stationlist">
          <a className="btn btn-warning">Back</a>
        </Link>
          </form>
      </div>
      
      </div>
    )

}

export default AddStation;