package org.sark.carpost.service;

import org.sark.carpost.dto.CreateCarResponseDTO;
import org.sark.carpost.dto.StoreCarProfileRequestDTO;
import org.sark.carpost.entity.CarBrandEntity;
import org.sark.carpost.entity.CarEntity;
import org.sark.carpost.entity.CarGenerationEntity;
import org.sark.carpost.entity.CarModelEntity;
import org.sark.carpost.repository.CarBrandRepository;
import org.sark.carpost.repository.CarGenerationRepository;
import org.sark.carpost.repository.CarModelRepository;
import org.sark.carpost.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CarService {
    @Autowired
    private final CarRepository carRepository;
    @Autowired
    private final CarModelRepository carModelRepository;
    @Autowired
    private final CarGenerationRepository carGenerationRepository;
    @Autowired
    private final CarBrandRepository carBrandRepository;


    public CarService(CarRepository carRepository, CarModelRepository carModelRepository,
                      CarGenerationRepository carGenerationRepository, CarBrandRepository carBrandRepository) {
        this.carRepository = carRepository;
        this.carModelRepository = carModelRepository;
        this.carGenerationRepository = carGenerationRepository;
        this.carBrandRepository = carBrandRepository;
    }
    private static final Logger logger = LoggerFactory.getLogger(CarService.class);

    public CreateCarResponseDTO createCar() {
        List<CarBrandEntity> carBrands = carBrandRepository.findAll();
        List<CarModelEntity> carModels = carModelRepository.findAll();
        List<CarGenerationEntity> carGenerations = carGenerationRepository.findAll();
        CreateCarResponseDTO createCarResponseDTO = new CreateCarResponseDTO();
        createCarResponseDTO.setCarBrands(carBrands);
        createCarResponseDTO.setCarModels(carModels);
        createCarResponseDTO.setCarGenerations(carGenerations);
        return createCarResponseDTO;
        /* Кратко: Этот метод получает все данные о поколениях машин, марках и моделях
        из базы данных,затем собирает эти данные в объект DTO и возвращает его. DTO (Data Transfer Object)
        используется для передачи данных между слоями приложения */
    }
    /*public void addCar(StoreCarProfileRequestDTO storeCarProfileRequestDTO) {
        CarEntity carEntity = new CarEntity();
        carEntity.setName(storeCarProfileRequestDTO.getCarName());
        carEntity.setPlate(storeCarProfileRequestDTO.getPlate());
        carEntity.setVin(storeCarProfileRequestDTO.getVin());
        carEntity.setBrand(storeCarProfileRequestDTO.getBrandId());

    } */
}
