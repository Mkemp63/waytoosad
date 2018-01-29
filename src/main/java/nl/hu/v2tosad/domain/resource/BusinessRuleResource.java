package nl.hu.v2tosad.domain.resource;

import nl.hu.v2tosad.data.dao.RepositoryDAO;
import nl.hu.v2tosad.data.model.BusinessRule;
import nl.hu.v2tosad.domain.provider.ServiceProvider;
import nl.hu.v2tosad.domain.service.BusinessRuleService;

import javax.json.*;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.InputStream;
import java.util.ArrayList;

// starts process for rest service
@Path("/generate")
public class BusinessRuleResource {
	private BusinessRuleService service = (BusinessRuleService) ServiceProvider.getApplicationService(new BusinessRuleService());
	
	/*@GET
	@Produces("application/json")
	@Path("{id}")
	public String getBusinessRule(@PathParam("id") int id) {
		BusinessRule br = service.getBusinessRule(id);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String dataString = sdf.format(br.getDateModified());
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		JsonObjectBuilder job = Json.createObjectBuilder();
		
		job.add("id", br.getId());
		job.add("status", br.getStatus());
		job.add("dateModified", dataString);
		job.add("code", br.getCode());
		job.add("businessRuleType", br.getBusinessRuleType());
		job.add("rule_Name", br.getRule_Name());
		job.add("discription", br.getDiscription());
		job.add("tableName", br.getTableName());
		
		jab.add(job);
		
		JsonArray array = jab.build();

		
		return array.toString();
		
	}
	
	@POST
	@Produces("application/json")
	@Path("{text}")
	public void doeIets(@PathParam("text") String text) {
		System.out.println(text);
	}

*/



    @POST
    @Path("/rules")
    @Produces("application/json")
    public String generateRule(InputStream is) {
        RepositoryDAO dao = new RepositoryDAO();
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

        System.out.println(rulelist);
        service.StartGenerating(rulelist);

        JsonArrayBuilder jab = Json.createArrayBuilder();
        ArrayList<BusinessRule> brs = service.getBusinessRule(rulelist);
        for (BusinessRule b : brs) {


            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", b.getId());
            job.add("rule", b.toString());
            jab.add(job);
        }
        JsonArray array = jab.build();
        return array.toString();
    }
}


