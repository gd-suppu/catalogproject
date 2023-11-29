package com.catalog.catalogproject.repository;

import com.catalog.catalogproject.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends JpaRepository<Catalog,String> {
}
