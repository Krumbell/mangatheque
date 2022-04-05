<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Mangatheque</title>
	</head>
	<body>
		<h1>Modifier le manga : ${manga.nom}</h1>
		
		<form action="Liste" method="get">
			<input type="hidden" name="idAltered" value="${manga.id}">
			<table>
				<tr>
					<td><label for="title">Titre :</label></td>
					<td><input type="text" id="title" name="title" placeholder="${manga.nom}" required="required"></td>
				</tr>
				<tr>
					<td><label for="price">Prix :</label></td>
					<td><input type="text" id="price" name="price" placeholder="${manga.prix}" required="required"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="alter-done" value="Valider"></td>
				</tr>
			</table>		
		</form>
	</body>
</html>