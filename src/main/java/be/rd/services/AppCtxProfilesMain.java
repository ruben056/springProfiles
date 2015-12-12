package be.rd.services;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppCtxProfilesMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("app-context-*.xml");
		
		stdOutActiveProfiles(appCtx);
		
		appCtx.getEnvironment().setActiveProfiles("cold");
		appCtx.refresh();	
		stdOutActiveProfiles(appCtx);		
		System.out.println(appCtx.getBean("snow", Snow.class).getType());

		appCtx.getEnvironment().setActiveProfiles("warm");
		appCtx.refresh();	
		stdOutActiveProfiles(appCtx);		
		System.out.println(appCtx.getBean("snow", Snow.class).getType());
		
		appCtx.close();
	}

	private static void stdOutActiveProfiles(
			ClassPathXmlApplicationContext appCtx) {
		for (String profile : appCtx.getEnvironment().getActiveProfiles()) {
			System.out.println("profile: " + profile);
		}
	}

	
}
