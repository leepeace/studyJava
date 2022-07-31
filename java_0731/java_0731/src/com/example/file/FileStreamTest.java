package com.example.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 1. File스트림에 대해 알아보자
 * */
public class FileStreamTest {

	public static void main(String[] args) {
		
		try {
			//"a.txt" 파일이 없는 경우FileOutputStream은 새로운 파일을 생성해준다.
			FileOutputStream out = new FileOutputStream("a.txt");
			//파일에 아스키 코드에 해당하는 a로 쓰여짐
			out.write(97);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	

	}

}
