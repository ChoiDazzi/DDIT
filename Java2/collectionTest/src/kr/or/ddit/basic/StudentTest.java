package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/*
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점 , 등수를 멤버로 갖는 Student클래스를 만든다. 
 * 		   이 Student 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다. 
 * 		   이 Student 객체는 List에 저장하여 관리한다. 
 * 
 * 		   List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
 * 		   총점의 역순(내림차순)으로 정렬하는데  총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬 기준 클래스를 작성하여 
 * 		   정렬된 결과를 출력하시오. 
 * 		   
 * 		   등수는 List에 전체 데이터가 추가된 후에 구해서 저장되도록 한다. (StudentTest클래스에 처리)
 * */
public class StudentTest {
	
	//등수를 구하는 메서드 
	public void createRank(ArrayList<Student> rankStuList){
		for (Student stu1 : rankStuList) { //기준 데이터를 구하기 위한 반복문 
			int rank = 1; //처음에 등수를 1로 설정해놓고 시작 
			
			for (Student stu2 : rankStuList) { //비교 대상을 나타내는 반복문 
				if (stu1.getTotalScore() < stu2.getTotalScore()) { // 기준값보다 비교 대상이 크면 rank 값을 증가시킨다. 
					rank++;
				}
			}
			//구해진 등수를 기준 데이터의 rank변수에 저장한다.
			stu1.setRank(rank);
		}
	}
	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<>();
		studentList.add(new Student(1,"최서연",100,100,100));
		studentList.add(new Student(3,"이서연",90,85,90));
		studentList.add(new Student(7,"윤서연",100,100,90));
		studentList.add(new Student(5,"박서연",100,95,70));
		studentList.add(new Student(2,"조서연",80,95,70));
		studentList.add(new Student(4,"정서연",75,95,70));
		studentList.add(new Student(7,"우서연",90,95,70));
		
		//공부!!!!!!!!!!!!!!!!!!!!!!!!!
		StudentTest test = new StudentTest();
		test.createRank(studentList);
		
		System.out.println("==정렬 전==");
		for (Student student : studentList) {
			System.out.println(student);
		}
		System.out.println();
		
		System.out.println("==학번 기준==");
		Collections.sort(studentList);
		for (Student student : studentList) {
			System.out.println(student);
		}
		System.out.println();
		
		System.out.println("==총점의 역순==");
		Collections.sort(studentList,new totalDesc());
		
		for (int i = 0; i < studentList.size(); i++) {
			
			System.out.println(studentList.get(i));
		}
	}
}

class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int koScore;
	private int EnScore;
	private int MathScore;
	private int totalScore;
	private int rank;
	//생성자
	public Student(int num, String name, int koScore, int enScore, int mathScore) {
		this.num = num;
		this.name = name;
		this.koScore = koScore;
		this.EnScore = enScore;
		this.MathScore = mathScore;
		this.totalScore = koScore + enScore + mathScore;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKoScore() {
		return koScore;
	}
	public void setKoScore(int koScore) {
		this.koScore = koScore;
	}
	public int getEnScore() {
		return EnScore;
	}
	public void setEnScore(int enScore) {
		EnScore = enScore;
	}
	public int getMathScore() {
		return MathScore;
	}
	public void setMathScore(int mathScore) {
		MathScore = mathScore;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore= totalScore;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	//내부 정렬 기준 (학번의 오름차순) 
	//내부 정렬 기준은 현재 객체 (this)와 매개변수에 저장되는 객체와 비교해서 처리 
	//현재 객체(this) 가 앞쪽 데이터, 매개변수에 저장된 객체가 뒤쪽 데이터라고 하고 코딩한다. 
	@Override
	public int compareTo(Student student) {
		return Integer.compare(this.getNum(), student.getNum());
	}
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", koScore=" + koScore + ", EnScore=" + EnScore
				+ ", MathScore=" + MathScore + ", totalScore=" + totalScore + ", rank=" + rank + "]";
	}
	
	
}
//외부 정렬 기준 (총점 내림차순) 
class totalDesc implements Comparator<Student>{
	@Override
	public int compare(Student student1, Student student2) {
		if (student1.getTotalScore() == student2.getTotalScore()) {
			return student1.getName().compareTo(student2.getName());
		} else {
			return Integer.compare(student1.getTotalScore(), student2.getTotalScore()) * (-1);
		}
	}
	
}