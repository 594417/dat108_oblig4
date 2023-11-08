<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="no">
<head>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <!-- <script src="js/myscript.js" defer></script>  -->
    <title>Påmelding</title>
</head>

<body>
<h2>Påmelding</h2>
<p style="color:red;">Påmeldingsdetaljer er ugyldige</p>
<form method="post">
    <fieldset>

        <label>Fornavn</label>
        <input id="firstName" type="text" name="firstName" value="Lars" />

        <label>Etternavn</label>
        <input type="text" name="lastName" id="lastName" value="Larsen" />

        <label>Mobil (8 siffer)</label>
        <input type="text" name="phone" id="phone" value="1234" />

        <label>Passord</label>
        <input type="password" id="password" name="password" />
        <label>Passord repetert</label>
        <input type="password" id="repeatPassword" name="repeatPassword" />

        <label>Kjønn</label>
        <input type="radio" name="gender" id="gender" value="mann" checked="checked" />mann
        <input type="radio" name="gender" id="gender" value="kvinne" />kvinne

        <br><br><button type="submit">Meld meg på</button>
    </fieldset>
</form>
</body>
</html>