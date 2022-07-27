package com.ssafy.live4.exception.resource;

import java.io.FileInputStream;
import java.io.IOException;

public class TryWithResource {

    public static void main(String[] args) {
        TryWithResource test = new TryWithResource();
        test.useStream();
        test.useStreamNewStye();

    }


    public void useStream() {
        //FileInputStream fileInput = null;
        
    	try (FileInputStream fileInput = new FileInputStream("abc.txt")){
            fileInput.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
/*            if (fileInput != null) {
                try {
                    fileInput.close();//자원반납 1. close()메서드 자체가 IOException을 발생시킴
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
        }
    	
    }

    public void useStreamNewStye() {
        // TODO: useStream을 try~with~resource 문장으로 변경하세요.
        // END:
    }
}
