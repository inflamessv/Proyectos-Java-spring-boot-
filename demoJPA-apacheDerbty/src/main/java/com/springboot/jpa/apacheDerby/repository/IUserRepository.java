package com.springboot.jpa.apacheDerby.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.apacheDerby.model.UserRecord;

@Repository
public interface IUserRepository  extends JpaRepository<UserRecord,Integer>{

}
