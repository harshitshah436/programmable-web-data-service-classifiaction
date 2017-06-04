<%-- 
  - Author: Harshit
  - Description: Home view page of the application. 
  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Programmable Web MongoDB Example</title>
<link rel="stylesheet" type="text/css" media="all"
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
	<h1>Programmable Web data using MongoDB</h1>

	<div class="header-wrapper opacity">
		<a class="header" href="/pa4">Home</a>
	</div>
	<div>
		<h4>Programming Assignment 3</h4>
		<div class="header-wrapper opacity">
			<P>
				<a href="createdb">Click here</a> to insert the data into MongoDB.
			</P>

			<P>${createDbMessage}</P>


			Query: <a href="api">APIs</a> <a href="mashup">Mashups</a>
		</div>
		
		<h4>Programming Assignment 4</h4>
		<div class="header-wrapper opacity">
				Web Service Classification <br>
			<a href="mashup_classifier">Classify Mashups</a>
		</div>
	</div>
</body>
</html>
