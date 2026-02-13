import React from 'react'
import '../App.css';

const FiveSubApp = (props) => {

    console.dir(props);

  return (
    <div>
        <div className='line'>{props.name}님의 나이는 {props.age}세 입니다</div>
    </div>
  )
}

export default FiveSubApp