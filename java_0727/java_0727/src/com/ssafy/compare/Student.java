package com.ssafy.compare;

public class Student implements Comparable<Student>{
	int no, score;
	
	public Student(int no, int score) {
		this.no = no;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {
		//음수가 나오면 뒤에 o.no가 더 큼
		//0인 경우 동일 위치
		//return -(this.no - o.no);
		return this.no - o.no;
	}

	
	
	
}
