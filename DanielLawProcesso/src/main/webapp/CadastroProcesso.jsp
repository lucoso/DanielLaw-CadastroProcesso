<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Daniel Law - Cadastro Processo</title>

<h:outputStylesheet library="lucaswagner" name="styles/main.css" />

<script src="https://code.jquery.com/jquery-latest.js" type="text/javascript"></script>
<script src="resources/lucaswagner/javascripts/getprocesso.js" type="text/javascript"></script>

 
</head>

<body>

<div>

		<div class="buscarDiv" align="center" />
		<strong>Buscar Processo</strong>
	

</br></br>


<form>
	<label for="numeroprocesso">Digite o Processo:</label>
	<input type="text" id="numeroprocesso" name="processo" />

	<input type="button" id="buscarprocesso" value="Buscar" />
</form>

</div>

	<div>

		</br>
		</br>

		<div class="titulos" align="left" />
			<strong>Cadastrar Processo</strong>
		</div>

	</hr>
	</br>
	</br>

	<form id="cadastroForm" action="ServletCadastroProcesso" method="post">

		<label for="numeropub">Número da Publicação:</label> <input
			type="text" id="numeropub" name="numeroPublicacao" /> </br>
		</br> <label for="numeroint">Número do Pedido Internacional: </label> <input
			type="text" name="numeroPedidoInternacional" id="numeroint" /> </br>
		</br> <label for="data">Data da Publicação:</label> <input type="text"
			name="dataPublicacao" id="data" /> </br>
		</br> <label for="requerentes">Requerentes:</label>
		<textarea id="requerentes" name="requerentesProcesso" rows="5"
			cols="33"></textarea>

		</br>
		</br> <label for="titulo">Título:</label>
		<textarea id="titulo" name="tituloProcesso" rows="5" cols="33"></textarea>

		</br>
		</br> <input type="submit" name="Cadastrar" value="Cadastrar" />
	</form>


</br></br>
	
	<form action="Index.jsp" method="submit">
		<input type="submit" name="Cancelar" value="Cancelar" />
	</form>

</body>


</html>