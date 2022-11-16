package com.example.elisity.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "top_currencies")
public class CryptoCurrencyEntity {

    public CryptoCurrencyEntity() {
    }

    public CryptoCurrencyEntity(Long id, String name, String symbol, Integer market_cap_rank, BigDecimal price_btc, Integer score, String requestBy, Date createDate) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.market_cap_rank = market_cap_rank;
        this.price_btc = price_btc;
        this.score = score;
        this.requestBy = requestBy;
        this.createDate = createDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "market_cap_rank")
    private Integer market_cap_rank;

    @Column(name = "price_btc")
    private BigDecimal price_btc;

    @Column(name = "score")
    private Integer score;

    @Column(name = "request_by")
    private String requestBy;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getMarket_cap_rank() {
        return market_cap_rank;
    }

    public void setMarket_cap_rank(Integer marketCapRank) {
        this.market_cap_rank = marketCapRank;
    }

    public BigDecimal getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(BigDecimal priceBtc) {
        this.price_btc = priceBtc;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }
}
