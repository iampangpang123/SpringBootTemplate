package com.springboottemplate.xsd;


import java.util.List;

public class Student {

	private String name;

	private String number;

	private String gender;

	private String age;

	private List<Course> courses;



	public static class Course {

		private String name;

		private String grade;

		private String remark;


                // Getter and Setter Methods ...

	}

        // Getter and Setter Methods ...

}



