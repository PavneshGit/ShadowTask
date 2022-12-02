package com.myapp.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;



@Model(adaptables = Resource.class)
public class Footer {

    @ValueMapValue( injectionStrategy= InjectionStrategy.OPTIONAL)
    @Default(values="textFooter")
    protected String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
