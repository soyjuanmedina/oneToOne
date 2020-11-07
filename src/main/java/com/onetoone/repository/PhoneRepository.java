package com.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetoone.models.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}

