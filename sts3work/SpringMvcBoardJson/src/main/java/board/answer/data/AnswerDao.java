package board.answer.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.data.BoardDaoInter;
import board.data.BoardDto;

@Repository
public class AnswerDao implements AnswerDaoInter {

	@Autowired
	private SqlSession session;
	
	@Override
	public void insertAnswer(AnswerDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfAnswer", dto);
	}

	@Override
	public List<AnswerDto> getAnswerList(int num) {
		// TODO Auto-generated method stub
		return session.selectList("getAllDatasOfAnswer", num);
	}


}
