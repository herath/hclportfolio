package com.portfolio.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetDetailsRepository extends CrudRepository<AssetDetails, Long> {

    AssetDetails findByAssetName(String assetName);
}
