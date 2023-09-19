import React, { useState } from 'react';
import './App.css';
import { Auth } from "./components/Auth";
import Cookies from 'universal-cookie';
const cookies = new Cookies();

function App() {
  const [isAuth, setIsAuth] = useState(cookies.get("auth-token")); //if there is an auth token in the web, isAuth will be tru
  const [room, setRoom] = useState("");

  //IF THE USER IS NOT AUTHENTICATED
  if(!isAuth){
    return (
      <div>
        <Auth />
      </div>
    );
  }

  //IF THE USER IS AUTH
  return (
    <div>
      {room ? (
        <div> Chat </div> 
      ) : (
        <div className="room">
          <label>Enter room name:</label>
          <input />
          <button>Enter chat</button>
        </div>
      )}
    </div>
  );
}

export default App;
