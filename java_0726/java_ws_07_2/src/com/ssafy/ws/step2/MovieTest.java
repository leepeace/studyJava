package com.ssafy.ws.step2;

public class MovieTest {

	public static void main(String[] args) {
		
		IMovieManager manager = MovieManagerImpl.getInstance();
		
		manager.add(new Movie(1001, "신과함께", "박근우", "액션", 120));
		manager.add(new Movie(1002, "놈놈놈", "박근우", "액션", 150));
		manager.add(new Movie(1003, "범죄도시", "박근우", "액션", 20));
		manager.add(new SeriesMovie(1004, "해리포터", "피터", "판타지", 125, 1, "불의잔"));
		manager.add(new SeriesMovie(1004, "해리포터", "피터", "판타지", 135, 2, "죽음의 성물"));
		
		for(SeriesMovie movie : manager.getSeriesMovies()) {
			System.out.println(movie);
		}
		
	}

}
