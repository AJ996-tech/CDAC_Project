import InnerNavbar from "../InnerNavbar/InnerNavbar"
import { useHistory } from 'react-router-dom'
import axios from 'axios'
import { url } from '../Common/Constant'
import { useState } from 'react'
import './NewBus.css'

const NewBus = () => {
    let history = useHistory()

    const [busNo, setBusNo] = useState()
    const [busType, setBusType] = useState()
    const [busModel, setBusModel] = useState()

    const addBus = () => {
        if (busNo === "") {
            alert('enter Bus No')
        } else if (busModel === "") {
            alert('enter bus Model')
        } else if (busType === "") {
            alert('enter bus Type')
        } else {
            const id = sessionStorage.getItem("id")
            const data = new FormData()
            data.append('busNo', busNo)
            data.append('model', busModel)
            data.append('type', busType)
            data.append('agencyId', id)
             history.push('/agency/home')
            axios.post(url + '/bus/add', data).then((response) => {
                const result = response.data
                console.log(result)
                if (result.status === 'success') { 
                    alert('Bus added successfully')
                    history.push('/agency/home')
                    
                } else {
                    
                    console.log(result.error)
                   
                    alert('Error in Bus Addition')
                    
                }
            })
        }
    }



    return (
        <div>
            <InnerNavbar />
            <div class="container row">
                <div className="list3">
                    <h3 className="label1">Add New Bus</h3>

                    <form className="form-control">
                        <table className="table table-responsive table-striped table-hover styled-table">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td> <label>Bus No</label></td>
                                    <td><div className="form-group">
                                        <input type="text" className="form-control" placeholder="Enter Bus No" onChange={(e) => {
                                            setBusNo(e.target.value)
                                        }} />
                                    </div></td>
                                </tr>
                                <tr>
                                    <td><label>Bus Type</label> </td>
                                    <td> <div>

                                        <select class="form-select" aria-label="Default select example" onChange={(e) => {
                                            setBusType(e.target.value)
                                        }}>
                                            <option selected> select Bus Type</option>
                                            <option value="A/C">A/C</option>
                                            <option value="Non A/C">Non A/C</option>
                                        </select>
                                    </div></td>
                                </tr>
                                <tr>
                                    <td><label>Model</label></td>
                                    <td> <div className="form-group">

                                        <input type="text" className="form-control" placeholder="Enter model" onChange={(e) => {
                                            setBusModel(e.target.value)
                                        }} />
                                    </div></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><div className="button">
                                        <br />
                                        <button type="submit" className="addBtn" onClick={addBus}>Add Bus</button>
                                    </div></td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>


        </div>





    )
}

export default NewBus