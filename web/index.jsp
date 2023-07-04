<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
<title>Event System</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
* {
	margin: 0;
	padding: 0;
}

fieldset {
	width: auto;
	margin: 10px 20px;
	padding: 10px;
	background-color: #eee;
	border: 2px #000 solid;
	border-radius: 10px 0 20px 0;
}

input {
	margin: 5px;
}

input[type=text] {
	color: darkblue;
}

#login_buttons {
	text-align: center;
}

#login_fields {
	width: 250px;
	text-align: center;
}

#left {
	float: left;
}

#right {
	float: right;
}
</style>
</head>
<body>
	<h1>Events</h1>
	<div id="left">
		<fieldset>
			<legend>Log in:</legend>
			<c:choose>
				<c:when test="${not empty userLogged}">
                        User: ${userLogged.email}
                        <form method="post" action="logout">
						<input type="submit" value="Log out" />
					</form>
				</c:when>
				<c:otherwise>
					<form method="post" action="login">
						<div id="login_fields">
							<input type="text" id="email" name="email"
								placeholder="Enter your email..." size="30" /> <input
								type="password" id="password" name="password"
								placeholder="Enter your password..." size="30" />
						</div>
						<div id="login_buttons">
							<input type="submit" value="Send" />
						</div>
					</form>
				</c:otherwise>
			</c:choose>
		</fieldset>
	</div>

	<div id="right">
		<fieldset>
			<legend>Search form:</legend>
			<form method="get" action="execute">
				<input type="hidden" name="task" value="SearchCompany" /> <input
					type="text" id="filter" name="filter"
					placeholder="Enter whatever you're thinking of..." size="50" /> <input
					type="submit" value="Send">
			</form>
		</fieldset>

		<c:if test="${not empty userLogged}">
			<fieldset>
				<legend>Register event:</legend>
				<form method="post" action="register">
					<input type="text" id="name" name="nome"
						placeholder="Enter the company name..." size="50" /> <input
						type="submit" value="Send" />
				</form>
			</fieldset>
		</c:if>
	</div>

</body>
</html>
