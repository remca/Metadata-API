package fr.insee.rmes.api.codes.naf1993;

import fr.insee.rmes.config.Configuration;

public class Naf1993Queries {
	
	public static String getClasseNAF1993(String code) {
		return "SELECT ?uri ?intitule WHERE { \n"
				+ "?uri skos:notation '" + code + "' . \n"
				+ "<" + Configuration.BASE_HOST + "/codes/naf/classes> skos:member ?uri . \n"
				+ "?uri skos:prefLabel ?intitule  \n"
				+ "FILTER (lang(?intitule) = 'fr') \n"
				+ "}";
	}

}
