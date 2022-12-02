 package com.myapp.core.servlets;
import services.myOrganisation;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
 
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
 
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
 

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = { Servlet.class })
@SlingServletPaths(value = "/bin/myservlet")
public class SimpleServlet extends SlingSafeMethodsServlet 
{
    private static final long serialVersionUID = 1L;
    
    @Reference
   myOrganisation myOrg;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
    		final SlingHttpServletResponse resp) throws ServletException, IOException
    {

    	resp.getWriter().write("Organisation Name: " + myOrg.getOrganistionName());
    	resp.getWriter().write("\nOrganisation Desc: " + myOrg.getDescription());

    	resp.getWriter().write("\nOrganisation NoOfEmployee: " + myOrg.getNoOfEmp());
    	resp.getWriter().write("\nOrganisation Location: " + myOrg.getLocation());

    	resp.getWriter().write("\nOrganisation Services: " + myOrg.getServices());

    }
}
