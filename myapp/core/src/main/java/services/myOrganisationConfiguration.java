package services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
@ObjectClassDefinition(name = "Organisation Configuration")

public @interface myOrganisationConfiguration
{
	@AttributeDefinition(
			name = "Organisation name",  
			description = "enter Organisation name",
			type=AttributeType.STRING)
	String  Organisation_name()  ;

     @AttributeDefinition(
            name = "Organisation Description",
            description = "enter Organisation Description",
            type = AttributeType.STRING)            
    String Organisation_Description();

    @AttributeDefinition(
            name = "Organisation No_Of_Employee",
            description = "enter Organisation No_Of_Employee",
            type = AttributeType.INTEGER)
   int Organisation_noOfEmp();
    
    @AttributeDefinition(
            name = "Organisation Location",
            description = "enter Organisation Location",
            type = AttributeType.STRING)            
    String Organisation_Location();
    
    @AttributeDefinition(
            name = "Organisation services",
            description = "enter Organisation services",     
            type = AttributeType.STRING)            
    String Organisation_services();

}
