package fr.insee.rmes.api.codes.naf2008;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@XmlRootElement(name="SousClasseNAF2008")
@XmlAccessorType(XmlAccessType.FIELD)
public class SousClasseNAF2008 {
	
	private String code;
	private String uri;
	private String intitule;
	
	public SousClasseNAF2008() {} // No-args constructor needed for JAXB

	public SousClasseNAF2008(String code) {
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
