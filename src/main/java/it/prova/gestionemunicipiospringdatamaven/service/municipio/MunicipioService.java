package it.prova.gestionemunicipiospringdatamaven.service.municipio;

import java.util.List;

import it.prova.gestionemunicipiospringdatamaven.model.Municipio;

public interface MunicipioService {
	
	public List<Municipio> listAllMunicipi() ;

	public Municipio caricaSingoloMunicipio(Long id);

	public void aggiorna(Municipio municipioInstance);

	public void inserisciNuovo(Municipio municipioInstance);

	public void rimuovi(Municipio municipioInstance);

	public List<Municipio> findByExample(Municipio example);
	
	public List<Municipio> cercaByDescrizioneILike(String term);

}
