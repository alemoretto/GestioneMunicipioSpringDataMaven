package it.prova.gestionemunicipiospringdatamaven.web.servlet.municipio;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionemunicipiospringdatamaven.model.Municipio;
import it.prova.gestionemunicipiospringdatamaven.model.dto.MunicipioDTO;
import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;

@WebServlet("/municipio/ExecuteModificaMunicipioServlet")
public class ExecuteModificaMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaMunicipioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long idMunicipio = Long.parseLong(request.getParameter("idInput"));
		MunicipioDTO municipioDTO = new MunicipioDTO(idMunicipio,request.getParameter("descrizioneInput"),
				request.getParameter("codiceInput"), request.getParameter("ubicazioneInput"));

		if (!municipioDTO.validate().isEmpty()) {
			request.setAttribute("municipioDTO", municipioDTO);
			request.setAttribute("messaggiDiErrore", municipioDTO.validate());
			request.getRequestDispatcher("/municipio/modificaMunicipio.jsp").forward(request, response);

			return;
		}

		Municipio municipioOld = municipioService.caricaSingoloMunicipioEager(idMunicipio); 
		Municipio municipioAggiornato = MunicipioDTO.buildMunicipioInstance(municipioDTO);
		municipioAggiornato.setAbitanti(municipioOld.getAbitanti());
		
		municipioService.aggiorna(municipioAggiornato);

		response.sendRedirect(request.getContextPath() + "/municipio/SendRedirectMunicipioServlet");

	}

}
