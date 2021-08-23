package com.tdsecurities.interview.repository;

import com.tdsecurities.interview.entity.TradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository
        extends JpaRepository<TradeEntity, Long> {
 
}
