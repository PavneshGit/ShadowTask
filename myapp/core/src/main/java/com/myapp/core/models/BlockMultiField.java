package com.myapp.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public  class BlockMultiField {
    @Inject
    private String block;

    @Inject
    @Named("./itemsMultiFieldList")
    private List<ItemsMultiField> itemsMultiFieldList;
    public List<ItemsMultiField> getItemsMultiFieldList()
    {
        return itemsMultiFieldList;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

}
