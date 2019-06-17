package it.prova.gestionemunicipiospringdatamaven.model.dto;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.model.Municipio;

public class AbitanteDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String eta;
	private String residenza;
	private Long municipioId;
	private String municipioInput;

	public AbitanteDTO() {
	}

	public AbitanteDTO(Long id, String nome, String cognome, String eta, String residenza, String municipioInput, String municipioId) {
		this(nome, cognome, eta, residenza, municipioInput, municipioId);
		this.id = id;
	}

	public AbitanteDTO(String nome, String cognome, String eta, String residenza, String municipioInput, String municipioId) {
		this(nome, cognome, eta, residenza);
		this.municipioInput = municipioInput;
		try {
			this.municipioId = Long.parseLong(municipioId);
		} catch (Exception e) {
		}
		
	}

	public AbitanteDTO(String nome, String cognome, String eta, String residenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.residenza = residenza;
	}
	
	public static Abitante buildAbitanteInstance(AbitanteDTO abitanteDTO) {

		Abitante abitante = new Abitante(abitanteDTO.getNome(), abitanteDTO.getCognome(),
				Integer.parseInt(abitanteDTO.getEta()), abitanteDTO.getResidenza());
		try {
			abitante.setId(abitanteDTO.getId());
		} catch (Exception e) {
		}
		
		try {
			abitante.setMunicipio(new Municipio(abitanteDTO.getMunicipioId()));
		} catch (Exception e) {
		}

		return abitante;
	}

	public static AbitanteDTO buildAbitanteDTOInstance(Abitante abitante) {

		AbitanteDTO abitanteDTO = new AbitanteDTO(abitante.getNome(), abitante.getCognome(),
				Integer.toString(abitante.getEta()), abitante.getResidenza(), abitante.getMunicipio().getDescrizione(),
				Long.toString(abitante.getMunicipio().getId()));
		try {
			abitanteDTO.setId(abitante.getId());
		} catch (Exception e) {
		}

		return abitanteDTO;
	}

	public Map<String, String> validate() {

		Map<String, String> validazione = new HashMap<String, String>();

		if (StringUtils.isEmpty(this.nome)) {
			validazione.put("nomeInput", "Attenzione! Il campo Nome è obbligatorio");
		}

		if (StringUtils.isEmpty(this.cognome)) {
			validazione.put("cognomeInput", "Attenzione! Il campo Cognome è obbligatorio");
		}

		if (StringUtils.isEmpty(this.eta)) {
			validazione.put("etaInput", "Attenzione! Il campo Età è obbligatorio");
		} else {
			try {
				Integer.parseInt(this.eta);
				if (Integer.parseInt(this.eta) <= 0)
					validazione.put("etaInput", "Attenzione! Il campo Età non è valido");

			} catch (Exception e) {
				validazione.put("etaInput", "Attenzione! Il campo Età non è valido");
			}
		}

		if (StringUtils.isEmpty(this.residenza)) {
			validazione.put("residenzaInput", "Attenzione! Il campo Residenza è obbligatorio");
		}

		if (StringUtils.isEmpty(this.municipioInput)) {
			validazione.put("municipioInput", "Attenzione! Bisogna selezionare un Municipio");
		}
		
		if (this.municipioId == null) {
			validazione.put("municipioInput", "Attenzione! Il campo Municipio non è valido");
		}

		return validazione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public Long getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Long municipioId) {
		this.municipioId = municipioId;
	}

	public String getMunicipioInput() {
		return municipioInput;
	}

	public void setMunicipioInput(String municipioInput) {
		this.municipioInput = municipioInput;
	}

}
