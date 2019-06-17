package it.prova.gestionemunicipiospringdatamaven.service.municipio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionemunicipiospringdatamaven.model.Municipio;
import it.prova.gestionemunicipiospringdatamaven.repository.municipio.MunicipioRepository;

@Component
public class MunicipioServiceImpl implements MunicipioService {

	@Autowired
	private MunicipioRepository municipioRepository;

	@Transactional(readOnly = true)
	public List<Municipio> listAllMunicipi() {
		return (List<Municipio>) municipioRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Municipio caricaSingoloMunicipio(Long id) {
		return municipioRepository.findOne(id);
	}

	@Transactional
	public void aggiorna(Municipio municipioInstance) {
		municipioRepository.save(municipioInstance);
	}

	@Transactional
	public void inserisciNuovo(Municipio municipioInstance) {
		municipioRepository.save(municipioInstance);
	}

	@Transactional
	public void rimuovi(Municipio municipioInstance) {
		municipioRepository.delete(municipioInstance);
	}

	@Transactional(readOnly = true)
	public List<Municipio> findByExample(Municipio municipioExample) {
		 ExampleMatcher matcher = ExampleMatcher.matching()     
                 .withStringMatcher(StringMatcher.CONTAINING);   // Match string containing pattern   
                 //.withIgnoreCase();   
		return (List<Municipio>) municipioRepository.findAll(Example.of(municipioExample,matcher));
	}

	@Transactional(readOnly = true)
	public List<Municipio> cercaByDescrizioneILike(String term) {
		return municipioRepository.findAllByDescrizioneContaining(term);
	}

}
