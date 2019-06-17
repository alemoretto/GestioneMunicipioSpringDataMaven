package it.prova.gestionemunicipiospringdatamaven.service.abitante;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.repository.abitante.AbitanteRepository;

@Component
public class AbitanteServiceImpl implements AbitanteService {

	@Autowired
	private AbitanteRepository abitanteRepository;

	// questo mi serve per il findByExample2 che risulta 'a mano'
	// o comunque in tutti quei casi in cui ho bisogno di costruire custom query nel service
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public List<Abitante> listAllAbitanti() {
		return (List<Abitante>) abitanteRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Abitante caricaSingoloAbitante(Long id) {
		return abitanteRepository.findOne(id);

	}

	@Transactional
	public void aggiorna(Abitante abitanteInstance) {
		abitanteRepository.save(abitanteInstance);
	}

	@Transactional
	public void inserisciNuovo(Abitante abitanteInstance) {
		abitanteRepository.save(abitanteInstance);
	}

	@Transactional
	public void rimuovi(Abitante abitanteInstance) {
		abitanteRepository.delete(abitanteInstance);
	}

	@Transactional(readOnly = true)
	public List<Abitante> findByExample(Abitante exampleInput) {
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING); // Match string containing pattern
		// .withIgnoreCase();
		return (List<Abitante>) abitanteRepository.findAll(Example.of(exampleInput, matcher));
	}

	//nel caso si volesse fare una query particolare nel service...
	@Override
	public List<Abitante> findByExample2(Abitante example) {
		String query = "select a from Abitante a where a.id = a.id ";

		if (StringUtils.isNotEmpty(example.getNome()))
			query += " and a.nome like '%" + example.getNome() + "%' ";
		if (StringUtils.isNotEmpty(example.getCognome()))
			query += " and a.cognome like '%" + example.getCognome() + "%' ";
		if (example.getEta() != null && example.getEta() > 0)
			query += " and a.eta = " + example.getEta();
		if (StringUtils.isNotEmpty(example.getResidenza()))
			query += " and a.residenza like '%" + example.getResidenza() + "%' ";

		return entityManager.createQuery(query, Abitante.class).getResultList();
	}

	@Override
	public List<Abitante> findByNome(String nameInput) {
		return abitanteRepository.findByNome(nameInput);
	}

	@Override
	public List<Abitante> cercaAbitantiConEtaMaggioreDi(Integer etaInput) {
		return abitanteRepository.findByEtaGreaterThan(etaInput);
	}

	@Override
	public List<Abitante> cercaAbitantiByEtaOrdinaPerNomeDesc(Integer eta) {
		return abitanteRepository.findByEtaOrderByNomeDesc(eta);
	}

	@Override
	public List<Abitante> cercaPerNomeCheIniziaCon(String tokenIniziale) {
		return abitanteRepository.findByNomeStartsWith(tokenIniziale);
	}

	@Override
	public List<Abitante> cercaAbitantiPerNomeAndEta(String nomeInput, Integer etaInput) {
		return abitanteRepository.findByNomeAndEta(nomeInput, etaInput);
	}

	@Override
	public List<Abitante> cercaPerCognomeEager(String cognomeInput) {
		return abitanteRepository.findByCognome(cognomeInput);
	}

}
