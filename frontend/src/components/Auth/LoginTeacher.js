/* eslint-disable react-hooks/rules-of-hooks */
import React, { useState, useContext } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import background from '../../assets/teacher.jpg'
import {
  MDBBtn,
  MDBContainer,
  MDBCard,
  MDBCardBody,
  MDBRow,
  MDBInput,
  MDBCheckbox,
} from 'mdb-react-ui-kit';

function LoginTeacher() {
  let navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loggedInTeacher, setLoggedInTeacher] = useState(null); // Track the logged-in teacher
  

  const handleSignIn = () => {
    const data = { email, password };
    setLoggedInTeacher(loggedInTeacher);

    axios
      .post('http://localhost:8001/api/enseignants/login', data)
      .then(response => {
        // Store the logged-in teacher information
        setLoggedInTeacher(response.data);

        // Navigate to the teacher profile page with email and password as parameters
        navigate(`/teacher/view-profile/${email}/${password}`);
      })
      .catch(error => {
        // Display an alert message
        alert('Error: ' + error.message);
        navigate('/');
      });
  };

  return (
    <MDBContainer fluid>
      <div className="p-5 bg-image" style={{backgroundImage: `url(${background})`, height: '500px', backgroundSize: 'cover'}}></div>

      <MDBCard className='mx-5 mb-5 p-5 shadow-5' style={{marginTop: '-100px', background: 'hsla(0, 0%, 100%, 0.8)', backdropFilter: 'blur(30px)'}}>
        <MDBCardBody className='p-5 text-center'>
          <h2 className="fw-bold mb-5">Connectez-vous à l'espace enseignant</h2>
          <MDBRow>
            <MDBInput wrapperClass='mb-4 w-60' label='Email' id='form1' type='text' onChange={(event) => setEmail(event.target.value)}/>
            <MDBInput wrapperClass='mb-4' label='Password' id='form1' type='password' onChange={(event) => setPassword(event.target.value)}/>
          </MDBRow>
          <div className='d-flex justify-content-center mb-4'>
            <MDBCheckbox name='flexCheck' value='' id='flexCheckDefault' label='Remember me' />
          </div>
          <MDBBtn className='w-50 mb-4' size='md' onClick={handleSignIn}>Sign In</MDBBtn>
        </MDBCardBody>
      </MDBCard>
    </MDBContainer>
  );
}

export default LoginTeacher;
