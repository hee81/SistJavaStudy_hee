package sts.mvc.json;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller(동기+비동기)
//@RestController(비동기만)
@Controller
public class JsonTestController {
	@GetMapping("/list1")
	//@ResponseBody //json처리 후 브라우저에 출력(@Controller일때)
	public @ResponseBody Map<String, String> list(){
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "이수지");
		map.put("hp", "010-4454-7811");
		map.put("addr", "강남구 역삼동");
		return map;
	}
}
