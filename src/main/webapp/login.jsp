<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <div align="left">
           <h1>Login Form</h1>

           <form action="LoginServlet" method="post">
               <table>
                    <tr>
                        <td>User name: </td>
                        <td><input type="text" name="email" required='required'></td>
                    <tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="password" required='required'></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Login"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <p>Do not have an account yet? <a href="create_account.jsp">Register</a></p>
                        </td>

                    </tr>
                </table>
            </form>
        </div>
        <script>
            function validate_password() {

                var pass = document.getElementById('pass').value;
                var confirm_pass = document.getElementById('confirm_pass').value;
                if (pass != confirm_pass) {
                    document.getElementById('wrong_pass_alert').style.color = 'red';
                    document.getElementById('wrong_pass_alert').innerHTML
                        = '☒ Use same password';
                    document.getElementById('create').disabled = true;
                    document.getElementById('create').style.opacity = (0.4);
                } else {
                    document.getElementById('wrong_pass_alert').style.color = 'green';
                    document.getElementById('wrong_pass_alert').innerHTML =
                        '🗹 Password Matched';
                    document.getElementById('create').disabled = false;
                    document.getElementById('create').style.opacity = (1);
                }
            }


        </script>
</body>
</html>