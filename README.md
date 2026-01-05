**Java Group Chat Application**

This project is a group chat application built using core Java.
Multiple clients can connect to a server and communicate with each other in real time.

The purpose of this project is to understand how socket programming and
multi-threading work together in a client-server system.


**Project Description**

The application has three main parts:

1. Server
   - Listens for incoming client connections
   - Accepts multiple clients at the same time

2. ClientHandler
   - Runs on a separate thread for each client
   - Receives messages from one client
   - Sends messages to all connected clients

3. Client
   - Connects to the server
   - Allows the user to send and receive messages using the terminal


**How the Application Works**

- The server starts and waits for clients to connect
- Each client connects using a socket
- A new thread is created for every connected client
- Messages sent by one client are broadcast to all others
- When a client disconnects, it is removed from the server list


**How to Run the Project**

1. Compile all files:
   javac *.java

2. Start the server:
   java Server

3. Open multiple terminals and start clients:
   java Client


**What I Learned**

- Basics of TCP socket communication in Java
- Handling multiple clients using threads
- Client-server architecture
- Managing shared resources between threads

