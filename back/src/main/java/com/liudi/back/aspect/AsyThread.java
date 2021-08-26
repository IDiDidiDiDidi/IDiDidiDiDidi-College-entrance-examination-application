package com.liudi.back.aspect;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyThread {
    //    @Override
    @Async
    public void run() {
        System.out.println("---------异步线程---------"+Thread.currentThread().getName());
    }
}