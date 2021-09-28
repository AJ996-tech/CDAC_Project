import './Payment.css'
import axios from 'axios'
import { useHistory } from 'react-router'
import { url } from './../../common/Constants';
import UserNavbar from './../UserNavbar/UserNavbar';
import UserLogIn from './../UserLogIn/UserLogIn';

const Payment = () =>{
    const trip = JSON.parse(sessionStorage.getItem("bus"))
    const seatNumber = sessionStorage.getItem("reservedSeats")
    const pickingPoint = sessionStorage.getItem("pickingPoint")
    const droppingPoint = sessionStorage.getItem("droppingPoint")

    const history = useHistory()

    const Proceed = () => {
        const id = sessionStorage.getItem("id")

        const data = new FormData()
        data.append('seatNumber',seatNumber)
        data.append('pickingPoint',pickingPoint)
        data.append('droppingPoint',droppingPoint)
        data.append('tripId',trip.tripId)
        data.append('userId',id)
        data.append('busNo',trip.busNo)

        axios.post(url + '/payment/details', data).then((response) => {
            const result = response.data
            if(result.status ==='success'){
                alert('Payment Successfull!')
                sessionStorage.setItem("result",JSON.stringify(result.data))
                history.push('/ticket')
            }else{
                console.log(result.error)
            }
        })
    }
    if(sessionStorage.getItem("id")!==null){
    return(
       <div>
           <UserNavbar/>
           <div className="container">
           <div className="row ">
           <div className="col-md-3"></div>
           <div className="col-md-6">
               <div className="card">
                   <h3 className="label1">Payment Method</h3>
                   <div className="accordion" id="accordionExample">
                       <div>
                           <div className="card-header p-0" id="headingTwo">
                               <h2 className="mb-0"> <button className="btn btn-light btn-block text-left collapsed p-3 rounded-0 border-bottom-custom" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                       <div className="d-flex align-items-center justify-content-between"> <span>Paypal</span> <img src="https://i.imgur.com/7kQEsHU.png" width="30"/> </div>
                                   </button> </h2>
                           </div>
                           <div id="collapseTwo" className="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                               <div className="card-body"> <input type="text" className="form-control" placeholder="Paypal email"/> </div>
                           </div>
                       </div>
                       <div className="card">
                           <div className="card-header p-0">
                               <h2 className="mb-0"> <button className="btn btn-light btn-block text-left p-3 rounded-0" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                       <div className="d-flex align-items-center justify-content-between"> <span>Credit card</span>
                                           <div className="icons"> <img src="https://i.imgur.com/2ISgYja.png" width="30"/> <img src="https://i.imgur.com/W1vtnOV.png" width="30"/> <img src="https://i.imgur.com/35tC99g.png" width="30"/> <img src="https://i.imgur.com/2ISgYja.png" width="30"/> </div>
                                       </div>
                                   </button> </h2>
                           </div>
                           <div id="collapseOne" className="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                               <div className="card-body payment-card-body"> <span className="font-weight-normal card-text">Card Number</span>
                                   <div className="input"> <i className="fa fa-credit-card"></i> <input type="text" className="form-control" placeholder="0000 0000 0000 0000"/> </div>
                                   <div className="row mt-3 mb-3">
                                       <div className="col-md-6"> <span className="font-weight-normal card-text">Expiry Date</span>
                                           <div className="input"> <i className="fa fa-calendar"></i> <input type="text" className="form-control" placeholder="MM/YY"/> </div>
                                       </div>
                                       <div className="col-md-6"> <span className="font-weight-normal card-text">CVC/CVV</span>
                                           <div className="input"> <i className="fa fa-lock"></i> <input type="text" className="form-control" placeholder="000"/> </div>
                                       </div>
                                   </div> <span className="text-muted certificate-text"><i className="fa fa-lock"></i> Your transaction is secured with ssl certificate</span>
                               </div>
                           </div>
                           <div className="p-3"> <button className="btn btn-primary btn-block free-button" onClick={Proceed}>Confirm Payment</button>
                       <div className="text-center"> <a href="#">Have a promo code?</a> </div>
                   </div>
                       </div>
                   </div>
               </div>
           </div>
           <div className="col-md-3"></div>
       </div> 
   </div>
       </div>
  
    )}else{return(<UserLogIn/>)}
}
export default Payment