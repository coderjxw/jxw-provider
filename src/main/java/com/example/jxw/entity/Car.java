package com.example.jxw.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "car")
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="model")
    private String model;
    @Column(name ="name")
    private String name ;

    @Column(name ="is_deleted")
    private boolean isDeletedFlag ;

    @Transient
    private List<Pepole> pepoleList;

    @Transient
    private String date;

    public String getDate(){
        if(this.date ==null){
            return "";
        }
        Calendar ca =Calendar.getInstance();
        ca.setTimeInMillis(Long.parseLong(this.date));
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(ca.getTime());
    }

    public static final Car ZERO = new Car(0);

    public Car (Integer id ){
        this.id = id ;
    }


}
