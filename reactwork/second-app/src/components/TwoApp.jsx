import React from 'react'
import Alert from '@mui/material/Alert';
import './Mystyle.css'
import img1 from '../components/image/만화이미지/01.png';
import img2 from '../components/image/만화이미지/02.png';
import img3 from '../components/image/만화이미지/03.png';
import img4 from '../components/image/만화이미지/04.png';

const TwoApp = () => {

    //배열 변수 선언
    const names=['홍길동','이또치','고길동','김둘리'];
    //반복문 변수에 저장 후 출력해도된다.
    const nameList=names.map((name)=>(<li>{name}</li>))
    //색상을 배열로
    const colors=['red','blue','yellow','purple','green']

    const imgArr=[img1,img2,img3,img4]

  return (
    <div>
        <Alert severity="info">TwoApp입니다</Alert>
        <div>
          <h3>map 반복문 연습</h3>
          <ol>{nameList}</ol>
          <hr />

          <ul>
            {
              //반복문을 리턴에 직접준다
              names.map((name,index)=>(<b style={{marginLeft:'10px'}}>{index}:{name}</b>))
            }
          </ul>
          <hr />

          {
            colors.map((color)=>(<div className='box' style={{backgroundColor:color}}></div>))
          }
          <hr />

          <h4>src의 이미지를 배열로 넣어 반복하기_너비100</h4>
          {
            imgArr.map((myimg)=>(<img src={myimg} style={{width:'100px'}}></img>))
          }
        </div>
    </div>
  )
}

export default TwoApp