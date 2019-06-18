package it.prova.gestionemunicipiospringdatamaven.web.servlet.abitante;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.model.dto.AbitanteDTO;
import it.prova.gestionemunicipiospringdatamaven.service.abitante.AbitanteService;

@WebServlet("/abitante/ExecuteModificaAbitanteServlet")
public class ExecuteModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AbitanteService abitanteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaAbitanteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AbitanteDTO abitanteDTO = new AbitanteDTO(Long.parseLong(request.getParameter("idInput")), request.getParameter("nomeInput"),
				request.getParameter("cognomeInput"), request.getParameter("etaInput"),
				request.getParameter("residenzaInput"), request.getParameter("municipioInput"),
				request.getParameter("municipioId"));

		
		if (!abitanteDTO.validate().isEmpty()) {
			request.setAttribute("abitanteDTO", abitanteDTO);
			request.setAttribute("messaggiDiErrore", abitanteDTO.validate());
			request.getRequestDispatcher("/abitante/modificaNuovoAbitante.jsp").forward(request, response);

			return;
		}

		Abitante abitanteDaAggiornre = AbitanteDTO.buildAbitanteInstance(abitanteDTO);

		abitanteService.aggiorna(abitanteDaAggiornre);

		response.sendRedirect(request.getContextPath() + "/abitante/SendRedirectAbitanteServlet");

	}

}
