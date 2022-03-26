package com.portfolio.api.Portfolio.persistence.repository;

import com.portfolio.api.Portfolio.persistence.Entity.AssetDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetDetailsRepository extends CrudRepository<AssetDetails, Long> {

    AssetDetails findByAssetName(String assetName);
}
