package com.abhishek.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DeptEmpDto {
	private int id;
	private String empName;
	private String empEmail;
	private String empAddress;
}