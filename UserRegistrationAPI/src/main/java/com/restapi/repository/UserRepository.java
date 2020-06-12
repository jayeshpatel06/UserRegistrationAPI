/**
* @author  Jayesh Patel
*/

package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 
}
