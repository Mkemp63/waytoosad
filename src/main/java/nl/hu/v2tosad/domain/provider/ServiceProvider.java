package nl.hu.v2tosad.domain.provider;

import nl.hu.v2tosad.domain.service.ApplicationService;

public class ServiceProvider {
	
	// Providing a service class
	// This method is primarily used by the Resource classes
	public static ApplicationService getApplicationService(ApplicationService appService) {
		return appService;
	}

}
