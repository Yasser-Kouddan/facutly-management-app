package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Long> {

	Admin findAdminByUsernameAndPassword(String username, String password);


}
