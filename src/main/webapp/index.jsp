<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Gest�o - Login</title>
</head>
<body>
<h1>Sistema de Gest�o - Login</h1>
<form method="post" action="login">
	<label>Usu�rio <input type="text" name="usuario"></label><br><br>
	<label>Senha <input type="password" name="senha"></label><br><br>
	<input type="submit" value="Login">
</form>
<h4>${mensagem}</h4>
</body>
</html>