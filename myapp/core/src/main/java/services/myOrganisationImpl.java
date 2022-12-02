package services;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = myOrganisation.class, immediate = true)
@Designate(ocd = myOrganisationConfiguration.class)
public class myOrganisationImpl implements myOrganisation 
{
	public String  Name;
	public String Desc;
	public int   NoOfEmp ;
	public String Location;
	public String Services;
  
	@Activate
	public void activate(myOrganisationConfiguration config) 
	{
		Name = config.Organisation_name();
		Desc = config.Organisation_Description();
		NoOfEmp = config.Organisation_noOfEmp();
		Location = config.Organisation_Location(); 
		Services = config.Organisation_services();
		
	}

	@Override
	public String getOrganistionName( )
	{
		return Name;
	}

	@Override
	public String getDescription( )
	{
		return Desc;
	}

	@Override
	public int getNoOfEmp( )
	{
		return  NoOfEmp;
	}

	@Override
	public String getLocation( )
	{
		return Location;
	}
	
	@Override
	public String getServices( )
	{
		return Services;
	}

}
