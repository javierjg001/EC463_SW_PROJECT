import React from 'react';
import './App.css';

import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';
import 'firebase/compat/firestore';

import { useAuthState, useSignInWithGoogle } from 'react-firebase-hooks/auth';
import { useCollectionData } from 'react-firebase-hooks/firestore';

firebase.initializeApp({
  apiKey: "AIzaSyDmSQjRARECFtpeqHKAWcKxyxG6khGnQ0s",
  authDomain: "senior-design-chat-app.firebaseapp.com",
  projectId: "senior-design-chat-app",
  storageBucket: "senior-design-chat-app.appspot.com",
  messagingSenderId: "395646513863",
  appId: "1:395646513863:web:618c384646a256f1c404e2",
  measurementId: "G-F9MQRF4663"
});

const auth = firebase.auth();
const firestore = firebase.firestore();

const [user] = useAuthState();

function App() {
  return (
    <div className="App">
      <header className="App-header">
      </header>

      <section>
        {user ? <Chatroom/> : <SignIn/>} 
      </section>
    </div>
  );
}

function SignIn(){
  const useSignInWithGoogle = () => new firebase.auth.GoogleAuthProvider();
  auth.signInWithPopup(provider);

  return(
    <button onClick={useSignInWithGoogle}>Sign in with Google</button>
  )
}

function SignOut() {
  return auth.currentUser && (
    <button className="sign-out" onClick={() => auth.signOut()}>Sign Out</button>
  )
}

export default App;
