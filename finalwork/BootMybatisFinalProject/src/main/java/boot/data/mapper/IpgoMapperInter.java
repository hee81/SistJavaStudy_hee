package boot.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.IpgoDto;

@Mapper
//IpgoSql문(Id)과 IpgoMapper(메서드)는 같아야함
public interface IpgoMapperInter {

	public int getTotalCount();
	public void insertIpgo(IpgoDto dto);
	public List<IpgoDto> getAllSangpums();
}
