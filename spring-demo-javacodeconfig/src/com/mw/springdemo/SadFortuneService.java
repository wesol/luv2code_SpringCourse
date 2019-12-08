package com.mw.springdemo;

public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return ":( Don't you cry";
    }
}
