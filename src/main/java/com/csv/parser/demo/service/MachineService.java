package com.csv.parser.demo.service;

import com.csv.parser.demo.model.Machine;
import java.util.List;

public interface MachineService {
    Machine save(Machine machine);

    Machine update(Machine machine);
    
    Machine get(Long sourceId);

    List<Long> getNumberOfMachineByModel();
    
    List<Machine> findAllMachineByAttribute(String attribute);
    
    List<Machine> findAllMachineByOwner(String owner);
}
