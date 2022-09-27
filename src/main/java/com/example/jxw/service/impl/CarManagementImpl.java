package com.example.jxw.service.impl;

import com.example.jxw.dao.CarRepository;
import com.example.jxw.entity.Car;
import com.example.jxw.service.CarManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarManagementImpl implements CarManagement {

    @Autowired
    private CarRepository carRepository;
    @Override
    public List<Car> findAllCarType() {
        System.out.println("run findAllCarType!");
        return carRepository.findAll();
    }

    @Override
    public Integer save(Car car) {
         carRepository.save(car);

         return car.getId();
    }

    @Override
    public Car findById(Integer id) {
        return this.findById2(id);
    }

    @Override
    @CacheEvict(cacheNames = {"fruit1","fruit2"}, allEntries = true, beforeInvocation = true)
    public Integer deleteById(Integer id) {
        //carRepository.deleteById(id);
        return 1;
    }


    public Car findById2(Integer id) {
        System.out.println("from db 2");
        return carRepository.findById(id).get();
    }

    @Override
    public Car findById3(Integer id) {
        return carRepository.findById(id).get();
    }

    @Override
    public List<Car> findAllByIds(List<Integer> ids,Integer filter) {
        List<Car> result = carRepository.findAllById(ids);

        List<Car> result2=  result.stream().filter(sub ->sub.getId().equals(filter)).collect(Collectors.toList());
        return result2.stream().map(sub2 -> {sub2.setName("222");return sub2;}).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Integer saveBatch(List<Car> cars) {
        carRepository.saveAll(cars);
        cars.forEach(data -> data.setName("new Name"));
        return 1;
    }

    @Override
    public List<Car> findCars(Car car) {
        return carRepository.queryCars(car);
    }

    @Override
    public List<Car> queryAllByIsDeletedIsTrue(){
        return carRepository.queryAllByIsDeletedFlagIsTrue();
    }
}
