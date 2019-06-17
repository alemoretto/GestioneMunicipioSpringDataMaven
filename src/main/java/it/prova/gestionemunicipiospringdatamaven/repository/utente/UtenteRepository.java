package it.prova.gestionemunicipiospringdatamaven.repository.utente;

import org.springframework.data.repository.CrudRepository;

import it.prova.gestionemunicipiospringdatamaven.model.StatoUtente;
import it.prova.gestionemunicipiospringdatamaven.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {

	Utente findByUsernameAndPasswordAndStato(String username,String password, StatoUtente stato);
}
