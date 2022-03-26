package com.portfolio.api.Portfolio.persistence.repository;


import com.portfolio.api.Portfolio.persistence.entity.PortfolioAssetDetails;
import com.portfolio.api.Portfolio.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PortfolioAssetDetailsRepository extends JpaRepository<PortfolioAssetDetails, UUID> {

	List<PortfolioAssetDetails> findByUser(User user);

}
