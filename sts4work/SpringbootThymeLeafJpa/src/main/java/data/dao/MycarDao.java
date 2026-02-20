package data.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import data.dto.MycarDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MycarDao {

	MycarDaoInter daointer;
	
	//db저장
	public void insertMycar(MycarDto dto) {
		daointer.save(dto); //save는 dto에 num값이 포함 유무에 따라 insert,update
	}
	
	//전체출력
	public List<MycarDto> getAllCars(){
		//return daointer.findAll(); //전체 데이터 반환
		return daointer.findAll(Sort.by(Sort.Direction.DESC,"carprice")); //가격 비싼순으로 출력
		//return daointer.findAll(Sort.by(Sort.Direction.ASC,"carprice")); //가격 저렴한순으로 출력
	}
	
	//num에 해당하는 dto반환
	public MycarDto getData(Long num) {
		return daointer.getReferenceById(num);
	}
	
	//delete
	public void deleteMycar(Long num) {
		daointer.deleteById(num);
	}
	
	//update
	public void updateMycar(MycarDto dto) {
		daointer.save(dto); //num이 포함되면 update
	}
	
}
