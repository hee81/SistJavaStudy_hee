package sts.mvc.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonTestController2 {
	
	@GetMapping("/list2")
	public List<FoodDto> list2(){
		List<FoodDto> list=new ArrayList<FoodDto>();
		
		list.add(new FoodDto("»÷µåÀ§Ä¡", "1.jpg"));
		list.add(new FoodDto("²¿Ä¡±¸ÀÌ", "2.jpg"));
		list.add(new FoodDto("¸Á°íºù¼ö", "11.jpg"));
		
		return list;
	}
	
	
}
