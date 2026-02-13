import React, { useState } from 'react'
import FiveSubApp from './FiveSubApp'
import FiveSubApp2 from './FiveSubApp2'
import FiveSubApp3 from './FiveSubApp3'

const FiveApp = () => {

    const [number,setNumber]=useState(0);
    //증가
    const numberIncre=()=>{
        setNumber(number+1);
    }
    //감소
    const numberDecre=()=>{
        setNumber(number-1);
    }

  return (
    <div>
        <h3 className='alert alert-info'>FiveApp_부모자식 컴포넌트</h3>
        {/* 메인-부모만, 부모에-자식만 */}
        {/* App.jsx에 FiveSubApp 입력하면 안됨 */}
        <FiveSubApp name="미미" age="22"/>
        <FiveSubApp name="지지" age="26"/>
        <FiveSubApp name="루미" age="30"/>
        <br />
        <FiveSubApp2 flower="장미" price="15000" linecolor="red"/>
        <FiveSubApp2 flower="프리지아" price="21000" linecolor="yellow"/>
        <FiveSubApp2 flower="튤립" price="24000" linecolor="pink"/>
        <br />
        <div>{number}</div>
        <FiveSubApp3 incre={numberIncre} decre={numberDecre}/>
    </div>
  )
}

export default FiveApp