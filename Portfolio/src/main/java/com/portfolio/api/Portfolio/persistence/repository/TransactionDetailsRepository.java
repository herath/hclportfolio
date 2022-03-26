package com.portfolio.api.Portfolio.persistence.repository;

import com.portfolio.api.Portfolio.persistence.entity.TransactionDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailsRepository extends CrudRepository<TransactionDetails, Long> {

}
