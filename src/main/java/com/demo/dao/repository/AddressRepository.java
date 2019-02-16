package com.demo.dao.repository;

import com.demo.dao.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AddressRepository extends JpaRepository<Address, Long> {
}
