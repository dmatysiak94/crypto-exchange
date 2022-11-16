package com.example.elisity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyArrayListDto {

    public MyArrayListDto() {
    }

    public MyArrayListDto(List<Map<String, TopCryptoDto>> myArrayList) {
        this.myArrayList = myArrayList;
    }

    @JsonProperty("myArrayList")
    List<Map<String, TopCryptoDto>> myArrayList;

    public List<Map<String, TopCryptoDto>> getMyArrayList() {
        return myArrayList;
    }

    public void setMyArrayList(List<Map<String, TopCryptoDto>> myArrayList) {
        this.myArrayList = myArrayList;
    }
}
