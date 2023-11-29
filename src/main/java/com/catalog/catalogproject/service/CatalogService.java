package com.catalog.catalogproject.service;

import com.catalog.catalogproject.entity.Catalog;
import com.catalog.catalogproject.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CatalogService
{
    public List<Catalog> getAllCatalogs();
    public Catalog getCatalogById(String id);


}
