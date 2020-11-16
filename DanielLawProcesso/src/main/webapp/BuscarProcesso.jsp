<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Daniel Law - Buscar Processo</title>

<h:outputStylesheet library="lucaswagner" name="styles/main.css" />



</head>
<body>


		<div class="titulos" align="left" />
			<h1><strong>Filtro Buscar Processo</strong></h1> 
			<h2><strong>Utilize um dos campos abaixo para buscar os dados do Processo</strong></h2>
		</div>

	</hr>
	
	</br></br>

	<form id="buscarForm" action="ServletBuscarProcesso" method="get">

		<label for="buscarnumeropub">Número da Publicação:</label> 
		<input type="text" id="buscarnumeropub" name="buscarNumeroPublicacao" />
		
		</br></br> 
		
		<label for="buscarrequerentes">Requerentes:</label>
		<textarea id="buscarrequerentes" name="buscarRequerentesProcesso" rows="5"cols="33"></textarea>

		</br></br> 

		<input type="submit" name="Buscar" value="Buscar" />
	</form>
	
	</br></br>
	
	<form action="Index.jsp" method="submit">
		<input type="submit" name="Cancelar" value="Cancelar" />
	</form>

</body>
</html>