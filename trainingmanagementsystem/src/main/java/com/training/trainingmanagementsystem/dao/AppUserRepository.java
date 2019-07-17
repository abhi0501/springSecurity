package com.training.trainingmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.trainingmanagementsystem.bean.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Integer>{

}
