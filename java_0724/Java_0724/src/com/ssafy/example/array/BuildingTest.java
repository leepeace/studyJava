package com.ssafy.example.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuildingTest {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		//상,하, 좌, 우
		//위쪽 왼쪽 대각선, 위쪽 오른쪽 대각선, 아래쪽 왼쪽 대각선, 아래쪽 오른쪽 대각선의 이동할 (행,열) 좌표
		int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

		int T = sc.nextInt();
		
		for(int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			char[][] ground = new char[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					ground[i][j] = sc.next().charAt(0);
				}
			}
			
			int maxHeight = 0;//가장 높은 빌딩 높이
	
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					boolean isPark = false;
					int temp = 0;
					
					if(ground[row][col] != 'G') {//현위치가 공원단지가 아닌경우
						for(int dir8 = 0; dir8 < 8; dir8++) {
							int moveRow = row + direction[dir8][0];//이동할 행 위치
							int moveCol = col + direction[dir8][1];//이동할 열 위치
							
							if(moveCol >= 0 && moveCol < N && moveRow >= 0 && moveRow < N) {
								//공원단지가 인접한지 확인함
								if(ground[moveRow][moveCol] == 'G') {
									isPark = true;
								}
							}
						}
						if(!isPark){
							for(int k = 0; k < N; k++) {
								if(ground[k][col]=='B') {
									temp++;
								}
								if(ground[row][k] == 'B') {
									temp++;
								}
							}
							temp--;//가로, 세로의 중복되는 부분 제거
						}else {
							temp = 2;
						}
						
					}//end if
					maxHeight = Math.max(maxHeight, temp);
				}
			}
			System.out.println("#" + testcase + " " + maxHeight);
		}//end for
		
		sc.close();
	}

}
