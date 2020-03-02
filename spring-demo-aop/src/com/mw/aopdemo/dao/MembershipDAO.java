package com.mw.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {

        System.out.println(getClass() + ": Doing something in addAccount");

    }
}
