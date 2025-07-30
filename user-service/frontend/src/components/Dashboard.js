import React from 'react';


function Dashboard({ user }) {
  return (
    <div className="container mt-5">
      <h2>Hallo {user?.username || 'Gast'}!</h2>
      <p>Willkommen im Trainer-Dashboard</p>

      <a href="/course/create" className="btn btn-primary mt-3">
        Kurs anlegen
      </a>
    </div>
  );
}

export default Dashboard;
