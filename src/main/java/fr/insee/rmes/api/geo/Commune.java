package fr.insee.rmes.api.geo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="Commune")
@XmlAccessorType(XmlAccessType.FIELD)
public class Commune {

	private String code = null;
	private String uri = null;
	private String intitule = null;
	
	public Commune() {} // No-args constructor needed for JAXB

	public Commune(String code) {
		this.code = code;
	}

	@JacksonXmlProperty(isAttribute=true)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@JacksonXmlProperty(isAttribute=true)
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@JacksonXmlProperty(localName="Intitule")
	@JsonProperty(value="intitule")
	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
}
