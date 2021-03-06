package fr.insee.rmes.api.geo;

import fr.insee.rmes.config.Configuration;

public class GeoQueries {
	
	public static String getCommune(String code) {
		return "SELECT ?uri ?intitule WHERE { \n"
				+ "?uri igeo:codeINSEE '" + code + "'^^xsd:token . \n"
				+ "?uri igeo:nom ?intitule \n"
				// Ensure that is not the IGN URI and include COM towns
				+ "FILTER (REGEX(STR(?uri), '" + Configuration.BASE_HOST + "/geo/commune/')) \n"
				+ "FILTER (lang(?intitule) = 'fr') \n"
				+ "}";
	}
	
	public static String getCountry(String code) {
		return "SELECT ?uri ?intitule ?intituleEntier WHERE { \n"
				+ "?uri rdf:type igeo:Etat . \n"
				+ "?uri igeo:codeINSEE '" + code + "'^^xsd:token . \n"
				+ "?uri igeo:nom ?intitule . \n"
				+ "?uri igeo:nomEntier ?intituleEntier . \n"
				// Ensure that is not the dbpedia URI
				+ "FILTER (REGEX(STR(?uri), '" + Configuration.BASE_HOST + "')) \n"
				+ "FILTER (lang(?intitule) = 'fr') \n"
				+ "FILTER (lang(?intituleEntier) = 'fr') \n"
				+ "}";
	}
	
	public static String getRegion(String code) {
		return "SELECT ?uri ?intitule WHERE { \n"
				+ "?uri rdf:type igeo:Region . \n"
				+ "?uri igeo:codeINSEE '" + code + "'^^xsd:token . \n"
				+ "?uri igeo:nom ?intitule \n"
				// Ensure that is not the IGN URI
				+ "FILTER (REGEX(STR(?uri), '" + Configuration.BASE_HOST + "')) \n"
				+ "FILTER (lang(?intitule) = 'fr') \n"
				+ "}";
	}

}
