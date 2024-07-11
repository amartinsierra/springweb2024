<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Producto</title>
<style type="text/css">
body {
	color: purple;
}

h1 {
	text-align: center;
}

div {
	width: 400px;
	margin: 50px auto;
	padding: 15px;
	background-color: smocke;
	border: 1px solid purple; input { display : block;
	margin-bottom: 15px;
}

input {
	color: purple;
	margin: 0 auto; 
	display : block;
	margin-bottom: 15px;
	border: 1px solid purple;
	padding: 7px;
	display: block;
}}
</style>
</head>
<body>
	<div>
		<h1>Añadir nuevo producto</h1>
		<form action="alta" method="post">
			URL:<input type="text" name="url" ><br>
			Temática:<input type="text" name="tematica" ><br> 
			Descripción:<input type="text" name="descripcion" > <br>
			<input type="submit" value="Alta">
		</form>
	</div>
</body>
</html>