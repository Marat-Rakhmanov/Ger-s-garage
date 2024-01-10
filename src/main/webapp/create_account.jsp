<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/loginStye.css">

</head>
<body>
	<%@ page import  ="garage.User" %>
	<%User user = (User) request.getAttribute("email"); 
	String message = (String) request.getAttribute("message");

	if(user == null) user = new User();
	if(message == null) message ="";

	%>
	<p><i>${message}</i></p>
       <div align="left">
       <form action="SignUp" method="post">
       
       		<fieldset>
           		<legend>User identification</legend>
           
               		<div class="">First name:</div>
                    <input type="text" name="fname" required='required'>

                    <div class="">Surname:</div>
                    <input type="text" name="surname" required='required'>
                    
                   	<div class="">Password:</div>
                    <input id="pass" type="password" name="password" required='required'>
                   		
                   	<div class="">Confirm Password:</div>
                    <input id="confirm_pass" type="password" name="cnfpassword" required='required' onkeyup="validate_password()">
                    <span id="wrong_pass_alert"></span>
                    
                   	<div class="">Licence:</div>
                    <input type="text" name="licence" required='required'>
                    
                    <div class="">Email:</div>
                    <input type="text" name="emailAddress" required='required'>
                    <p><i>${message}</i></p>
                    
                    <div class="">Phone number:</div>
                    <input type="text" name="phone" required='required'>
                    
                    <div class="">Gender:</div>
                    <input id="male" type="radio" name="gender" value="male"><label for="male">Male</label>
                    <input id="female" type="radio" name="gender" value="female"><label for="female">Female</label>
                    
                    <div class="">Birthday:</div>
                    <input type="date" name="birthday" required='required'>
            
            	</fieldset>
            	   
            	<fieldset>
            		<legend>Vehicle details</legend>
            			<label>Make: <br/><input type="text" name="make" placeholder="BMW, Mercedes, Volkswagen ..."/></label><br/>
            			<label>Model: <br/><input type="text" name="model" placeholder="X5, 500E, Tiguan..."/></label><br/>
            			<label>Vehicle plate: <br/><input type="text" name="vehiclePlate"/></label><br/>
            			<fieldset>
            				<legend>Engine type</legend>
            					
            					<input id="petrol" type="radio" name="engineType" value="petrol" checked="checked">
            					<label for="petrol">Petrol</label><br/>
            					
            					<input id="disiel" type="radio" name="engineType" value="disiel">
            					<label for="disiel">Disiel</label><br/>
            					
            					<input id="electric" type="radio" name="engineType" value="electric">
            					<label for="electric">Electric</label><br/>
            					
            					<input id="hybrid" type="radio" name="engineType" value="hybrid">
            					<label for="hybrid">Hybrid</label>
            					
            			</fieldset>
            	</fieldset><br/>
            	 
            	<input id="create" type="submit" value="Login">
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
            function wrong_pass_alert() {
                if (document.getElementById('pass').value != "" &&
                    document.getElementById('confirm_pass').value != "") {
                    alert("Your response is submitted");
                } else {
                    alert("Please fill all the fields");
                }
            }

        </script>
</body>
</html>