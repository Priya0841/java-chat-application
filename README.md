Group Chat Application using Java Sockets

This project is a group chat application implemented using Java socket programming, where multiple clients can connect to a central server and exchange messages in real time. The application follows a client–server architecture and uses multi-threading to handle multiple users simultaneously.

The project focuses on understanding how network communication, threads, and shared resources work together in a real-time system.

Project Description

The system consists of three main components:

Server – Listens for incoming client connections and manages communication

ClientHandler – Handles message processing for each connected client

Client – Allows users to connect to the server and send/receive messages through the terminal

Each client connection is handled on a separate thread, ensuring that multiple clients can communicate without blocking each other.

How the Application Works

The server starts and listens on a specific port.

Clients connect to the server using a socket connection.

Each client sends a username upon connection.

Messages sent by one client are broadcast to all connected clients.

When a client disconnects, the server removes it from the active connections list.

Key Concepts Used

TCP socket communication using ServerSocket and Socket

Multi-threading using Thread and Runnable

Client–server architecture

Message broadcasting to multiple clients

Handling client connections and disconnections

Input/output stream handling using BufferedReader and BufferedWriter

Project Structure
chat-system/
│
├── Server.java
├── ClientHandler.java
├── Client.java
└── README.md

How to Run the Project

Compile all Java files:

javac *.java


Start the server:

java Server


Open multiple terminals and start clients:

java Client


Each client can enter a username and start sending messages.

Learning Outcomes

Understanding of socket-based communication in Java

Practical experience with multi-threaded programming

Managing shared resources across threads

Building a simple real-time messaging system
