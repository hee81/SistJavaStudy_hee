package spring.ex4.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //자동으로 bean에 logicController로 저장됨(단, 이름을 주면 그 이름으로 등록된다.)
//@Component("logic")
public class LogicController {
	//MyDao dao;
	@Autowired //자동주입
	DaoInter dao;
		
	//insert
	public void insert(String str) {
		dao.insertData(str);
	}
	
	//delete
	public void delete(String num) {
		dao.deleteData(num);
	}
}
