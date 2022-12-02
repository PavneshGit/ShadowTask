package com.myapp.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;

@Component(service = { Servlet.class })
@SlingServletResourceTypes(
        resourceTypes="mynode/user",
        methods=HttpConstants.METHOD_GET,
        extensions="txt")
@ServiceDescription("Simple Demo Servlet")
public class MyPostServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = -159625176093879129L;

    private static final Logger log = LoggerFactory.getLogger(MyPostServlet.class);

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) {

        try {
            ResourceResolver resourceResolver = request.getResourceResolver();
            Resource resource = resourceResolver.getResource("/content");

            Node node = resource.adaptTo(Node.class);
            Node newNode = node.addNode("demoNode", "nt:unstructured");
            newNode.setProperty("name", "Demo Node ");

            resourceResolver.commit();

        } catch (PersistenceException | RepositoryException e) {

            log.error(e.getMessage(), e);

            e.printStackTrace();
        }
    }
}
