package com.tdsecurities.interview.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@Entity
@Data
@Table(name="REF_DATA")
public class RefDataEntity {
    private String topOfHouse;
    private String segment;
    private String viceChair;
    private String globalBusiness;
    private String policy;
    private String desk;
    private String portfolio;
    private Long bu;
    private String cline;
    @Id
    private String inventory;
}
