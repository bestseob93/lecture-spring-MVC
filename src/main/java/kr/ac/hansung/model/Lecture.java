package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Lecture {

	private int id;
	private String years;
	private String semester;
	private String class_code;
	private String class_name;
	private String division;
	private String grades;
}

