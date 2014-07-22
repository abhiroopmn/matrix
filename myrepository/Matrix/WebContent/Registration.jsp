<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="template/style.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano'
	rel='stylesheet' type='text/css' />

<!-- jQuery file -->
<script src="template/js/jquery.min.js"></script>
<script src="template/js/jquery.tabify.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	var $ = jQuery.noConflict();
	$(function() {
		$('#tabsmenu').tabify();
		$(".toggle_container").hide();
		$(".trigger").click(function() {
			$(tdis).toggleClass("active").next().slideToggle("slow");
			return false;
		});
	});
</script>
<style type="text/css">
/***FIRST STYLE THE BUTTON***/
input#gobutton{
cursor:pointer; /*forces the cursor to change to a hand when the button is hovered*/
padding:5px 25px; /*add some padding to the inside of the button*/
background:#35b128; /*the colour of the button*/
border:1px solid #33842a; /*required or the default border for the browser will appear*/
/*give the button curved corners, alter the size as required*/
-moz-border-radius: 10px;
-webkit-border-radius: 10px;
border-radius: 10px;
/*give the button a drop shadow*/
-webkit-box-shadow: 0 0 4px rgba(0,0,0, .75);
-moz-box-shadow: 0 0 4px rgba(0,0,0, .75);
box-shadow: 0 0 4px rgba(0,0,0, .75);
/*style the text*/
color:#f3f3f3;
font-size:1.1em;
}
/***NOW STYLE THE BUTTON'S HOVER AND FOCUS STATES***/
input#gobutton:hover, input#gobutton:focus{
background-color :#399630; /*make the background a little darker*/
/*reduce the drop shadow size to give a pushed button effect*/
-webkit-box-shadow: 0 0 1px rgba(0,0,0, .75);
-moz-box-shadow: 0 0 1px rgba(0,0,0, .75);
box-shadow: 0 0 1px rgba(0,0,0, .75);
}
</style>
</head>
<body>
	<div id="panelwrap" style="width: 50%">

		<div class="header">
			<div class="title">
				<a href="#">Registration</a>
			</div>
			<div class="clear"></div>
			<div>
				<div style="padding-top: 3%">
					<form action="Registration.do">
						<table id="rounded-corner">
							<tr class="odd">
								<td>Name</td>
								<td><input type="text" name="name" required></input></td>
							</tr>
							<tr class="even">
								<td>Password</td>
								<td><input type="password" name="password" required></input></td>
							</tr>
							<tr class="odd">
								<td>Email</td>
								<td><input type="email" name="email" required></input></td>
							</tr>
							<tr class="even">
								<td>Date of Birth</td>
								<td><input type="date" name="dob" required></input></td>
							</tr>
							<tr class="odd">
								<td>Account Number</td>
								<td><input type="text" name="account" required></td>
							</tr>
							<tr class="even">
								<td>IFSC Code</td>
								<td><input type="text" name="ifsc" required></td>
							</tr>
							<tr class="odd">
								<td>Phone Number</td>
								<td><input type="text" name="mobile" required></td>
							</tr>
<%--							<tr class="odd">
								<td>Upload Profile Pic</td>
								<td><input type="file" name="pic"></td>
							</tr>
 --%>
						</table>
						<center><input id="gobutton" type="submit" value="Register"/></center>
					</form>
					<br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>