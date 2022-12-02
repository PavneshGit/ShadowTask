
package com.myapp.core.models;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;


import javax.annotation.PostConstruct;

import org.apache.http.client.fluent.Request;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.settings.SlingSettingsService;
import org.osgi.service.component.annotations.Reference;

import com.adobe.cq.export.json.ExporterConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import services.myOrganisation;

import java.util.Optional;

@Model(adaptables = Resource.class)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)

public class HelloWorldModel {

	private String  Name;
	private String Desc;
	private int   NoOfEmp ;
	private String Location;
	private String Services;
	
	 @OSGiService
	myOrganisation myOrg;
    @PostConstruct
    
	public String getName() {
		Name= myOrg.getOrganistionName();
		return Name;
	}
	 
	public String getDesc() {
		Desc= myOrg.getDescription();
		return Desc;
	}
	 
	public int getNoOfEmp() {
		NoOfEmp= myOrg.getNoOfEmp();
		return NoOfEmp;
	}
	 
	public String getLocation() {
		 Location=myOrg.getLocation();
		 return Location;
	}
	 
	public String getServices() {
		Services= myOrg.getServices();
		 return Services;
	}
	 

}
