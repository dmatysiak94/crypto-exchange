package com.example.elisity.Scheduler;

import com.example.elisity.service.CryptoService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Scheduler {

    private final CryptoService cryptoService;

    public Scheduler(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @Scheduled(initialDelay = 30000, fixedDelay = 30000)
    public void sendUpdateCvReminderFromScheduler() {
        cryptoService.schedulerTopCryptoRequest();
    }
}
