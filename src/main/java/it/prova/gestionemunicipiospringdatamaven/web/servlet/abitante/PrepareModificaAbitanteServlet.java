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

@WebServlet("/PrepareModificaAbitanteServlet")
public class PrepareModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AbitanteService abitanteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public PrepareModificaAbitanteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Abitante abitanteDaMoficare = abitanteService
				.caricaSingoloAbitanteEager(Long.parseLong(request.getParameter("idAbitante")));
		AbitanteDTO abitanteDTO = AbitanteDTO.buildAbitanteDTOInstance(abitanteDaMoficare);

		request.setAttribute("abitanteDTO", abitanteDTO);

		request.getRequestDispatcher("/abitante/modificaNuovoAbitante.jsp").forward(request, response);

	}

}
