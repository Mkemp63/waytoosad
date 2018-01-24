package main.java.nl.hu.v2tosad.resources;

import nl.hu.v2tosad.data.businessruleDAO;
import nl.hu.v2tosad.data.businessruleDAOImpl;
import nl.hu.v2tosad.model.Businessrule;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;

@Path("/generate")
public class businessruleResource {

    @POST
    @Path("{id}")
    @Produces("application/json")
    public String generateRule(@PathParam("id")ArrayList<Integer> id) {
        System.out.println(id);
        businessruleDAO br = new businessruleDAOImpl();

        ArrayList<Businessrule> rulelist = br.getBusinessrulesByID(id);
        System.out.println(rulelist);
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Businessrule b : rulelist) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", b.getId());
            job.add("rule", b.toString());
            jab.add(job);
        }
        return jab.build().toString();
    }
}
