<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Logg inn</title>
</head>
<body>
<h2>Logg inn</h2>
<p style="color:red;">Du er logget ut</p>
<form method="post">
    <fieldset>
        <label for="mobil">Mobil:</label> <input type="text" name="mobil" />
        <label for="passord">Passord:</label> <input type="password" name="passord" />
        <br><br><button type="submit">Logg inn</button>
    </fieldset>
</form>

</body>
</html>