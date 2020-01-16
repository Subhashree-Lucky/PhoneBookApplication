<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function deletePopup() {
		return confirm("Are You Sure, We Want To Delete?")
	}
</script>
<body bgcolor="lightcyan">
	<h2 style="color: blue; text-allign: center">
		<center>View Page</center>
	</h2>
	<a href="/"><font color="red"><center>
				<b><u>Add New Contact</u></b>
			</center></font></a><br>
	<center>
		<table style="text-align: center" border="2" width=40% " height="20%" >
			<tr>
				<td><font color="black"><center>S.No</center></font></td>
				<td><font color="black"><center>Name</center></font></td>
				<td><font color="black"><center>Email</center></font></td>
				<td><font color="black"><center>Phno</center></font></td>
				<td><font color="black"><center>Action</center></font></td>
			</tr>

			<c:forEach items="${contact}" var="co" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${co.contactName}</td>
					<td>${co.contactEmail}</td>
					<td>${co.phNo}</td>
					<td><a href="editContact?cid=${co.contactId}">Edit</a> &nbsp;
						<a href="deleteContact?cid=${co.contactId}"
						onclick="return deletePopup()">Delete</a></td>
				</tr>
			</c:forEach>
</body>
</center>
</table>
