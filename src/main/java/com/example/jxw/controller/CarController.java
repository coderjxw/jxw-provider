package com.example.jxw.controller;

import com.example.jxw.config.RedisService;
import com.example.jxw.entity.Car;
import com.example.jxw.enums.DmpCustomerTagFilterType;
import com.example.jxw.enums.OtherFileType;
import com.example.jxw.service.impl.CarManagementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarManagementImpl carManagement;
    @Autowired
    private RedisService redisService;

    @Autowired
    private MessageSource messageSource;

    private static final String DISPLAY_NAME_PREFIX_FORMAT = "serviceRecordDocs.displayName.%s";

    @GetMapping("/findAll")
    public List<Car> findAll() {
        return carManagement.findAllCarType();
    }

    @PostMapping("save")
    public Integer save(@RequestBody Car car) {
        car.setName(null);
        Integer id = carManagement.save(car);
        redisService.set("car_" + id, car.toString());
        return id;
    }

    @GetMapping("/findById")
    public Car findById(@RequestParam Integer id) {
        return carManagement.findById(id);
    }

    @GetMapping("/findByIdCache")
    @Cacheable(value = "fruit1", key = "#param")
    public Car findByIdCache(@RequestParam Integer param) {
        return carManagement.findById(param);
    }

    @GetMapping("/findByIdCache2")
    public Car findByIdCache2(@RequestParam Integer param, @RequestParam DmpCustomerTagFilterType dmpCustomerTagFilterType) {
        return carManagement.findById(param);
    }

    @GetMapping("/findByIdCache3")
    public Car findByIdCache3(@RequestParam Integer param) {
        return carManagement.findById3(param);
    }
    @DeleteMapping("/deleteByIdCache")
    public Integer delteByIdCache(@RequestParam Integer param) {
        return carManagement.deleteById(param);
    }

    @GetMapping("/findAllByFilter")
    public List<Car> findAllByFilter(@RequestParam List<Integer> param, Integer filter) {
        return carManagement.findAllByIds(param, filter);
    }

    @PostMapping("/saveBatch")
    public Integer saveBatch(){
        List<Car> cars = Arrays.asList(
                Car.builder().model("model1").name("name 1").isDeletedFlag(true).build(),
                Car.builder().model("model2").name("name 2").isDeletedFlag(true).build(),
                Car.builder().model("model3").name("name 3").isDeletedFlag(true).build()
        );
        return carManagement.saveBatch(cars);
    }



    @GetMapping("/queryCars")
    public List<Car> queryCars(){
        List<Car> cars = Arrays.asList(
                Car.builder().id(15).build(),
                Car.builder().id(16).build(),
                Car.builder().id(17).build()
        );

        return carManagement.findCars(Car.builder().id(15).build());
    }


    @GetMapping("/helm")
    public void helm(@RequestParam String fileType){
        DocsType docs = DocsType.valueOf("STAR_D");
        String result = safeDisplayNamePrefix(fileType, docs);
        System.out.println(result);

    }


    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file,
                                             @RequestParam("fileType") String fileType) {

        return "serviceRecordDocsService.upload(fileType, file)";
    }

    private String safeDisplayNamePrefix(String fileType, DocsType docsType) {
        if (DocsType.STAR_D == docsType) {
            fileType = OtherFileType.getFileTypeByValueStartD(fileType).getValue().replaceAll(" ","");
        }
        return messageSource.getMessage(format(DISPLAY_NAME_PREFIX_FORMAT, fileType), null, fileType, null);
    }

    public enum DocsType {
        OTR(1),
        STAR_D(2),
        OTHER(3);

        private int sortNumber;

        DocsType(int sortNumber) {
            this.sortNumber = sortNumber;
        }

        public int getSortNumber() {
            return sortNumber;
        }
    }
    @GetMapping("/findAllCarNotIsDeleted")
    public List<Car> getAllCarNotIsDeleted(){
        return carManagement.queryAllByIsDeletedIsTrue();
    }
}
