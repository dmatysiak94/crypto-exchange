package com.example.elisity.service;

import com.example.elisity.dto.TopCryptoDto;
import com.example.elisity.en.RequestEnum;
import com.example.elisity.entity.CryptoCurrencyEntity;
import com.example.elisity.helper.HttpHelper;
import com.example.elisity.repository.CryptoCurrencyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@PropertySource(value = {"classpath:ulr-addresses.properties"})
public class CryptoServiceImpl implements CryptoService {

    HttpHelper httpHelper;
    ObjectMapper objectMapper;
    CryptoCurrencyRepository cryptoCurrencyRepository;

    String[] headers = new String[]{"Content-Type", "application/json"};

    @Value("${gecko.host}")
    String geckoHost;

    @Value("${gecko.path.topCrypto}")
    String geckoTopCrypto;

    private final int TOP_FIVE_CRYPTO_CURRENCIES = 5;

    public CryptoServiceImpl(HttpHelper httpHelper, ObjectMapper objectMapper
            , CryptoCurrencyRepository cryptoCurrencyRepository) {
        this.httpHelper = httpHelper;
        this.objectMapper = objectMapper;
        this.cryptoCurrencyRepository = cryptoCurrencyRepository;
    }

    @Override
    @Transactional()
    public void schedulerTopCryptoRequest() {
        List<TopCryptoDto> topCurrencies = getTopCryptoCurrent();
        List<CryptoCurrencyEntity> topCryptoEntities = prepareTopCryptoEntities(topCurrencies);
        cryptoCurrencyRepository.saveAll(topCryptoEntities);
    }

    private List<CryptoCurrencyEntity> prepareTopCryptoEntities(List<TopCryptoDto> topCurrencies) {
        ModelMapper modelMapper = new ModelMapper();
        return topCurrencies.stream().map(topCryptoDto -> {
            CryptoCurrencyEntity cryptoCurrencyEntity = modelMapper.map(topCryptoDto, CryptoCurrencyEntity.class);
            cryptoCurrencyEntity.setRequestBy(RequestEnum.SCHEDULER.toString());
            cryptoCurrencyEntity.setCreateDate(new Date());
            return cryptoCurrencyEntity;
        }).collect(Collectors.toList());
    }

    @Override
    public List<TopCryptoDto> userTopCryptoRequest() {
        return getTopCryptoCurrent();
    }

    @Override
    public List<TopCryptoDto> getTopCryptoCurrent() {
        String uri = geckoHost + geckoTopCrypto;
        JSONObject jsonObject;
        List<TopCryptoDto> topCryptoDtoList = new ArrayList<>();
        try {
            jsonObject = httpHelper.getGenericObjectFromService(uri, headers);
            topCryptoDtoList = clearJson(jsonObject, "coins");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return topCryptoDtoList;
    }

    @Override
    public List<TopCryptoDto> getTopCryptoPast() {
        return cryptoCurrencyRepository.findAll().stream()
                .map(item -> {
                    ModelMapper modelMapper = new ModelMapper();
                    return modelMapper.map(item, TopCryptoDto.class);
                }).collect(Collectors.toList());
    }

    private List<TopCryptoDto> clearJson(JSONObject jsonObject, String lvl) throws JsonProcessingException {
        String a = jsonObject.get(lvl).toString();
        Gson gson = new Gson();
        Type type = new TypeToken<List<Map<String, TopCryptoDto>>>() {
        }.getType();
        List<Map<String, TopCryptoDto>> cryptoListOfMap = gson.fromJson(a, type);

        return cryptoListOfMap.stream()
                .map(map -> new ArrayList<TopCryptoDto>(map.values()))
                .flatMap(List::stream)
                .limit(TOP_FIVE_CRYPTO_CURRENCIES)
                .collect(Collectors.toList());
    }
}
