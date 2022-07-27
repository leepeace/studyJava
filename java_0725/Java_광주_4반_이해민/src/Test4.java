import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileInputStream("src/Test4.txt"));
		
		int T = sc.nextInt();//팀수
		
		for(int testcase = 1; testcase <= T; testcase++) {
			int teamCount = sc.nextInt();//팀원수
			
			int[] teamScore = new int[teamCount];
			
			for(int i = 0; i < teamCount; i++) {
				teamScore[i] = sc.nextInt();
			}//입력 끝
			
			int sum = 0;
			for(int i = 0; i < teamCount; i++) {
				sum += teamScore[i];
			}
			
			double avg = sum / teamCount;//팀의 평균
			
			double answer;//팀의 평균을 넘는 학생들의 비율
			
			int count = 0;
			
			for(int j = 0; j < teamCount; j++) {
				if(teamScore[j] > avg) {
					count++;
				}
			}
			
			answer = (count * Math.pow(teamCount, -1)) * 100;
			
			System.out.println("#" + testcase + " " + answer + "%");
		}
		
		sc.close();
	}

}
