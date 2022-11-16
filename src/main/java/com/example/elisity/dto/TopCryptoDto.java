package com.example.elisity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopCryptoDto {

    public TopCryptoDto(){

    }

    public TopCryptoDto(String name, String symbol, Integer market_cap_rank, BigDecimal price_btc, Integer score, Date createDate) {
        this.name = name;
        this.symbol = symbol;
        this.market_cap_rank = market_cap_rank;
        this.price_btc = price_btc;
        this.score = score;
        this.createDate = createDate;
    }

    @JsonProperty("name")
    private String name;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("market_cap_rank")
    private Integer market_cap_rank;

    @JsonProperty("price_btc")
    private BigDecimal price_btc;

    @JsonProperty("score")
    private Integer score;

    private Date createDate;

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

    public void setMarket_cap_rank(Integer market_cap_rank) {
        this.market_cap_rank = market_cap_rank;
    }

    public BigDecimal getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(BigDecimal price_btc) {
        this.price_btc = price_btc;
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
}
