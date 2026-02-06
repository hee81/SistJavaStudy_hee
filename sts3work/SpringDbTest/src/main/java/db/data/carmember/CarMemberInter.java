package db.data.carmember;

import java.util.List;

public interface CarMemberInter {
	public int getTotalCount();
	public void insertCarMember(MemberDto dto);
	public List<MemberDto> getAllDatas();
	public MemberDto getOneData(String num);
	public void deleteCarMember(String num);
	public void updateCarMember(MemberDto dto);
}
