package nl.hu.v2tosad.domain.resource;

import nl.hu.v2tosad.data.model.BusinessRule;
import nl.hu.v2tosad.domain.provider.ServiceProvider;
import nl.hu.v2tosad.domain.service.BusinessRuleService;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import java.text.SimpleDateFormat;
// starts process for rest service
@Path("/generate")
public class BusinessRuleResource {
	private BusinessRuleService service = (BusinessRuleService) ServiceProvider.getApplicationService(new BusinessRuleService());
	
	@GET
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
	
}
