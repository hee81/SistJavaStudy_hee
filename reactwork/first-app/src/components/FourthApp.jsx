import React, { useState } from 'react'
import './Mystyle.css';

const FourthApp = () => {

    const [name,setName]=useState('마이클');
    const [java,setJava]=useState(0);
    const [spring,setSpring]=useState(0);
    const [total,setTotal]=useState(0);
    const [avg,setAvg]=useState(0);

  return (
    <div>
        <h2 className='alert alert-warning'>FourthApp</h2>

        <div className='inp'>
            이름: <input type='text' style={{width:'150px'}} onChange={(e)=>setName(e.target.value)} ></input><br/>
            <span>{name}</span><br/>
            자바점수: <input type='text' style={{width:'150px'}} onChange={(e)=>setJava(e.target.value)}></input><br/>
            <span>{java}</span><br/>
            스프링: <input type='text' style={{width:'150px'}} onChange={(e)=>setSpring(e.target.value)} ></input><br/>
            <span>{spring}</span><br/>
            <button type='button' className='btn btn-success' onClick={()=>{
                setTotal(Number(java)+Number(spring))
                setAvg((Number(java)+Number(spring))/2.0)
            }}>결과확인</button>
        </div>
        <div className='outp'>
            이름: {name}<br/>
            자바점수: {java}점<br/>
            스프링: {spring}점<br/>
            총점:{total}점<br/>
            평균:{avg}점<br/>
        </div>
    </div>
  )
}

export default FourthApp