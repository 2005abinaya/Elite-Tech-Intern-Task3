💬 TASK 3: Multithreaded Chat Application

A real-time, multi-user chat application built with Java sockets and advanced multithreading for seamless concurrent communication.

## 🚀 Features
- Real-time Messaging - Instant message delivery
- Multiple Clients - Supports 50+ concurrent users
- User Management - Join/leave notifications
- Broadcast System - Messages delivered to all users
- Graceful Disconnect - Proper connection cleanup
- Cross-platform - Works on any Java-supported OS

🏗 Architecture
 💻 Tech Stack
- Java 11+
- Socket Programming
- Multithreading (java.util.concurrent)
- BufferedReader/PrintWriter for I/O

📸 Demo Output
💬 CHAT SERVER STARTED ON PORT 8080
🟢 User 'Alice' joined the chat!
🟢 User 'Bob' joined the chat!
💬 Alice: Hello everyone!
💬 Bob: Hi Alice! How are you?
🔴 User 'Alice' left the chat

🛠 Usage
bash
 Start Server
java ChatServer

Start Multiple Clients
java ChatClient
java ChatClient
java ChatClient
