package com.csv.parser.demo.service.impl;

import com.csv.parser.demo.exception.DataProcessingException;
import com.csv.parser.demo.model.Machine;
import com.csv.parser.demo.repository.MachineRepository;
import com.csv.parser.demo.service.MachineService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MachineServiceImpl implements MachineService {
    private final MachineRepository machineRepository;

    public MachineServiceImpl(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public Machine save(Machine machine) {
        return machineRepository.save(machine);
    }

    @Override
    public Machine update(Machine machine) {
        return machineRepository.save(machine);
    }

    @Override
    public Machine get(Long sourceId) {
        return machineRepository.findById(sourceId).orElseThrow(() ->
                new DataProcessingException("Can't find machine"));
        
    }
    
    @Override
    public List<Long> getNumberOfMachineByModel() {
        return machineRepository.numberOfMachinesByModel();
    }

    @Override
    public List<Machine> findAllMachineByAttribute(String attribute) {
        return machineRepository.findAllByMachineInfoLike("%" + attribute + "%");
    }

    @Override
    public List<Machine> findAllMachineByOwner(String owner) {
        return machineRepository.findAllByOwner(owner);
    }
}
