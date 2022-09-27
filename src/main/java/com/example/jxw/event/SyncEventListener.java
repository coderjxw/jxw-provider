package com.example.jxw.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class SyncEventListener {

    @EventListener
    @Async
    public void SyncEventHandle(SyncEvent syncEvent){
        Thread current = Thread.currentThread();
        System.out.println("tread name:"+current.getName()+" event:"+ syncEvent.toString());
    }
}
