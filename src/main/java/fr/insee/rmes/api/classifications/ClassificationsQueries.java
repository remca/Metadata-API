package fr.insee.rmes.api.classifications;

public class ClassificationsQueries {

	public static String getClassification(String classificationId) {

		return "SELECT ?uri	?code?uriParent	?codeParent	?intituleFr	?intituleEn	?contenuLimite	?contenuCentral	?contenuExclu 	\n"
				+ " FROM <http://rdf.insee.fr/graphes/codes/" + classificationId.toLowerCase() + ">\n" 
				+ "WHERE{\n"
				+ " ?uri rdf:type 	skos:Concept.\n" + " ?uri skos:notation ?code.\n" + " \n" + " optional {\n"
				+ "    ?uriParent skos:narrower ?uri. \n" 
				+ "	?uriParent skos:notation ?codeParent.\n"
				+ " \n" 
				+ " }\n" + " \n" + " optional { ?uri skos:prefLabel ?intituleFr.\n"
				+ " FILTER langMatches( lang(?intituleFr ), 'fr' ) }   \n" 
				+ " OPTIONAL { ?uri skos:prefLabel ?intituleEn.\n"
				+ " FILTER langMatches( lang(?intituleEn ), 'en' ) }\n" + " \n" 
				+ " OPTIONAL {?uri xkos:additionalContentNote ?uriACNote. \n"
				+ " ?uriACNote 	evoc:noteLiteral  ?contenuLimite .\n" 
				+ " ?uriACNote insee:validFrom ?dateDebACN.\n"
				+ " FILTER (NOT EXISTS {?uriACNote insee:validUntil ?dateFinACN} )\n" 
				+ " }\n" 
				+ " OPTIONAL {"
				+ " ?uri xkos:coreContentNote ?uriCCNote.\n"
				+ " ?uriCCNote 	evoc:noteLiteral  ?contenuCentral .\n" + " ?uriCCNote insee:validFrom ?dateDebCCN.\n"
				+ " FILTER  (NOT EXISTS {?uriCCNote insee:validUntil ?dateFinCCN} )\n" 
				+ " }\n" 
				+ " OPTIONAL {?uri xkos:exclusionNote ?uriENote.\n"
				+ " ?uriENote 	evoc:noteLiteral  ?contenuExclu .\n" + " ?uriENote insee:validFrom ?dateDebEN.\n"
				+ " FILTER  (NOT EXISTS {?uriENote insee:validUntil ?dateFinEN} )\n" + " }\n" 
				+ " OPTIONAL {?uri skos:scopeNote ?uriSNote.\n" + " ?uriSNote 	evoc:noteLiteral  ?plainTextSN .\n"
				+ " ?uriSNote insee:validFrom ?dateDebSN.\n"
				+ " FILTER  (NOT EXISTS {?uriSNote insee:validUntil ?dateFinSN} )\n" 
				+ " }\n" 
				+ "}\n"
				+ "ORDER BY ?code";

		
	}

	public static String getClassificationsDescriptions() {

		return "SELECT ?code ?uri ?intitule  \n"
				+ "WHERE {\n" 
				+ "	?uri skos:prefLabel ?intitule .  \n"
				+ "	?uri rdf:type skos:ConceptScheme .  \n"
				+ "	BIND  (strbefore(strafter(str(?uri),'/codes/'),'/') as ?code)  \n"
				+ "	FILTER(regex(str(?uri),'/codes/'))  \n" 
				+ "	FILTER(!regex(str(?uri),'/cj/'))  \n"
				+ "	FILTER(lang(?intitule) = 'fr')\n" 
				+ "}  \n" 
				+ "ORDER BY ?intitule  \n";

	}
}
