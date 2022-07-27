import java.util.Arrays;

public class Test3 {

	public static void main(String[] args) {
		int total = 10000;//투입금액
		int giveMoney = 2530;//상품금액
		int receiveMoney = total - giveMoney;//거스름돈 7470원
		
		int[] won = {1000, 500, 100, 50, 10};
		int[] minWon = {0, 0, 0, 0, 0};
		int temp = receiveMoney;
		
		//거스름돈 최소를 구하기 위해서는 돈 단위가 큰 순서대로 많이 가져가야함
		for(int i = 0; i < 5; i++) {
			for(int j = i; j < 5; j++) {
				minWon[j] = Math.max(minWon[j], temp / won[j]);
				temp = temp % won[j];
			}
		}
		
		for(int i = 0; i < won.length; i++) {
			if(won[i] == 1000) {
				//1000원인 경우 단위가 장으로 끝남
				System.out.println(won[i] + "원 : " + minWon[i] + "장");	
			}else {
				System.out.println(won[i] + "원 : " + minWon[i] + "개");	
			}
		}
		
	}

}
