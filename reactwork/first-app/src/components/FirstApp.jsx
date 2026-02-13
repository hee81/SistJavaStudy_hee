import React from 'react'
import './Mystyle.css';
import img1 from '../image/만화이미지/01.png';
import img2 from '../image/flower_ani/s1.jpg';

const FirstApp = () => {

    //스타일을 변수에 저장
    const styleImg1={
        width:'200px',
        border:'5px insert gray',
        marginTop:'20px'
    }

  return (
    <div>
        <h2 className='line'>FirstApp</h2>
        {/* 글씨에 스타일 직접 지정 */}
        <div style={{fontSize:'30px',color:'green',marginLeft:'100px',fontFamily:'Dongle'}}>안녕 리액트!</div>
        {/* 1번 이미지를 넣고 스타일 지정 */}
        <img src={img1} alt="" style={styleImg1}/>
        {/* 2번 이미지를 넣고 스타일 직접 지정-너비,테두리 */}
        <img src={img2} alt="" style={{width:'200px',border:'1px dotted green',borderRadius:'30px',marginLeft:'30px'}}/>
        {/* public 영역 이미지는 직접 호출 가능-직접경로만 가능 */}
        <img src="../a.png" alt="" />
    </div>
  )
}

export default FirstApp