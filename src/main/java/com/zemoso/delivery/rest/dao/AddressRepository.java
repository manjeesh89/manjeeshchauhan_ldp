package com.zemoso.delivery.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zemoso.delivery.rest.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
