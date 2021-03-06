package fr.insee.rmes.api.correspondences;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="Correspondances")
public class Correspondences {

	private List<Correspondence> itemsList = new ArrayList<Correspondence>();
	
	public Correspondences() {
		
	}

	public Correspondences(List<Correspondence> itemsList) {

		this.itemsList = itemsList;
	}

	@JacksonXmlProperty(isAttribute = true, localName = "Correspondance")
	@JacksonXmlElementWrapper(useWrapping = false)
	public List<Correspondence> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Correspondence> itemsList) {
		this.itemsList = itemsList;
	}
	
	
	

}
