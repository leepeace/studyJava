package com.ssafy.ws.step2;

import java.util.Arrays;

public class MovieManagerImpl implements IMovieManager {

	private static final int MAX_SIZE = 100; 
	
	private Movie[] movieList = new Movie[MAX_SIZE];
	
	private int size;
	
	//싱글톤 적용 객체 생성
	private static IMovieManager instance = new MovieManagerImpl();
	
	private MovieManagerImpl() {
		
	}
	
	public static IMovieManager getInstance() {
		return instance;
	}
	
	@Override
	public void add(Movie movie) {
		if(size < MAX_SIZE) {
			movieList[size++] = movie;
		}else {
			System.out.println("최대 사이즈를 넘었습니다!");
		}
	}

	@Override
	public Movie[] getList() {
		return Arrays.copyOfRange(movieList, 0, size);
	}

	@Override
	public Movie[] searchByTitle(String title) {
		Movie[] result = new Movie[MAX_SIZE];
		int index = 0;
		for(int i = 0; i < size; i++) {
			if(movieList[i].getTitle().equals(title)) {
				result[index++] = movieList[i];
			}
		}
		return result;
	}

	@Override
	public Movie[] getMovies() {
		int index = 0;
		
		for(int i = 0; i < size; i++) {
			if(movieList[i] instanceof Movie) {
				index++;
			}
		}
		
		Movie[] result = new Movie[index];
		int cnt = 0;
		for(int i = 0; i < size; i++) {
			if(movieList[i] instanceof Movie) {
				result[cnt++] = movieList[i];
			}
		}
		
		return result;
	}

	@Override
	public SeriesMovie[] getSeriesMovies() {
		int index = 0;
		
		for(int i = 0; i < size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				index++;
			}
		}
		
		SeriesMovie[] result = new SeriesMovie[index];
		int cnt = 0;
		for(int i = 0; i < size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				result[cnt++] = (SeriesMovie) movieList[i];
			}
		}
		
		return result;
	}

	@Override
	public double getRunningTimeAvg() {
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += movieList[i].getRunningTime();
		}
		
		int avg = sum / size;
		
		return avg;
	}

}
