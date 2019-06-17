package it.prova.gestionemunicipiospringdatamaven.repository.abitante;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;

public interface AbitanteRepository extends CrudRepository<Abitante, Long>,QueryByExampleExecutor <Abitante> {

	// la query viene costruita in automatico!!!
	List<Abitante> findByNome(String name);

	// Anche questa!!!
	List<Abitante> findByEtaGreaterThan(Integer etaInput);

	// Combinazione di campi!!! (Come i dynamic finders)
	List<Abitante> findByNomeAndEta(String nome, Integer eta);

	// Order by!!!!
	List<Abitante> findByEtaOrderByNomeDesc(Integer eta);

	// se ho necessità particolari
	@Query("from Abitante p where p.nome like ?1%")
	List<Abitante> findByNomeStartsWith(String token);

	//se voglio un caricamento EAGER per esempio by cognome
	//anche se i caricamenti EAGER conviene scriverli in JPQL
	@EntityGraph(attributePaths = { "municipio" })
	List <Abitante> findByCognome(String cognome);

}
