<%@ page language="java" import="edu.ksr.iet.prp.bean.*,java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
	<center>
	<table cellspacing="0" cellpadding="15" border="1">
	
		<form method="post" action="attn">
		
		<input type="date" name="date" placeholder="Select Date" required>
		
	
			<%
				List<Student> list = (List<Student>) request.getAttribute("stulist");
				for (Student student : list) {
					out.println("<tr> <td> " + student.getStudentid() + "</td> <td> " + student.getName()
							+ "</td> <td> <input type = 'checkbox' name='present' value='" + student.getStudentid() + "," + student.getName() + " '></td></tr>");
				}
			%>
		
	</table>
	<input type="submit" value="Put Attendance">
	</center>
	</form>
</body>
</html>






