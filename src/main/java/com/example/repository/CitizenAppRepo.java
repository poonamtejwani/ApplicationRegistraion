package com.example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CitizenApp;

public interface CitizenAppRepo extends JpaRepository<CitizenApp, Serializable> {

}
