package com.portfolio.api.Portfolio.persistence.repository;

import com.portfolio.api.Portfolio.persistence.entity.Asset;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends CrudRepository<Asset, Long> {

    @Query("SELECT u FROM Asset u WHERE u.name = :name")
    Asset getByAssetName(@Param("name") String name);
}
