package com.itp.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.amazon.entity.DBUser;

@Repository
public interface DBUserRepository extends JpaRepository<DBUser, Integer>
{
			public DBUser findByUsername(String s);
}
