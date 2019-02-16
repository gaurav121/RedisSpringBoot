package com.demo.dao.repository;

import com.demo.dao.entity.Address;
import com.demo.dao.entity.ReportCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ReportCardRepository extends JpaRepository<ReportCard, Long> {
}
