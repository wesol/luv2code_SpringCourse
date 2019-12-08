package com.mw.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] s = {"a", "b", "c"};
    private Random random = new Random();

    @Override
    public String getFortune() {

        int i = random.nextInt(s.length);
        return s[i];
    }
}
