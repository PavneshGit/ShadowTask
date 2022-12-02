package com.myapp.core.models;

import com.adobe.cq.export.json.ExporterConstants;
import org.apache.jackrabbit.api.security.user.*;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

@Model(adaptables = Resource.class)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)

public class HeaderTask {
    @ValueMapValue
    private String userName;
    @SlingObject
    ResourceResolver resourceResolver;
    public String getUserName() {
        return userName;
    }
    @PostConstruct
    public void init() throws RepositoryException {
        final Session session = resourceResolver.adaptTo(Session.class);
        final String userId = session.getUserID();
        final UserManager userManager = resourceResolver.adaptTo(UserManager.class);
        final User user = (User) userManager.getAuthorizable(userId);
        userName=user.getID().toString();
    }

}
