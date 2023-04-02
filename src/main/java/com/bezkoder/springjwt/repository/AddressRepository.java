package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    // any custom methods can be added here
}