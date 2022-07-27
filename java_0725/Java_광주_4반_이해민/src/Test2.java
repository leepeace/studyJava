
public class Test2 {

	public static void main(String[] args) {
		int[] su= { 45, 80, 68, 19, 34, 55, 27, 60, 27, 18 };
		int sum = 0;
		
		for(int i = 0; i < su.length; i++) {
			sum += su[i];
		}
		
		double avg = (double)sum / su.length;
		
		double max = 0;
		
		int index = 0;
		//평균과의 차이가 큰 값을 구함
		for(int i = 0; i < su.length; i++) {
			double temp = Math.abs(avg-su[i]);
			if(max < temp) {
				max = temp;
				index = i;
			}
		}
		
		
		System.out.println(avg + " " + su[index]);
		
	}

}
