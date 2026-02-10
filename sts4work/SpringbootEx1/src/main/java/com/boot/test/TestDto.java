package com.boot.test;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
@Data //위 3개 합친것
public class TestDto {
	private String name;
	private String addr;
}
