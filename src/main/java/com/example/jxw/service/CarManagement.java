package com.example.jxw.service;

import com.example.jxw.entity.Car;

import java.util.List;

public interface CarManagement {

      List<Car> findAllCarType();

     Integer save(Car car);

     Car findById(Integer id);

     Integer deleteById(Integer id);

     Car findById3(Integer id);

     List<Car> findAllByIds(List<Integer> ids,Integer filter);

     Integer saveBatch(List<Car> cars);

     List<Car> findCars(Car car);

     List<Car> queryAllByIsDeletedIsTrue();
}
