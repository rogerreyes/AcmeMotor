package co.com.uni5d.domain;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "Respuesta")
public class Respuesta {

	@Id
	@JsonProperty
	private ObjectId id;
	@JsonView
	private String SessionKey;
	@JsonView
	private List<Itinerario> Itineraries;

	@JsonView
	private Date fechaInicial;

	@JsonView
	private Date fechaFinal;

	@JsonView
	private String Mes;

	public String getSessionKey() {
		return SessionKey;
	}

	public void setSessionKey(String sessionKey) {
		SessionKey = sessionKey;
	}

	public List<Itinerario> getItineraries() {
		return Itineraries;
	}

	public void setItineraries(List<Itinerario> itineraries) {
		Itineraries = itineraries;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getMes() {
		return Mes;
	}

	public void setMes(String mes) {
		Mes = mes;
	}

	@Override
	public String toString() {
		return "Respuesta [SessionKey=" + SessionKey + ", Itineraries=" + Itineraries + ", fechaInicial=" + fechaInicial
				+ ", fechaFinal=" + fechaFinal + ", Mes=" + Mes + "]";
	}
 	
}
