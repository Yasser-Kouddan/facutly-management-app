/* eslint-disable react-hooks/rules-of-hooks */
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import background from '../../assets/admin.jpg';
import {
  MDBBtn,
  MDBContainer,
  MDBCard,
  MDBCardBody,
  MDBRow,
  MDBInput,
  MDBCheckbox,
} from 'mdb-react-ui-kit';

function LoginAdmin() {
  let navigate = useNavigate();
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleSignUp = () => {
    const data = { username, password };

    axios
      .post('http://localhost:8000/api/admins/login', data)
      .then(response => {
        // Navigate to a route
        navigate('/admin');
        console.log('it works, I hope');
      })
      .catch(error => {
        // Display an alert message
        alert('Error: ' + error.message);
        navigate('/');
      });
  };

  return (
    <MDBContainer fluid>
      <div
        className="p-5 bg-image"
        style={{
          backgroundImage: `url(${background})`,
          height: '500px',
          backgroundSize: 'cover',
        }}
      ></div>

      <MDBCard
        className="mx-5 mb-5 p-5 shadow-5"
        style={{
          marginTop: '-100px',
          background: 'hsla(0, 0%, 100%, 0.8)',
          backdropFilter: 'blur(30px)',
        }}
      >
        <MDBCardBody className="p-5 text-center">
          <h2 className="fw-bold mb-5">Connectez-vous à l'espace admin</h2>

          <MDBRow>
            <MDBInput
              wrapperClass="mb-4 w-60"
              label="Username"
              id="form1"
              type="text"
              onChange={event => setUsername(event.target.value)}
            />
            <MDBInput
              wrapperClass="mb-4"
              label="Password"
              id="form1"
              type="password"
              onChange={event => setPassword(event.target.value)}
            />
          </MDBRow>

          <div className="d-flex justify-content-center mb-4">
            <MDBCheckbox name="flexCheck" value="" id="flexCheckDefault" label="Remember me" />
          </div>

          <MDBBtn className="w-50 mb-4" size="md" onClick={handleSignUp}>
            Sign In
          </MDBBtn>
        </MDBCardBody>
      </MDBCard>
    </MDBContainer>
  );
}

export default LoginAdmin;
