import React, { useState, useRef } from 'react';
import './App.css';
import { Auth } from "./components/Auth";
import Cookies from 'universal-cookie';
import { Chat } from './components/Chat';
import { signOut } from 'firebase/auth';
import { auth } from './firebase-config';

const cookies = new Cookies();

function App() {
  const [isAuth, setIsAuth] = useState(cookies.get("auth-token")); //if there is an auth token in the web, isAuth will be tru
  const [room, setRoom] = useState("");

  const roomInputRef = useRef(null);

  const signUserOut = async () => {
    await signOut(auth);
    cookies.remove("auth-token");
    setIsAuth(false);
    setRoom(null);
  };

  //IF THE USER IS NOT AUTHENTICATED
  if(!isAuth){
    return (
      <div>
        <Auth setIsAuth={setIsAuth}/>
      </div>
    );
  }

  //IF THE USER IS AUTH
  return (
    <>
      {room ? (
        <Chat room={room}/> //we pass room variable to aut
      ) : (
        <div className="room">
          <label>Enter room name:</label>
          <input ref={roomInputRef}/>
          <button onClick={() => setRoom(roomInputRef.current.value)}>
            Enter chat
          </button>
        </div>
      )}

      <div className="sign-out">
        <button onClick={signUserOut}>Sign out</button>
      </div>
    </>
  );
}

export default App;
