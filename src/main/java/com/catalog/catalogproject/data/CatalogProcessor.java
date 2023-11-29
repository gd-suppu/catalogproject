package com.catalog.catalogproject.data;

import com.catalog.catalogproject.entity.Catalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class CatalogProcessor implements ItemProcessor<CatalogInput, Catalog> {

    private static final Logger log = LoggerFactory.getLogger(CatalogProcessor.class);

    @Override
    public Catalog process(final CatalogInput catalogInput) {

        Catalog catalog = new Catalog();
        catalog.setUniqId(catalogInput.getUniq_id());
        catalog.setNameTitle(catalogInput.getName_title());
        catalog.setListPrice(catalogInput.getList_price());
        catalog.setSku(catalogInput.getSku());
        catalog.setDescription(catalogInput.getDescription());
        return catalog;
    }

}