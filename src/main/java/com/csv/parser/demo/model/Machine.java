package com.csv.parser.demo.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Machine {
    private String owner;
    private boolean available;
    private String country;
    private String currency;
    private String machineInfo;
    private String machineType;
    private String photos;
    @Column(unique = true)
    @Id
    private Long sourceId;
    private BigDecimal price;
    private String source;
    private String url;
}
