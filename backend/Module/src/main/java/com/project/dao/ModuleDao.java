package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.model.Module;


@Repository
public interface ModuleDao extends JpaRepository<Module, Long> {
	

}
