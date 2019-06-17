package it.prova.gestionemunicipiospringdatamaven.web.servlet.abitante;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrepareInsertAbitanteServlet")
public class PrepareInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareInsertAbitanteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/abitante/inserisciNuovoAbitante.jsp").forward(request, response);

	}

}
