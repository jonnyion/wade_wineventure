package ro.wine.rest.ontology;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.impl.ResourceImpl;
import com.hp.hpl.jena.util.FileManager;

public class Ontology {
	
	private static void sparqlRead() {

        FileManager.get().addLocatorClassLoader(Ontology.class.getClassLoader());
        Model model = FileManager.get().loadModel("C:\\Users\\savu\\Downloads\\wine.rdf");
        String queryString
                = "PREFIX vin: <http://www.w3.org/TR/2003/PR-owl-guide-20031209/wine#> "
                + "PREFIX food: <http://www.w3.org/TR/2003/PR-owl-guide-20031209/food#> "
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                + "SELECT DISTINCT ?wine ?property ?value "
                + "WHERE { "
                + "       ?o1 a ?class ."
                + "       ?wine a ?o1 ."
                + "       ?value a CortonMontrachet ."
                + "       ?wine ?property ?value ."
                + "}";

        Query query = QueryFactory.create(queryString);
        QueryExecution queryExec = QueryExecutionFactory.create(query, model);
        try {
            ResultSet results = queryExec.execSelect();
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                Resource subiect = soln.getResource("wine");
                Resource predicat = soln.getResource("property");
                String value = "";
                if ( soln.get("value").getClass().equals(ResourceImpl.class))
                {
                    Resource obiect = soln.getResource("value");
                    value= obiect.getLocalName();
                }
                else
                {
                    Literal name = soln.getLiteral("value");
                    value = name.getString();
                }
                
//                
                //res
                System.out.println("Vinul " + subiect.getLocalName() + " are " + predicat.getLocalName() + " cu valoarea " + value );
               // System.out.println(soln);
            }
        } finally {
            queryExec.close();
        }
    }

}
