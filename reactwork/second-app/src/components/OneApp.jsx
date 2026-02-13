import React, { useState } from 'react'
import Alert from '@mui/material/Alert';
import AccessTimeIcon from '@mui/icons-material/AccessTime';
import './Mystyle.css'

const OneApp = () => {

    const [number,setNumber]=useState(0);
    const numberIncre=()=>{
        if(number==10){
            alert("10까지만 증가됩니다")
            return
        }
        setNumber(number+1);
    }
    const numberDecre=()=>{
        if(number==0){
            alert("0까지만 감소됩니다")
            return
        }
        setNumber(number-1);
    }

  return (
    <div>
        <Alert severity="success" >OneApp입니다</Alert>
        <AccessTimeIcon color='success'></AccessTimeIcon>

        <div className='number'>{number}</div>
        <button type='button' onClick={numberIncre}>증가</button>
        <button type='button' onClick={numberDecre} style={{marginLeft:'20px'}}>감소</button>
    </div>
  )
}

export default OneApp