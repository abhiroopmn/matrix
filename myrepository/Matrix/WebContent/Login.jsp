<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Matrix Login</title>
<link rel="stylesheet" type="text/css" href="template/style.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div id="loginpanelwrap">

		<div class="loginheader">
			<div class="logintitle">
				<a href="#">Login Here</a>
			</div>
		</div>


		<div class="loginform">
			<form action="LoginController" method="post">
				<%
					if (request.getAttribute("errorMsg") != null) {
						out.print("<h4 style='color: red'>"
								+ request.getAttribute("errorMsg") + "</h1>");
						request.removeAttribute("errorMsg");
					} else if (request.getAttribute("successMsg") != null) {
						out.print("<h4 style='color: green'>"
								+ request.getAttribute("successMsg") + "</h1>");
						request.removeAttribute("successMsg");
					}
				%>
				<div class="loginform_row">
					<label>Username:</label> <input type="text" class="loginform_input"
						name="uname" />
				</div>
				<div class="loginform_row">
					<label>Password:</label> <input type="password"
						class="loginform_input" name="password" />
				</div>
				<div class="loginform_row">
					<input type="submit" class="loginform_submit" value="Login" /> <input
						type="submit" class="loginform_register" value="Register" formaction="Register.do" />
				</div>

			</form>
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>