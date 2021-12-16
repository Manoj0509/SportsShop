package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.entities.OrderEntity;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {

	@Query(value = "SELECT * FROM orderss o WHERE o.cust_id = ?1", nativeQuery = true)
	List<OrderEntity> findByCustId(Long custId);
}
