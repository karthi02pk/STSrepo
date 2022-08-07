<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Server Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

	function functionAjax() {
		$.ajax({
			type : "GET",
			url : "http://localhost:8080/test/getAlldata",
			headers : {
				"Content-Type" : "application/json"
			},
			success : function(data) {
				alert(data);
			},
			error : function(data) {
				alert(data);
			}
		});

	}
</script>
</head>
<body>
<h1>JSP-Java Server Page</h1>
<%-- <h3>${message}</h3> --%>
<input type="button" id="btn" value="TEST" onclick="functionAjax();"/>
<br><br><br>
<div id="resp">

</div>
</body>
</html>