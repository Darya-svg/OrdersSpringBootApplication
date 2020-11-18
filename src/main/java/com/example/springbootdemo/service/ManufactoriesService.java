package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Manufact;
import com.example.springbootdemo.repository.ManufactoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactoriesService {
    private final ManufactoriesRepository manufactoriesRepository;

    @Autowired
    public ManufactoriesService(ManufactoriesRepository manufactoriesRepository) {
        this.manufactoriesRepository = manufactoriesRepository;
    }

    public Manufact findById(int idManufact){
        return manufactoriesRepository.getOne(idManufact);
    }

    public List<Manufact> findAll(){
        return manufactoriesRepository.findAll();
    }

    public Manufact saveManufact(Manufact manufact){
        return manufactoriesRepository.save(manufact);
    }

    public void deleteById(int idManufact){
        manufactoriesRepository.deleteById(idManufact);
    }



}
