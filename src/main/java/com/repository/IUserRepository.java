package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.entities.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	@Query(value = "SELECT * FROM users u WHERE u.username = ?1", nativeQuery = true)
	UserEntity findByUserName(Long username);

}
