package com.mw.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

@Component
public class PractiseActivity5FortuneService implements FortuneService {

    private Random random = new Random();
    private String path = "src/fortunes.txt";
    private ArrayList<String> strings;
    private File file = new File(path);

    @Override
    public String getFortune() {
      //  Removed because of ACTIVITY 6#
      /*  strings = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String tempLine;

            while ((tempLine = bufferedReader.readLine()) != null) {
                strings.add(tempLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        int i = random.nextInt(strings.size());

        return strings.get(i);
    }


    //ACTIVITY #6
    @PostConstruct
    private void readAllFortunes(){
        strings = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String tempLine;

            while ((tempLine = bufferedReader.readLine()) != null) {
                strings.add(tempLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
