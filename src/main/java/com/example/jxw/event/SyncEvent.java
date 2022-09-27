package com.example.jxw.event;

import lombok.*;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SyncEvent  {


    private String message;


/*    *//**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     *//*
    public SyncEvent(Object source,String message) {
        super(source);
        this.message = message;
    }*/
}
