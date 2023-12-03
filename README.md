# 🚴 Project PolyBiking 🚴 | 2023-2024
<hr>

## Table of Contents
1. [The team](#-the-team)
2. [Project Description](#-project-description)
3. [Project Structure](#-project-structure)
3. [How to run the project](#-how-to-run-the-project)


### 👨‍👩‍👧‍👦 The team

| Name           | Github                                            |
|----------------|---------------------------------------------------|
| CHHILIF Anas   | [AnasChhilif](https://github.com/AnasChhilif)      |
| CHARLEUX Karim | [KarimCharleux](https://github.com/KarimCharleux) |

<hr>

### 📋 Project Description
The goal of the PolyBiking project is to develop a small app to compute itineraries by reducing as much as possible the distance to cover by foot (by using bikes instead).

<hr>

### 🗂️ Project Structure
The project is divided into two main directories:
    - **/Client** contains the heavy client java of the project.
    - **/Server** contains the server self-hosted C# server with the proxy

<hr>

### 🕹️ How to run the project
To run the project, you need to have [Maven](https://maven.apache.org/) installed on your computer and you need to have a JDK 17 installed on your computer.
Then, be careful to run Visual Studio as Administrator or to allow VS to open new port netsh command.
```
netsh http add urlacl url=http://+:3000/MyService/PolyBikingService user=DOMAIN\user
netsh http add urlacl url=http://+:3001/MyService/ProxyService user=DOMAIN\user
```
#### Run the backend server and the proxy + cache server (C#)
After that, you can open the solution in the Server directory with Visual Studio.
Click right on the solution and click on **_Configure Startup Projects_**.
And then, select **_Multiple startup projects_** and select the action **Start** for the **PolyBikingService** and **ProxyService** projects.
Then, apply and you can run the project in Visual Studio by clicking on the **Start** button or by pressing **F5**.

#### Run the client (Java)
To run the client, you need to open a terminal in the Client directory and run the following command:
```
mvn clean install
```
Then, you can run the client with the following command:
```
mvn exec:java
```
Or you can run the client with src/main/java/Main.java as the main class in your IDE.
With IntelliJ, you can run the client by clicking on the green arrow next to the main method.

#### Enjoy the project 
Now, you can enjoy the project and test it by yourself. 🚴
You just need to enter a starting point and a destination point like a city, a street, a place, a monument, etc.
And then, you can press **Enter** and the app will compute the best itinerary for you.
A map will be displayed with the itinerary and the distance to cover by foot and by bike.
