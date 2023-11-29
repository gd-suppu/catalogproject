package com.catalog.catalogproject.controller;

import com.catalog.catalogproject.entity.Catalog;
import com.catalog.catalogproject.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    //for getting all catalogs
    @GetMapping("/catalogAll")
    public List<Catalog> getAllCatalogs() {
        return catalogService.getAllCatalogs();
    }

    //for getting catalog by id
    @GetMapping("/{catalogId}")
    public Catalog getCatalogById(@PathVariable String uniqId) {
        return catalogService.getCatalogById(uniqId);
    }
}
