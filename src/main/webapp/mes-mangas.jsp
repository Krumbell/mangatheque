<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Mangatheque</title>
		
		<style>
			table {
				border:3px solid #6495ed;
				border-collapse:collapse;
				width:90%;
				margin:auto;
			}
			thead, tfoot {
				background-color:#D0E3FA;
				background-image:url(sky.jpg);
				border:1px solid #6495ed;
			}
			tbody {
				background-color:#FFFFFF;
				border:1px solid #6495ed;
			}
			th {
				font-family:monospace;
				border:1px dotted #6495ed;
				padding:5px;
				background-color:#EFF6FF;
				width:25%;
			}
			td {
				font-family:sans-serif;
				font-size:80%;
				border:1px solid #6495ed;
				padding:5px;
				text-align:left;
			}
			caption {
				font-family:sans-serif;
			}
		</style>
	</head>
	
	<body>
		<h1>Mes mangas :</h1><br><br>
		<table>
			<tr>
				<th>Noms</th>
				<th>Prix</th>
				<th>Modifier</th>
				<th>Supprimer</th>
			</tr>
			<c:forEach items="${mangas}" var="manga">
				<tr>
					<td>${manga.nom}</td>
					<td>${manga.prix} euros</td>
					<td><form action="Liste" method="get"><input type="hidden" name="idAlter" value="${manga.id}"/><input type="submit" name="alter-one" value="Modifier"/></form></td>
					<td><form action="Liste" method="get"><input type="hidden" name="idDelete" value="${manga.id}"/><input type="submit" name="delete-one" value="supprimer"/></form></td>
				</tr>
			</c:forEach>
		</table><br><br>
		
		<a href="index.html">Retour à l'accueil</a>
	</body>
</html>