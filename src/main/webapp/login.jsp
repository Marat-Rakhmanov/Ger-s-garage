<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/loginStyle.css">
</head>
<body>
       <div class="container" align="left">
           <h1 class="label">Login Form</h1>

           <form class="login_form" action="LoginServlet" method="post" name="form" onsubmit="return validated()">
           		<div class="font">Email</div>
           		<input type="text" name="emailAddress">
           		<div id="email_error">Please fill up your Email</div>
           		<div class="font font2">Password</div>
           		<input type="password" name="password">
           		<div id="pass_error">Please fill up your password</div>
           		<p><i>${message}</i><p>
           		<button type="submit">Login</button>

                <p>Do not have an account yet? <a href="create_account.jsp">Register</a></p>

            </form>
        </div>
	<script src="script/valid.js"></script>
</body>
</html>