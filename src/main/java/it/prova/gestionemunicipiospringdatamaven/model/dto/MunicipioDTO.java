package it.prova.gestionemunicipiospringdatamaven.model.dto;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import it.prova.gestionemunicipiospringdatamaven.model.Municipio;

public class MunicipioDTO {

	private Long id;
	private String descrizione;
	private String codice;
	private String ubicazione;

	public MunicipioDTO() {
	}

	public MunicipioDTO(Long id, String descrizione, String codice, String ubicazione) {
		this(descrizione, codice, ubicazione);
		this.id = id;
	}

	public MunicipioDTO(String descrizione, String codice, String ubicazione) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.ubicazione = ubicazione;
	}

	public static Municipio buildMunicipioInstance(MunicipioDTO municipioDTO) {

		Municipio municipio = new Municipio(municipioDTO.getDescrizione(), municipioDTO.getCodice(),
				municipioDTO.getUbicazione());
		try {
			municipio.setId(municipioDTO.getId());
		} catch (Exception e) {
		}

		return municipio;
	}

	public static MunicipioDTO buildMunicipioDTOInstance(Municipio municipio) {

		MunicipioDTO municipioDTO = new MunicipioDTO(municipio.getDescrizione(), municipio.getCodice(),
				municipio.getUbicazione());
		try {
			municipioDTO.setId(municipio.getId());
		} catch (Exception e) {
		}

		return municipioDTO;
	}

	public Map<String, String> validate() {

		Map<String, String> validazione = new HashMap<String, String>();

		if (StringUtils.isEmpty(this.descrizione)) {
			validazione.put("descrizioneInput", "Attenzione! Il campo Descrizione è obbligatorio");
		}

		if (StringUtils.isEmpty(this.codice)) {
			validazione.put("codiceInput", "Attenzione! Il campo Codice è obbligatorio");
		}

		if (StringUtils.isEmpty(this.ubicazione)) {
			validazione.put("ubicazioneInput", "Attenzione! Il campo Ubicazione è obbligatorio");
		}

		return validazione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}

}
