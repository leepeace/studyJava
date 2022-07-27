package com.ssafy.ws.step2;

public interface IMovieManager {
	
	//영화를 영화리스트에 추가함
	void add(Movie movie);
	
	//등록된 영화리스트를 반환함
	Movie[] getList();
	
	//도서 제목을 포함하고 있는 영화 리스트를 반환함
	Movie[] searchByTitle(String title);
	
	//등록된 영화중에 일반영화만 반환함
	Movie[] getMovies();
	
	//등록된 영화중에 시리즈 영화만 반환함
	SeriesMovie[] getSeriesMovies();
	
	//영화 상영시간의 평균을 반환함
	double getRunningTimeAvg();
	
}
