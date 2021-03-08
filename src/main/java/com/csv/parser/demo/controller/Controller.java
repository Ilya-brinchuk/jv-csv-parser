package com.csv.parser.demo.controller;

import com.csv.parser.demo.service.CsvSaver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Controller {
    @Value("${file-path}")
    private String path;
    private final CsvSaver csvSaver;

    public Controller(CsvSaver csvSaver) {
        this.csvSaver = csvSaver;
    }
    
    @Scheduled(cron = "0 0 12 * * ?")
    public void init() {
        csvSaver.saveToDbFromCsv(path);
    }
}
