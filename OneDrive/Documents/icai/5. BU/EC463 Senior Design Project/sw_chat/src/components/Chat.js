import { useEffect, useState } from "react";
import { addDoc, collection, serverTimestamp, onSnapshot, query, where, orderBy } from 'firebase/firestore';
import { auth, db } from "../firebase-config";
import '../styles/Chat.css';
import '../styles/Auth.css';


export const Chat = (props) => {
    const {room} = props; //we take the room from app.js
    const [newMessage, setNewMessage] = useState("");
    const [messages, setNewMessages] = useState([]);

    const messagesRef = collection(db, "messages");

    useEffect(() => {
        const queryMessages = query(
            messagesRef, 
            where("room", "==", room),
            orderBy("createdAt")
        );
        const unsuscribe = onSnapshot(queryMessages, (snapshot) => {
            let messages = [];
            snapshot.forEach((doc) => {
                messages.push({...doc.data(), id: doc.id })
            });
            
            setNewMessages(messages);
        });

        return () => unsuscribe(); //clean it up
    }, []);

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (newMessage === "") return; //if the message is empty do not send it

        await addDoc(messagesRef, {
            text: newMessage,
            createdAt: serverTimestamp(),
            user: auth.currentUser.displayName,
            room, //room: room
        });

        setNewMessage("")
    }

    return (
        <div className="chat-app">
          <div className="header">
            <h1>Current in: {room.toUpperCase()}</h1>
          </div>
          <div className="messages">
            {messages.map((message) => (
              <div key={message.id} className="message">
                <span className="user">{message.user}:</span> {message.text}
              </div>
            ))}
          </div>
          <form onSubmit={handleSubmit} className="new-message-form">
            <input
              type="text"
              value={newMessage}
              onChange={(event) => setNewMessage(event.target.value)}
              className="new-message-input"
              placeholder="Type your message here..."
            />
            <button type="submit" className="send-button">
              Send
            </button>
          </form>
        </div>
      );
}