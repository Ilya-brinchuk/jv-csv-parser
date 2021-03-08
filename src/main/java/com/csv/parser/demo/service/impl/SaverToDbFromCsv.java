package com.csv.parser.demo.service.impl;

import com.csv.parser.demo.model.Machine;
import com.csv.parser.demo.service.CsvSaver;
import com.csv.parser.demo.service.MachineService;
import com.opencsv.CSVReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;

@Service
public class SaverToDbFromCsv implements CsvSaver {
    private static final int OWNER = 0;
    private static final int AVAILABLE = 1;
    private static final int COUNTRY = 2;
    private static final int CURRENCY = 3;
    private static final int MACHINE_INFO = 4;
    private static final int MACHINE_TYPE = 5;
    private static final int PHOTOS = 6;
    private static final int SOURCE_ID = 7;
    private static final int PRICE = 8;
    private static final int SOURCE = 9;
    private static final int URL = 10;
    private final MachineService machineService;

    public SaverToDbFromCsv(MachineService machineService) {
        this.machineService = machineService;
    }

    @Override
    public void saveToDbFromCsv(String path) {
        try (Reader reader = Files.newBufferedReader(Paths.get(path));
                CSVReader csvReader = new CSVReader(reader)) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                if (nextRecord[0].equals("owner")) {
                    nextRecord = csvReader.readNext();
                }
                machineService.save(generateMachine(nextRecord));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Machine generateMachine(String[] nextRecord) {
        Machine machine = new Machine();
        machine.setOwner(nextRecord[OWNER]);
        machine.setAvailable(Boolean.getBoolean(nextRecord[AVAILABLE]));
        machine.setCountry(nextRecord[COUNTRY]);
        machine.setCurrency(nextRecord[CURRENCY]);
        machine.setMachineInfo(nextRecord[MACHINE_INFO]);
        machine.setMachineType(nextRecord[MACHINE_TYPE]);
        machine.setPhotos(nextRecord[PHOTOS]);
        machine.setSourceId(Long.parseLong(nextRecord[SOURCE_ID]));
        machine.setPrice(new BigDecimal(nextRecord[PRICE]));
        machine.setSource(nextRecord[SOURCE]);
        machine.setUrl(nextRecord[URL]);
        return machine;
    }
}
