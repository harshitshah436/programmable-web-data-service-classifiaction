<%-- 
  - Author: Harshit
  - Description: Mashup view page of the application for querying Mashups. 
  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Classify the Mashup</title>
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
	<h1>Classify the Mashup</h1>

	<div class="header-wrapper opacity">
		<a href="/pa4">Home</a>
	</div>

	<div>
		<form name="input" action="mashup_classifier" method="POST">
			<table>
				<tr>
					<td>Total downloads:</td>
					<td><input type="text" name="downloads" required="required"></td>
				</tr>
				<tr>
					<td>Use Counts:</td>
					<td><input type="text" name="useCounts" required="required"></td>
				</tr>
				<tr>
					<td>Number of comments:</td>
					<td><input type="text" name="numComments" required="required"></td>
				</tr>
				<tr>
					<td>Updated Year:</td>
					<td><input type="text" name="updatedYear" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Classify"></td>
				</tr>
			</table>
		</form>
	</div>


	<div>
		<p class="tab">${downloads}
			<span class="tab1"></span> ${useCounts} <span class="tab1"></span>
			${numComments} <span class="tab1"></span> ${updatedYear}
		</p>

		<%-- <p class="tab">${norecord}</p> --%>

		<p class="tab">${rating_message} ${ratings}</p>
	</div>

</body>
</html>
