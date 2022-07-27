package com.ssafy.generic;

import java.util.Arrays;

// T : type, V, K : value, key, E: element (의미 및 가독성을 위한 약속/강제성 없음) 
/**
 * @author multicampus
 *
 * @param <T>
 */
public class Course<T> {

	//모든 종류의 자바 객체를 저장해야 한다면?
/*	private Object object;
	
	private Object get() { return object; }
	
	public void set(Object object) {
		this.object = object;
	}*/
	
	//Object 대신 타입 T로 대체되고, 객체를 생성할 때 구체적 타입 지정 가능
	private T t;
	
	public T get() {
		return t;
	}
	
	public void set(T t) {
		this.t = t;
	}
	
	/*
	 * Generic메서드
	 * : 매개 타입, 리턴 타입을 타입 파라미터로 갖는 메서드
	 * 선언의 형태 => 리턴 타입 앞에 <>기호를 추가하고 타입 파라미터 기술 후 리턴 타입과 매개 타입을 타입 파라미터로 사용
	 * [형태]
	 * 기존 : public 리턴타입 메서드명(매개변수, ...){ 구현 }
	 * 제너릭 : public <타입파라미터, ...> 리턴타입 메서드명(매개변수, ...){ 구현 }
	 * */
	public static <T> Course courseX(T t) {//course객체 생성하여 return
		Course<T> cour1 = new Course<T>();
		cour1.set(t);
		return cour1;
	}
	
	private String name;//과정명
	private T[] students;//과정 수강 학생 저장을 위한 배열->객체 생성 시 타입 지정 됨
	
	public Course() { }
	
	public Course(String name, int n) {//과정명, 정원
		this.name = name;
		//new T[n]은 안됨
		this.students = (T[])(new Object[n]);//Object->T로 형변환, 타입 파라미터로 배열를 생성
	}
	
	public String getName() {
		return name;
	}
	
	public T[] getStudents() {
		return students;
	}
	
	public void add(T t) {//학생 추가 메서드
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}
	
	// ? 와일드카드 타입
	// 제한없이 모든 타입의 클래스나 인터페이스 타입이 올 수 있음
	public static void generalCourse(Course<?> course) {
		System.out.println(course.getName() + "수강생 : " + Arrays.toString(course.getStudents()));
	}
	
	//? extends 상위 타입 -> 상위 클래스 제한 : 지정 타입 포함 하위만 올 수 있음
	public static void studentCourse(Course<? extends Graduate> course) {
		System.out.println(course.getName() + "수강생 : " + Arrays.toString(course.getStudents()));
	}
	
	//? super 하위타입 -> 하위클래스 제한 : 지정타입(하위타입) 포함 상위만 올 수 있음
	public static void graduateCourse(Course<? super Graduate> course) {
		System.out.println(course.getName() + "수강생 : " + Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		Course<Person> personCourse = new Course<>("일반인 과정", 5);
		//타입 파라미터 Person으로 지정되어 있음
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("재학생"));
		personCourse.add(new Graduate("졸업생"));
		
		Course<Worker> workerCourse = new Course<Worker>("직장인 과정", 5);
		//workerCourse.add(new Person("일반인"));
		workerCourse.add(new Worker("직장인"));
		//workerCourse.add(new Student("재학생"));
		//workerCourse.add(new Graduate("졸업생"));
		
		Course<Graduate> graduateCourse = new Course<Graduate>("졸업생 과정", 5);
		//graduateCourse.add(new Person("일반인"));
		//graduateCourse.add(new Worker("직장인"));
		graduateCourse.add(new Student("재학생"));
		graduateCourse.add(new Graduate("졸업생"));
		
		Course<Student> studentCourse = new Course<Student>("재학생 과정", 5);
		//graduateCourse.add(new Person("일반인"));
		//graduateCourse.add(new Worker("직장인"));
		studentCourse.add(new Student("재학생"));
		//studentCourse.add(new Graduate("졸업생"));
		
		//? 와일드카드 타입--> 모든 과정 올 수 있음
		generalCourse(personCourse);
		generalCourse(studentCourse);
		generalCourse(workerCourse);
		generalCourse(graduateCourse);
		
		System.out.println();
		
		// ? extends 지정타입 -> 지정타입 포함 하위만 올 수 있음
		//studentCourse(personCourse);//부모 객체 들어갈 수 없음
		//studentCourse(workerCourse);//연관이 없음
		studentCourse(studentCourse);
		studentCourse(graduateCourse);
		
		
		System.out.println();
		
		// ? super 지정타입 -> 지정타입 포함 상위만 올 수 있음
 		graduateCourse(personCourse);
 		graduateCourse(graduateCourse);
		//graduateCourse(studentCourse);//하위객체라 들어갈 수 없음
		//graduateCourse(workerCourse);//연관 X
		
 		
		
	}
	
	
}
