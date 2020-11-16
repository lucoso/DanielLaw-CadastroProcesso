<%@page import="br.com.lucaswagner.util.JavaUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="br.com.lucaswagner.domain.Processo" 
    		import="java.time.LocalDate"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Daniel Law - Processo</title>
</head>

<body>

<%

Processo p = (Processo) session.getAttribute("processo");
String numero = p.getPublicacao();
String numeroInter = p.getPedidoInternacional();
LocalDate localData = p.getDataPublicacao();
String requerentes = p.getRequerentes();
String titulo = p.getTitulo();

String data = JavaUtil.ConverterParaString(localData);

%>


<div align="center" /> <font color="green"><h1><strong>Processo Encontrado com Sucesso! </strong></h1></font></div>
</br></br>
</hr>
<font size="5" color="black"><strong>Número da Publicação:</strong> <%=numero %></font>
</br></br>
<font size="5" color="black"><strong>Número do Pedido Internacional:</strong> <%=numeroInter %></font>
</br></br>
<font size="5" color="black"><strong>Data da Publicação:</strong> <%=data %></font>
</br></br>
<font size="5" color="black"><strong>Requerentes:</strong> <%=requerentes %></font>
</br></br>
<font size="5" color="black"><strong>Título:</strong> <%=titulo %></font>

</br></br>

	<form action="Index.jsp" method="submit">
		<input type="submit" name="Voltar" value="Voltar Para Página Inicial" />
	</form>

</body>
</html>