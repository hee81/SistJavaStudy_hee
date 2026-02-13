import React, { useState } from 'react'
import Alert from '@mui/material/Alert';

const FourApp = () => {

  const [boards,setBoards]=useState([
    {
      no:1,
      writer:'홍길동',
      subject:'안녕 오늘은 리액트',
      photo:'s1'
    },
    {
      no:2,
      writer:'이또치',
      subject:'오늘은 금요일',
      photo:'s2'
    },
    {
      no:3,
      writer:'김둘리',
      subject:'집에 가고 싶어',
      photo:'s3'
    }
  ])

  return (
    <div>
        <Alert severity="error">FourApp입니다</Alert>
        <table className='table table-bordered' style={{width:'400px'}}>
          <caption align='top'><b>배열객체출력</b></caption>
          <thead>
            <tr>
              <th width='60'>번호</th>
              <th width='60'>사진</th>
              <th width='60'>제목</th>
              <th width='60'>작성자</th>
            </tr>
          </thead>
          <tbody>
            {
              boards.map((row,index)=>(
                <tr key={index}>
                  <td>{row.no}</td>
                  <td><img src={`../${row.photo}.JPG`} style={{width:'50px'}}></img></td>
                  <td>{row.subject}</td>
                  <td>{row.writer}</td>
                </tr>
              ))
            }
          </tbody>
          
        </table>
    </div>
  )
}

export default FourApp