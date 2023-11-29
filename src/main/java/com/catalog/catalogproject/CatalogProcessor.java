package com.catalog.catalogproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CatalogProcessor implements ItemProcessor<CatalogInput, CatalogInput> {

    private static final Logger log = LoggerFactory.getLogger(CatalogProcessor.class);

    @Override
    public CatalogInput process(CatalogInput catalogInput) {

        /*Catalog catalog = new Catalog();
        catalog.setUniqId(catalogInput.getUniq_id());
        catalog.setNameTitle(catalogInput.getName_title());
        catalog.setListPrice(catalogInput.getList_price());
        catalog.setSku(catalogInput.getSku());
        catalog.setDescription(catalogInput.getDescription()); */
        return catalogInput;
    }

}