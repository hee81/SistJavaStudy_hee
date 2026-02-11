package boot.mycar.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyCarDao {

	@Autowired
	MyCarDaoInter carInter;
	
	//insert
	public void InsertMycar(MyCarDto dto) {
		carInter.save(dto); //id타입의 유무에 따라서 자동으로 insert,update인지 처리해준다.
	}
	
	//전체출력
	public List<MyCarDto> getAllDatas(){
		return carInter.findAll();
	}
	
	//수정-num에 대한 하나의 dto
	public MyCarDto getOneData(Long num) {
		return carInter.getById(num);
	}
	
	//수정
	public void updateMycar(MyCarDto dto) {
		carInter.save(dto); //update에서는 num이 포함하고 있음(hidden)
	}
	
	//삭제
	public void deleteMyCar(Long num) {
		carInter.deleteById(num);
	}
	
}
