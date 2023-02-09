<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Gestão - Login</title>
</head>
<body>
<h1>Sistema de Gestão - Login</h1>
<form method="post" action="login">
	<label>Usuário <input type="text" name="usuario"></label><br><br>
	<label>Senha <input type="password" name="senha"></label><br><br>
	<input type="submit" value="Login">
</form>
<h4>${mensagem}</h4>
</body>
</html>