<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form{
		width:350px
	}
</style>
</head>
<body>
	<form action="deleteVehicle" method="get">
		<fieldset>
			<legend>Choose a vehicle you want to delete</legend>
				<label>Vehicle Plate
                <input type="text" name="vehiclePlate" id="vehiclePlateID" required/></label>
		</fieldset>
		<input type="submit" value="submit">
	</form>
</body>
</html>