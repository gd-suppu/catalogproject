package com.catalog.catalogproject.service;

import com.catalog.catalogproject.entity.Catalog;
import com.catalog.catalogproject.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CatalogServiceImpl implements CatalogService{

    @Autowired
    private CatalogRepository catalogRepository;
    @Override
    public List<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog getCatalogById(String id) {
        return catalogRepository.findById(id).isPresent()?catalogRepository.findById(id).get():new Catalog();
    }
}
