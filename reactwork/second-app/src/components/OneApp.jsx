import React from 'react'
import Alert from '@mui/material/Alert';
import AccessTimeIcon from '@mui/icons-material/AccessTime';

const OneApp = () => {
  return (
    <div>
        <Alert severity="success" >OneApp입니다</Alert>
        <AccessTimeIcon color='success'></AccessTimeIcon>
    </div>
  )
}

export default OneApp