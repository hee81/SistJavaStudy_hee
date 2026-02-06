package db.data.carmember;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarMemberDao implements CarMemberInter {

	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("getTotalCountOfCarMem");
	}

	@Override
	public void insertCarMember(MemberDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfCarMem", dto);
	}

	@Override
	public List<MemberDto> getAllDatas() {
		// TODO Auto-generated method stub
		return session.selectList("getAllMembersOfCarMem");
	}

	@Override
	public MemberDto getOneData(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("getOneMemberOfCarMem", num);
	}

	@Override
	public void deleteCarMember(String num) {
		// TODO Auto-generated method stub
		session.delete("deleteOfCarMem", num);
	}

	@Override
	public void updateCarMember(MemberDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfCarMem", dto);
	}

}
