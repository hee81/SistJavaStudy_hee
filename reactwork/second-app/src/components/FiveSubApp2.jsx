import React from 'react'

const FiveSubApp2 = ({flower,price,linecolor}) => {
  return (
    <div>
        <h4 style={{border:`1px solid ${linecolor}`}}>{flower} 1단의 가격은 {price}원 입니다</h4>
    </div>
  )
}

export default FiveSubApp2