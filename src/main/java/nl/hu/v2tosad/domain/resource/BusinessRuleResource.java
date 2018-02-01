package nl.hu.v2tosad.domain.resource;

import nl.hu.v2tosad.domain.provider.ServiceProvider;
import nl.hu.v2tosad.domain.service.BusinessRuleService;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.*;
import java.io.InputStream;
import java.util.ArrayList;

// starts process for rest service
// This is where the ajax/json calls from Apex are caught
@Path("/generate")
public class BusinessRuleResource {
	private final BusinessRuleService service = (BusinessRuleService) ServiceProvider.getApplicationService(new BusinessRuleService());
	
	@PUT
	@Path("/{id}")
	public void updateRule(@PathParam("id") int id) {
		System.out.println("ID van de businessrule: " + id);
		service.startUpdating(id);
	}

	
	@DELETE//todo implement this
    public void deleteRule(InputStream is) {
        ArrayList<Integer> rulelist = inputToList(is);
        System.out.println(rulelist);
        service.deleteRules(rulelist);
    }

    @POST
    @Path("/deactivate")
    public void deactivateRule(InputStream is) {
        ArrayList<Integer> rulelist = inputToList(is);
        System.out.println(rulelist);
        service.deactivateRules(rulelist);
    }


    @POST
    @Path("/activate")
    public void generateRules(InputStream is) {
        ArrayList<Integer> rulelist = inputToList(is);
        System.out.println(rulelist);
        service.startGenerating(rulelist);
    }

    @POST
    @Path("/activateAll")
    public void generateAllRules() {
        service.getAllRuleIds();
    }

    private ArrayList<Integer> inputToList(InputStream is){
        ArrayList<Integer> rulelist = new ArrayList<Integer>();
        System.out.println(is);
        JsonObject object = Json.createReader(is).readObject();
        System.out.println(object);
        JsonArray lineItems = object.getJsonArray("rulelist");
        for (Object o : lineItems) {
            JsonObject jsonLineItem = (JsonObject) o;
            System.out.println(jsonLineItem);
            int key = jsonLineItem.getInt("id");
            rulelist.add(key);
        }

        return rulelist;
    }
}


