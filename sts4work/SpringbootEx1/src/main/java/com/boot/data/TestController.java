package com.boot.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.test.ShopDto;
import com.boot.test.TestDto;

@Controller
public class TestController {
	
	@GetMapping("/test")
	@ResponseBody
	public TestDto Hello() {
		TestDto dto=new TestDto();
		
		dto.setName("홍길동");
		dto.setAddr("서울시");
		
		return dto;
	}
	
	@GetMapping("/shop/list")
	@ResponseBody
	public List<ShopDto> list(){
		List<ShopDto> slist=new ArrayList<>();
		
		ShopDto s1=new ShopDto();
		s1.setSangpum("연필");
		s1.setSu(31);
		s1.setDan(1300);
		slist.add(s1);
		
		ShopDto s2=new ShopDto();
		s2.setSangpum("샤프");
		s2.setSu(40);
		s2.setDan(1500);
		slist.add(s2);
		
		return slist;
	}
}
