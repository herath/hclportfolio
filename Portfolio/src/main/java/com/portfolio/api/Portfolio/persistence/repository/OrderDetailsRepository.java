package com.portfolio.api.Portfolio.persistence.repository;

import com.portfolio.api.Portfolio.persistence.entity.OrderDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> {

    @Query("SELECT u FROM OrderDetails u WHERE u.orderRefNo = :orderRef")
    OrderDetails getByOrderRefNo(@Param("orderRef") String orderRef);
}
