package com.example.jxw.dao;

import com.example.jxw.entity.Car;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Override
    @Cacheable(value = "CarRepository.findById", key ="#id")
    Optional<Car> findById(Integer id);

    @Modifying
    @Transactional
    @Query(value = " delete from car where  is_deleted = 0 ", nativeQuery = true)
    Integer deleteCarByDeletedFlagIsFalse();

    @Modifying
    @Transactional
    @Query(value = " update car  set is_deleted = 0 ", nativeQuery = true)
    int updateCarDeletedFlagTrue();

    @Query(value ="select * from car where id = :#{#car.id}" ,nativeQuery = true)
    List<Car> queryCars(@Param("car") Car car);

    List<Car> queryAllByIsDeletedFlagIsTrue();
}
