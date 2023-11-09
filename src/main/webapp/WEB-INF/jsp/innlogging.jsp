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
<p style="color:red;">${loginMessage}</p>
<form method="post">
    <fieldset>
        <label for="phone">Mobil:</label> <input id="phone" type="text" name="phone" />
        <label for="password">Passord:</label> <input id="password" type="password" name="password" />
        <br><br><button type="submit">Logg inn</button>
    </fieldset>
</form>

</body>
</html>