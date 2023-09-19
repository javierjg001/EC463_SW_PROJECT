// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAuth, GoogleAuthProvider } from "firebase/auth";
import { getFirestore } from "firebase/firestore";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyB3eGv3O308K3W7Jg9rpkZxU3-lVXxGHfo",
  authDomain: "chat-22b5c.firebaseapp.com",
  projectId: "chat-22b5c",
  storageBucket: "chat-22b5c.appspot.com",
  messagingSenderId: "674176207445",
  appId: "1:674176207445:web:f6daafb00a6210655362dc"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
export const db = getFirestore(app); //conection to datbase
export const auth = getAuth(app);
export const provider = new GoogleAuthProvider();
