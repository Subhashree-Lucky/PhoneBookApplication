<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images/90.jpg">
	<h1 style="color:red ; text-allign: center">
		<b><center>Phone Book Web Application</center></b>
	</h1>
	<form:form action="handleSubmitBtn" method="POST" modelAttribute="contact">
	<center><font color="green">${successMsg }</font><br>
	<font color="red">${errorMsg}</font>
	<center>
		
		    <tr>
		        <form:hidden path="contactId"/>
		    <tr>
		    
		
			<tr>
				<td><b>&nbsp;&nbsp;&nbsp;&nbsp;Name</td>
				<td><form:input path="contactName" /></td>
			</tr><br>
			<tr>
				<td><b>&nbsp;&nbsp;&nbsp;&nbsp;Email</td>
				<td><form:input path="contactEmail" /></td>
			</tr><br>
			<tr>
				<td><b>Number</td>
				<td><form:input path="phNo" /></td>
			</tr><br>
				</center>
		</table><br>

			&nbsp;<tr>
				<td><b></b><input type="reset" value="Reset"></td>
				&nbsp;<td><b></b><input type="submit" value="Submit"></td>
			</tr>
		
		 <br><br><b><font color="darkred"><a href="/viewContacts">View All Contacts</a></font></b>
	</form:form>
</body>
</html>