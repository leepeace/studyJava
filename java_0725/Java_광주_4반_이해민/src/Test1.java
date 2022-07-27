import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		char input = scanner.next().charAt(0);
		
		if(input == '1') {
			int num = 1;
			for(int row = 1; row <= 4; row++) {
				for(int col = 0; col < row; col++) {
					System.out.print(num + " ");
					num++;
				}
				System.out.println();
			}
		}else if(input == 'A') {
			char start = 'A';
			char[][] temp = new char[6][10];
			for(int row = 1; row <= 5; row++) {
				int index = 5;
				int count = 1;
				for(int col = 0; col < count; col++) {
					temp[row][index--] = start++;
					count += 2;
				}
			}
			
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 10; j++) {
					System.out.print(temp[i][j]);
				}
				System.out.println();
			}
		
		}
		
	}

}
//1
//3
//5
//7
//9
