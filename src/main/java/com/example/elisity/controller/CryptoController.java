package com.example.elisity.controller;

import com.example.elisity.dto.TopCryptoDto;
import com.example.elisity.service.CryptoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {

    CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/top/current")
    public ResponseEntity<List<TopCryptoDto>> getTopCryptoCurrent() {
        return ResponseEntity.ok().body(cryptoService.getTopCryptoCurrent());
    }

    @GetMapping("/top/past")
    public ResponseEntity<List<TopCryptoDto>> getTopCryptoPast() {
        return ResponseEntity.ok().body(cryptoService.getTopCryptoPast());
    }
}
