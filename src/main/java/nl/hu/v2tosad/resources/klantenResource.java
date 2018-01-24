package main.java.nl.hu.v2tosad.resources;

import main.java.nl.hu.v2tosad.TOSAD.TestDAO;
import main.java.nl.hu.v2tosad.model.Klant;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import java.text.SimpleDateFormat;

@Path("/klanten")
public class klantenResource {
	TestDAO test = new TestDAO();
	// moet worden
	@GET
	@Produces("application/json")
    public String getAllKlanten() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
            for (Klant k : test.selectKlanten()) {
                JsonObjectBuilder job = Json.createObjectBuilder();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String dateString = sdf.format(k.getGeboorteDatum());
			
			job.add("id", k.getId());
			job.add("naam", k.getNaam());
			job.add("geslacht", k.getGeslacht());
			job.add("voorletters", k.getVoorletters());
			if (k.getTitel() == null) {
				job.add("titel", "null");
			} else {
				job.add("titel", k.getTitel());	
			}
			job.add("geboorteDatum", dateString);
			
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}

    @POST
	@Path("add/{name}")
	public void createKlant() {
        createKlant();
    }

    @POST
	@Path("add/{name}")
	public void createKlant(@PathParam("name") String naam) {
		test.createKlant(naam);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteKlant(@PathParam("id") int ID) {
		test.deleteKlant(ID);
	}
	
}
