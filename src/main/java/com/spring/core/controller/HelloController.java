package com.spring.core.controller;

import com.spring.core.service.MessageService;
import com.spring.core.service.RedisServiceExample;
import com.spring.core.utils.Java8;
import com.spring.core.utils.TextBlocks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {
    private final RedisServiceExample redisServiceExample;

    private final MessageService messageService;

    public HelloController(RedisServiceExample redisServiceExample, MessageService messageService) {
        this.redisServiceExample = redisServiceExample;
        this.messageService = messageService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        testMessageSource();
        return "Hello World";
    }

    private void testMessageSource() {
        String message = messageService.getMessage("welcome");
        System.out.println(message);
    }

    private void testJava8() {
        Java8 java8 = new Java8();
        java8.log();
    }

    private void testTextBlocks() {
        TextBlocks textBlocks = new TextBlocks();
        textBlocks.log();
    }

    @GetMapping("/redis")
    public void redis() {
        String bike1 = redisServiceExample.getValue("bike:1").toString();
        System.out.println(bike1);
        Objects.hash(bike1);
    }
}
