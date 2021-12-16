package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entities.Login;




public interface ILoginRepository extends JpaRepository<Login, Integer>{
	
	Optional<Login> findByEmail(String email);

	@Query(value="select * from login where id=:username", nativeQuery=true )
	Optional<Login> findByUsrName(@Param("username") String username);

}
