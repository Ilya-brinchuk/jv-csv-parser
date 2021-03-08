package com.csv.parser.demo.repository;

import com.csv.parser.demo.model.Machine;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MachineRepository extends JpaRepository<Machine, Long> {
    
    @Query("select count(m.sourceId) FROM Machine m group by m.machineType")
    List<Long> numberOfMachinesByModel();
    
    List<Machine> findAllByOwner(String owner);
    
    List<Machine> findAllByMachineInfoLike(String attribute);
}
