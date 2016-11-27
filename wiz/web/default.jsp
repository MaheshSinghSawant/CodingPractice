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
  <title>Welcome</title>
  <style>
  body {
    color: #ffffff;
    background-color: lightblue;
    font-family: Arial, sans-serif;
    font-size:14px;
    -moz-transition-property: text-shadow;
    -moz-transition-duration: 4s;
    -webkit-transition-property: text-shadow;
    -webkit-transition-duration: 4s;
    text-shadow: none;
  }
  body.blurry {
    -moz-transition-property: text-shadow;
    -moz-transition-duration: 4s;
    -webkit-transition-property: text-shadow;
    -webkit-transition-duration: 4s;
    text-shadow: #fff 0px 0px 25px;
  }
  a {
    color: #0188cc;
  }
  .textColumn, .linksColumn {
    padding: 2em;
  }
  .textColumn {
    position: absolute;
    top: 0px;
    right: 50%;
    bottom: 0px;
    left: 0px;

    text-align: right;
    padding-top: 11em;
    background-color: #0188cc;
    background-image: -moz-radial-gradient(left top, circle, #6ac9f9 0%, #0188cc 60%);
    background-image: -webkit-gradient(radial, 0 0, 1, 0 0, 500, from(#6ac9f9), to(#0188cc));
  }
  .textColumn p {
    width: 75%;
    float:right;
  }
  .linksColumn {
    position: absolute;
    top:0px;
    right: 0px;
    bottom: 0px;
    left: 50%;

    background-color: #c7c7c7;
  }

  h1 {
    font-size: 500%;
    font-weight: normal;
    margin-bottom: 0em;
  }
  h2 {
    font-size: 200%;
    font-weight: normal;
    margin-bottom: 0em;
  }
  ul {
    padding-left: 1em;
    margin: 0px;
  }
  li {
    margin: 1em 0em;
  }
  
  .buttons {
    background-color: #1b1e24; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}

  </style>
</head>
<body id="sample">
  <div>
      <% int sid= Integer.parseInt(request.getParameter("myid")); out.print(sid); %>
      <% String name=request.getParameter("myfname"); out.print(name); %>
      <% String lname=request.getParameter("mylname"); out.print(lname); %>
      <% String email=request.getParameter("myemail"); out.print(email); %> 
      <% String address=request.getParameter("myaddress"); out.print(address); %>
      <% float gpa= Float.parseFloat(request.getParameter("mygpa")); out.print(gpa); %>
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
  int numresults = 0;
  String statement = null;

  try {
    // Create connection to RDS DB instance
    conn = DriverManager.getConnection(jdbcUrl);
    
    // Create a table and write two rows
    setupStatement = conn.createStatement();
    String createTable = "CREATE TABLE Hogwarts (id int NOT NULL, FName char(50), Lname char(50), email char(50), city char(50), gpa float NOT NULL, PRIMARY KEY (id));";
    String insertRow1 = "INSERT INTO Hogwarts VALUES ('10','Harry','Potter','hp@gmail.com','london','3.2');";
    String insertRow2 = "INSERT INTO Hogwarts VALUES ('"+sid+"','"+name+"','"+lname+"','"+email+"','"+address+"','"+gpa+"');";
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
  %>
      
  
    <h1>Congratulations</h1>
    <a href="index.jsp" ><button class ="buttons">Back</button></a>
  </div>
  
  
</script>
</body>
</html>
<% } %>
