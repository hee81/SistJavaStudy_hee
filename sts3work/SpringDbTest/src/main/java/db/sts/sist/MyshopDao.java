package db.sts.sist;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyshopDao {
	
	@Autowired //자동주입
	private SqlSession session;
	
	public List<MyshopDto> getAllSangpums()
	{
		return session.selectList("getAllOfMyshop"); //파라메타 없으면 1개~
	}
	
	
}
