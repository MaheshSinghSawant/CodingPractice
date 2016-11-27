<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.BufferedWriter" %>
<%@page import="java.io.FileWriter" %>
<%@page import="java.util.Date" %>
<%@page import="java.util.Scanner" %>
<%@ page import="java.sql.*" %>
<%


/** Log POSTs at / to a file **/
if ("POST".equalsIgnoreCase(request.getMethod())) {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/tmp/sample-app.log", true));
        Scanner scanner = new Scanner(request.getInputStream()).useDelimiter("\\A");
	if(scanner.hasNext()) {
		String reqBody = scanner.next();
		writer.write(String.format("%s Received message: %s.\n", (new Date()).toString(), reqBody));
	}
        writer.flush();
        writer.close();
	
} else {
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!--
    Copyright 2010-2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with the License. A copy of the License is located at

        http://aws.Amazon/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
  -->
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Hogwarts</title>
  <link rel="stylesheet" type="text/css" href="style.css">
  
</head>
<body>
    <center><h1>Hogwarts Homepage</h1>
        <p class="subtitle fancy"><span>Welcome to Hogwarts School of Wizardry</span></p></center>
<div style="width:100%;">      
<div style="float:left; width:50%;">
<table class="table-fill">
<tr>
   <th class="text-center">ID</th>
   <th class="text-center">First Name</th>
   <th class="text-center">Last Name</th>
   <th class="text-center">Email</th>
   <th class="text-center">Address</th>
   <th class="text-center">GPA</th>   
</tr>
    <%// Read RDS connection information from the environment
  String dbName = System.getProperty("RDS_DB_NAME");
  String userName = System.getProperty("RDS_USERNAME");
  String password = System.getProperty("RDS_PASSWORD");
  String hostname = System.getProperty("RDS_HOSTNAME");
  String port = System.getProperty("RDS_PORT");
  String jdbcUrl = "jdbc:mysql://" + hostname + ":" +
    port + "/" + dbName + "?user=" + userName + "&password=" + password;
  
  // Load the JDBC driver
  try {
    System.out.println("Loading driver...");
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver loaded!");
  } catch (ClassNotFoundException e) {
    throw new RuntimeException("Cannot find the driver in the classpath!", e);
  }

  Connection conn = null;
  Statement setupStatement = null;
  Statement readStatement = null;
  ResultSet resultSet = null;
  String results = "";
  String fname = "";
  String lname = "";
  String city = "";
  String email = "";
  String gpa = "";
  int numresults = 0;
  String statement = null;

  try {
    // Create connection to RDS DB instance
    conn = DriverManager.getConnection(jdbcUrl);
    
    // Create a table and write two rows
    setupStatement = conn.createStatement();
    String createTable = "CREATE TABLE Hogwarts (id int NOT NULL, FName char(50), Lname char(50), email char(50), city char(50), gpa float NOT NULL, PRIMARY KEY (id));";
    String insertRow1 = "INSERT INTO Hogwarts VALUES ('10','Harry','Potter','hp@gmail.com','london','3.2');";
    String insertRow2 = "INSERT INTO Hogwarts VALUES ('11','Ron','Weasly','rw@gmail.com','london','3.1');";
    //String insertRow3 = "INSERT INTO Hogwarts VALUES ('20',"+fnames+",'Weasly','fw@gmail.com','london','2.9');";
    // INSERT INTO Hogwarts VALUES ('12','Hermione','Granger','hg@gmail.com','london','4.0');
   
    //String createTable = "CREATE TABLE test (id int NOT NULL, Name char(50), Lname char(50), email char(50), city char(50), gpa float NOT NULL, PRIMARY KEY (id));";
    //String insertRow1 = "INSERT INTO Hogwarts VALUES ('10','Harry','Potter','hp@gmail.com','london','3.2');";
    //String insertRow2 = "INSERT INTO Hogwarts VALUES ('11','Ron','Weasly','rw@gmail.com','london','3.1');";
    
    setupStatement.addBatch(createTable);
    setupStatement.addBatch(insertRow1);
    setupStatement.addBatch(insertRow2);
   
    setupStatement.executeBatch();
    setupStatement.close();
    
  } catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
  } finally {
    System.out.println("Closing the connection.");
    if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
  }

  try {
    conn = DriverManager.getConnection(jdbcUrl);
    
    readStatement = conn.createStatement();
    resultSet = readStatement.executeQuery("SELECT id,FName,Lname,email,city,gpa FROM Hogwarts ;");

    //resultSet.first();
    while(resultSet.next()){
    results = resultSet.getString("id");   
     fname = resultSet.getString("FName");   
     lname = resultSet.getString("Lname");
     email = resultSet.getString("email");
     city = resultSet.getString("city");
     gpa = resultSet.getString("gpa");
    
    %>
     <tr>
     <td class="text-center"><%= results %></td>
    <td class="text-center"><%= fname %></td>
    <td class="text-center"><%= lname %></td>
    <td class="text-center"><%= email %></td>
    <td class="text-center"><%= city %></td>
    <td class="text-center"><%= gpa %></td>
    </tr>
    <%
    }
    //resultSet.next();
    //results += ", " + resultSet.getString("FName");
//    lname += ", " + resultSet.getString("LName");
    
    resultSet.close();
    readStatement.close();
    conn.close();

  } catch (SQLException ex) {
    // Handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
  } finally {
       System.out.println("Closing the connection.");
      if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
  }
 %>
</table>
</div>
<div style="float:right; width:40%;">
<div class="login">
    
    <h2 class="login-header">Add Wizard</h2>
    <form action="default.jsp" class="login-container">
        <p><input type="text" name="myid" placeholder="ID"></p>
        <p><input type="text" name="myfname" placeholder="First Name"></p>
        <p><input type="text" name="mylname" placeholder="Last Name"></p>
        <p><input type="text" name="myemail" placeholder="Email"></p>
        <p><input type="text" name="myaddress" placeholder="Address"></p>
        <p><input type="text" name="mygpa" placeholder="Gpa"></p>
        <p><input type="submit" value="Submit"> </p>
    </form>
</div>
</div>
    

</div>
</body>
</html>
<% } %>
