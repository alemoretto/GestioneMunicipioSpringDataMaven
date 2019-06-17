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

import it.prova.gestionemunicipiospringdatamaven.service.abitante.AbitanteService;

@WebServlet("/ExecuteTestSpringDataAbitanteServlet")
public class ExecuteTestSpringDataAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AbitanteService abitanteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteTestSpringDataAbitanteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codiceOperazione = request.getParameter("codop");
		String queryInput = request.getParameter("queryInput");

		Object resultFromQuery = null;

		switch (codiceOperazione) {
		case "findByName":
			resultFromQuery = abitanteService.findByNome(queryInput);
			break;
		case "findByEtaGreaterThan":
			resultFromQuery = abitanteService.cercaAbitantiConEtaMaggioreDi(Integer.parseInt(queryInput));
			break;

		case "findByNomeAndEta":
			resultFromQuery = abitanteService.cercaAbitantiPerNomeAndEta(queryInput,
					Integer.parseInt(request.getParameter("queryInputEta")));
			break;
		case "findByEtaOrderByNomeDesc":
			resultFromQuery = abitanteService
					.cercaAbitantiByEtaOrdinaPerNomeDesc(Integer.parseInt(request.getParameter("queryInputEta")));
			break;
		case "findByNomeStartsWith":
			resultFromQuery = abitanteService.cercaPerNomeCheIniziaCon(queryInput);
			break;
		case "findByCognomeEager":
			resultFromQuery = abitanteService.cercaPerCognomeEager(queryInput);
			break;

		default:
			break;
		}

		String result = resultFromQuery == null ? "" : resultFromQuery.toString();

		response.getWriter().append("Risultato: =====>>> " + codiceOperazione).append("\n").append(result);
	}

}
