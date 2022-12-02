package com.myapp.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FooterMultiField {
    @Inject
    @Named("./blockMultiFieldList")
    private List<BlockMultiField> blockMultiFieldList;

    public List<BlockMultiField> getBlockMultiFieldList()
    {
        return blockMultiFieldList;
    }
}
