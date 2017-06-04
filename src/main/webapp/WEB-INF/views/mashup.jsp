<%-- 
  - Author: Harshit
  - Description: Mashup view page of the application for querying Mashups. 
  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Query the Mashups</title>
<link rel="stylesheet" type="text/css"
	href="resources/style/css/style.css" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,400italic,300italic,300,700,700italic|Open+Sans+Condensed:300,700'
	rel="stylesheet" type='text/css'>
<script type="text/javascript"
	src="resources/style/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="resources/style/js/jquery.backstretch.min.js"></script>
<script type="text/javascript">
	$.backstretch("resources/style/images/gray.png");
</script>
</head>
<body>
	<h1>Query the Mashups</h1>

	<div class="header-wrapper opacity">
		<a href="/pa4">Home</a>
	</div>

	<div>
		<form name="input" action="mashup" method="POST">
			<table>
				<tr>
					<td>Updated Year:</td>
					<td><input type="text" name="updated"></td>
				</tr>
				<tr>
					<td>Used Apis:</td>
					<td><input type="text" name="apis"></td>
				</tr>
				<tr>
					<td>Tags:</td>
					<td><input type="text" name="tags"></td>
				</tr>
				<tr>
					<td>Keywords (look into title, summary and description):</td>
					<td><input type="text" name="keyword"></td>
				</tr>
				<tr>
					<td colspan="2"><i><small>Note: Use ',' seperator
								for multiple values in any of the fields.</small></i></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>


	<div>
		<p class="tab">${year}
			<span class="tab1"></span> ${apis} <span class="tab1"></span> ${tags}
			<span class="tab1"></span> ${keyword}
		</p>

		<p class="tab">${norecord}</p>

		<ul>
			<c:forEach var="rlist" items="${result}">
				<li>${rlist.getName()}</li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>
