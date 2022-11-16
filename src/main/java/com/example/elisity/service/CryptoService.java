package com.example.elisity.service;

import com.example.elisity.dto.TopCryptoDto;

import java.util.List;

public interface CryptoService {

    void schedulerTopCryptoRequest();

    List<TopCryptoDto> userTopCryptoRequest();

    List<TopCryptoDto> getTopCryptoCurrent();

    List<TopCryptoDto> getTopCryptoPast();
}
