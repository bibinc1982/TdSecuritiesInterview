package com.tdsecurities.interview.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="TRADE")
public class TradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inventory")
    private RefDataEntity refDataEntity;
    private String book;
    private String system;
    private String legalEntity;
    @OneToOne(cascade={CascadeType.ALL})
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="tradeId",unique=true)
    private ValuationEntity valuationEntity;
    private Integer version;
    private String tradeStatus;
    private String productType;
    private String resettingLeg;
    private String productSubtype;
    private String tdsProductType;
    private String secCodeSubtype;
    private String swapType;
    private String description;
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date tradeDate;
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date startDate;
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date maturityDate;
    @Transient
    private long msPc;
    @Transient
    private String breakStatus;
    @Transient
    private String term;
}
