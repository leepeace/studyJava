package com.ssafy.live5.io.process.buffered;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ProcessingTextReadTest {
    public static void main(String[] args) {
        File src = new File("./.project");
        
        //BufferedReader는 보조 스트림
        try (BufferedReader br = new BufferedReader(new FileReader(src));) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
