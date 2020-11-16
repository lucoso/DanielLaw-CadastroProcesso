package br.com.lucaswagner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.lucaswagner.domain.Processo;
import br.com.lucaswagner.manager.ProcessoManager;

/**
 * Servlet implementation class ServletBuscarProcesso
 */
public class ServletBuscarProcesso extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ProcessoManager pm = new ProcessoManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscarProcesso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numeroProcesso = request.getParameter("buscarNumeroPublicacao");
		String requerentes = request.getParameter("buscarRequerentesProcesso");
		List<Processo> processos = new ArrayList<Processo>();
		Processo processo = null;
		
		if(numeroProcesso.equals("")){
			processos = pm.BuscarProcessoPorRequerentes(requerentes);
		}
		
		if(requerentes.equals("")){
			processos = pm.BuscarProcessoPorNumero(numeroProcesso);
		}
		
		for(Processo p : processos){
			processo = p;
		}
		
		HttpSession session = request.getSession();

		session.setAttribute("processo", processo);
		
		if(processo == null){
			response.sendRedirect("ProcessoNaoEncontrado.jsp");
		}else{
			response.sendRedirect("Processo.jsp");
		}
	}

}
