package br.com.lucaswagner.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucaswagner.domain.Processo;
import br.com.lucaswagner.manager.ProcessoManager;
import br.com.lucaswagner.util.JavaUtil;

/**
 * Servlet implementation class ServletCadastroProcesso
 */
public class ServletCadastroProcesso extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ProcessoManager pm = new ProcessoManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastroProcesso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numeroPublicacao = request.getParameter("numeroPublicacao");
		String numeroPedidoInternacional = request.getParameter("numeroPedidoInternacional");
		String dataPublicacao = request.getParameter("dataPublicacao");
		String requerentesProcesso = request.getParameter("requerentesProcesso");
		String tituloProcesso = request.getParameter("tituloProcesso");
		
		LocalDate data = JavaUtil.ConverterParaData(dataPublicacao);
		
		Processo p = new Processo();
		p.setPublicacao(numeroPublicacao);
		p.setPedidoInternacional(numeroPedidoInternacional);
		p.setDataPublicacao(data);
		p.setRequerentes(requerentesProcesso);
		p.setTitulo(tituloProcesso);
		
		int status = pm.Cadastrar(p);
		
		if(status == 201){
			response.sendRedirect("CadastroSucesso.jsp");
		}else{
			response.sendRedirect("CadastroInsucesso.jsp");
		}
		
	}
	
	

}
