package com.tdsecurities.interview.service;

import com.tdsecurities.interview.entity.TradeEntity;
import com.tdsecurities.interview.repository.TradeRepository;
import com.tdsecurities.interview.utils.BreakStatusUtils;
import com.tdsecurities.interview.utils.TermsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TradeService {
    private static Logger LOGGER = LoggerFactory.getLogger(TradeService.class);
    @Autowired
    TradeRepository repository;

     
    public List<TradeEntity> getAllTrade()
    {
        List<TradeEntity> tradeList = repository.findAll();

        if(tradeList.size() > 0) {
            tradeList.stream().forEach(tradeEntity -> {
                if (tradeEntity.getValuationEntity() != null) {
                    long msPc=tradeEntity.getValuationEntity().getUqlOcMmbMs() - tradeEntity.getValuationEntity().getUqlOcMmbMsPc();
                    tradeEntity.setMsPc(msPc);
                    tradeEntity.setBreakStatus(BreakStatusUtils.findBreakStatus(msPc));
                }
                tradeEntity.setTerm(TermsUtils.findDifference(tradeEntity.getMaturityDate(),new Date()));
            });
            return tradeList;
        } else {
            LOGGER.info("No Trade details available");
            return new ArrayList<TradeEntity>();
        }
    }




}