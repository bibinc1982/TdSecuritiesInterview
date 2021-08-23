package com.tdsecurities.interview.service;

import com.tdsecurities.interview.entity.TradeEntity;
import com.tdsecurities.interview.entity.ValuationEntity;
import com.tdsecurities.interview.repository.TradeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TradeServiceTest {
    @InjectMocks
    TradeService tradeService;
    @Mock
    TradeRepository tradeRepository;

    List<TradeEntity> testData;

    TradeEntity firstTrade;

    ValuationEntity firstValuationEntity;

    TradeEntity secondTrade;

    @Before
    public void setUp() throws Exception {
        testData =new ArrayList<>();
        firstTrade=new TradeEntity();
        firstValuationEntity= new ValuationEntity();
        firstTrade.setId(1L);
        firstTrade.setBook("IRD_TOR_LONGTERM");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //Parsing the given String to Date object
        firstTrade.setMaturityDate(formatter.parse("2025-01-12"));
        firstValuationEntity.setUqlOcMmbMs(5000L);
        firstValuationEntity.setUqlOcMmbMsPc(1000L);
        firstValuationEntity.setTradeId(500L);
        firstTrade.setValuationEntity(firstValuationEntity);
        testData.add(firstTrade);
        secondTrade=new TradeEntity();
        secondTrade.setId(2L);
        secondTrade.setBook("NY_SWAP_WASH");
        secondTrade.setMaturityDate(formatter.parse("2020-01-12"));
        testData.add(secondTrade);
    }

    @Test
    public void testGetAllTrades(){
        when(tradeRepository.findAll()).thenReturn(new ArrayList<TradeEntity>());
        assertEquals(0,tradeService.getAllTrade().size());
    }
    @Test
    public void testGetAllTradesWithData(){
        when(tradeRepository.findAll()).thenReturn(testData);
        List<TradeEntity> result = tradeService.getAllTrade();
        assertEquals(2,result.size());
        assertEquals(1l,result.get(0).getId());
        assertEquals("IRD_TOR_LONGTERM",result.get(0).getBook());
        assertEquals(4000,result.get(0).getMsPc());
        assertEquals("1000-9999",result.get(0).getBreakStatus());
        assertEquals("1yr-10yr",result.get(0).getTerm());
        assertEquals(2l,result.get(1).getId());
        assertEquals("NY_SWAP_WASH",result.get(1).getBook());
        assertEquals(0,result.get(1).getMsPc());
        assertEquals(null,result.get(1).getBreakStatus());
        assertEquals(null,result.get(1).getTerm());
    }

}