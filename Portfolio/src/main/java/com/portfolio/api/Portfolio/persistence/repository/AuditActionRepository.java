package com.portfolio.api.Portfolio.persistence.repository;

import com.portfolio.api.Portfolio.persistence.entity.AuditAction;
import org.springframework.data.repository.CrudRepository;

public interface AuditActionRepository extends CrudRepository<AuditAction, Long> {

}
