package boot.board.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	BoardDaoInter inter;
	
	//insert
	public void insertBoard(BoardDto dto) {
		inter.save(dto);
	}
	
	//전체list
	public List<BoardDto> getAllDatas(){
		return inter.findAll(Sort.by(Sort.Direction.DESC,"num")); //최신글이 위로 올라오게 정렬
	}
	
	//dto
	public BoardDto getOneData(long num) {
		return inter.getReferenceById(num); 
	}
	
	//update
	public void updateBoard(BoardDto dto) {
		inter.save(dto);
	}
	
	//delete
	public void deleteBoard(long num) {
		inter.deleteById(num);
	}
}
