import logo from './logo.svg';
import './App.css';

import React, {useState} from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';

import RegisterForm from './components/RegisterForm';
import LoginForm from './components/LoginForm';
import Dashboard from './components/Dashboard';

function App() {
  // return <RegisterForm />;
  
  const [user, setUser] = useState(null);
  
  return (
		<BrowserRouter>
			<Routes>
				<Route path="/" element={<LoginForm setUser={setUser} />} />
				<Route path="/register" element={<RegisterForm />} />
				<Route path="/dashboard" element={<Dashboard user={user} />} />
			</Routes>
		</BrowserRouter>
  );
}

export default App;
