package com.tdsecurities.interview.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="VALUATION")
public class ValuationEntity {
    @Id
    private Long tradeId;
    private Long uqlOcMmbMs;
    private Long uqlOcMmbMsPc;
}
