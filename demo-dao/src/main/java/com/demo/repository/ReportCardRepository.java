package com.demo.repository;

import com.demo.entity.ReportCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ReportCardRepository extends JpaRepository<ReportCard, Long> {
}
