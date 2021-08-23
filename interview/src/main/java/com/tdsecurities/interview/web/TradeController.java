package com.tdsecurities.interview.web;

import com.tdsecurities.interview.entity.TradeEntity;
import com.tdsecurities.interview.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trade")
public class TradeController
{
    @Autowired
    TradeService service;
 
    @GetMapping
    public ResponseEntity<List<TradeEntity>> getAllTrades() {
        List<TradeEntity> list = service.getAllTrade();
        return new ResponseEntity<List<TradeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

 
}