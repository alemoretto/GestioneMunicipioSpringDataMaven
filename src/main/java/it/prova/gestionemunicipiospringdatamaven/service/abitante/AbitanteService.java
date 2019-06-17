package it.prova.gestionemunicipiospringdatamaven.service.abitante;

import java.util.List;

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;

public interface AbitanteService {
	
	public List<Abitante> listAllAbitanti();

	public Abitante caricaSingoloAbitante(Long id);

	public Abitante caricaSingoloAbitanteEager(Long id);

	public void aggiorna(Abitante abitanteInstance);

	public void inserisciNuovo(Abitante abitanteInstance);

	public void rimuovi(Abitante abitanteInstance);

	public List<Abitante> findByExample(Abitante example);
	
	public List<Abitante> findByExample2(Abitante example);
	
	public List<Abitante> findByNome(String nameInput);
	
	public List<Abitante> cercaAbitantiConEtaMaggioreDi(Integer etaInput);
	
	public List<Abitante> cercaAbitantiPerNomeAndEta(String nomeInput, Integer etaInput);
	
	public List<Abitante> cercaAbitantiByEtaOrdinaPerNomeDesc(Integer eta);
	
	public List<Abitante> cercaPerNomeCheIniziaCon(String tokenIniziale);
	
	public List<Abitante> cercaPerCognomeEager(String cognomeInput);
	
	
}
