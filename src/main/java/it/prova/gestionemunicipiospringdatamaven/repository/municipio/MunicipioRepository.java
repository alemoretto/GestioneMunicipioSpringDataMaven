package it.prova.gestionemunicipiospringdatamaven.repository.municipio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.gestionemunicipiospringdatamaven.model.Municipio;

public interface MunicipioRepository extends CrudRepository<Municipio, Long>,QueryByExampleExecutor <Municipio> {

	List<Municipio> findAllByDescrizioneContaining(String term);

}
