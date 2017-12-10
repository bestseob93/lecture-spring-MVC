package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	
	@Size(min=4, max=4, message="years must be 4")
	@NotEmpty(message="years cannot be empty")
	private String years;
	
	@NotEmpty(message="semester cannot be empty")
	private String semester;
	
	@NotEmpty(message="class_code cannot be empty")
	private String class_code;
	@NotEmpty(message="class_name cannot be empty")
	private String class_name;
	@NotEmpty(message="division cannot be empty")
	private String division;
	@NotEmpty(message="grades cannot be empty")
	private String grades;
	private String username;
}

