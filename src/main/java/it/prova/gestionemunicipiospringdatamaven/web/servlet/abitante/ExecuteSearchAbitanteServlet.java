package it.prova.gestionemunicipiospringdatamaven.web.servlet.abitante;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.service.abitante.AbitanteService;

@WebServlet("/ExecuteSearchAbitanteServlet")
public class ExecuteSearchAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AbitanteService abitanteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteSearchAbitanteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeInput = StringUtils.isNotEmpty(request.getParameter("nomeInput"))? request.getParameter("nomeInput"):null;
		String cognomeInput = StringUtils.isNotEmpty(request.getParameter("cognomeInput"))? request.getParameter("cognomeInput"):null;
		Integer etaInput = StringUtils.isNumeric(request.getParameter("etaInput"))?Integer.parseInt(request.getParameter("etaInput")):null;
		String residenzaInput = StringUtils.isNotEmpty(request.getParameter("residenzaInput"))? request.getParameter("residenzaInput"):null;
		
		//request.setAttribute("listaAbitanti",
		//		abitanteService.findByExample(new Abitante(nomeInput, cognomeInput, etaInput,residenzaInput)));
		
		request.setAttribute("listaAbitanti",
				abitanteService.findByExample2(new Abitante(nomeInput, cognomeInput, etaInput,residenzaInput)));

		RequestDispatcher rd = request.getRequestDispatcher("/abitante/results.jsp");
		rd.forward(request, response);

	}

}
