package com.tdsecurities.interview.service;

import com.tdsecurities.interview.entity.TradeEntity;
import com.tdsecurities.interview.repository.TradeRepository;
import com.tdsecurities.interview.utils.TermsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TradeService {
     
    @Autowired
    TradeRepository repository;
    @Autowired
    TermsUtils termsUtils;
     
    public List<TradeEntity> getAllTrade()
    {
        List<TradeEntity> tradeList = repository.findAll();

        if(tradeList.size() > 0) {
            tradeList.stream().forEach(tradeEntity -> {
                if (tradeEntity.getValuationEntity() != null) {
                    tradeEntity.setMsPc(tradeEntity.getValuationEntity().getUqlOcMmbMs() - tradeEntity.getValuationEntity().getUqlOcMmbMsPc());
                }
                tradeEntity.setTerm(termsUtils.findDifference(tradeEntity.getMaturityDate(),new Date()));
            });
            return tradeList;
        } else {
            return new ArrayList<TradeEntity>();
        }
    }




}