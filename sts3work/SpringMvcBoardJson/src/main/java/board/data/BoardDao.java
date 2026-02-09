package board.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements BoardDaoInter {

	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("TotalCountOfBoard");
	}

	@Override
	public void insertBoard(BoardDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfBoard", dto);
	}

	@Override
	public List<BoardDto> getPagingList(int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		return session.selectList("selectPageListOfBoard", map);
	}

	@Override
	public void updateReadCount(int num) {
		// TODO Auto-generated method stub
		session.update("updateReadCountOfBoard", num);
	}

	@Override
	public BoardDto getOneData(int num) {
		// TODO Auto-generated method stub
		return session.selectOne("getOneDataOfBoard", num);
	}

	@Override
	public int getCheckPass(int num, int pass) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map=new HashMap<String, Integer>(); //String¿Ã∏È Object
		map.put("num", num);
		map.put("pass", pass);
		return session.selectOne("checkPassEqualOfBoard", map);
	}

	@Override
	public void updateBoard(BoardDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfBoard", dto);
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		session.delete("deleteOfBoard", num);
		
	}

	

}
