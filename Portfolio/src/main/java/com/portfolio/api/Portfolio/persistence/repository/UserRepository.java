package com.portfolio.api.Portfolio.persistence.repository;

import com.portfolio.api.Portfolio.persistence.entity.PortfolioDetails;
import com.portfolio.api.Portfolio.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
