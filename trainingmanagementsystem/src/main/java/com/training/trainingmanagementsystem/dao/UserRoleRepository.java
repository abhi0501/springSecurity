package com.training.trainingmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.trainingmanagementsystem.bean.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer>{

}
