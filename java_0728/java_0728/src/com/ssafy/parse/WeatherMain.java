package com.ssafy.parse;

import java.util.List;

public class WeatherMain {
	
	public static void main(String[] args) {
		
		//콘솔에서 찍기
		WeatherDAO weatherDao = WeatherDAO.getWeatherDAO();
		
		String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2920054000";
		List<Weather> datas = weatherDao.getWeatherList(url);
	
		for(Weather d : datas) {
			System.out.println(d);
		}
		
	}//end main
	
}
