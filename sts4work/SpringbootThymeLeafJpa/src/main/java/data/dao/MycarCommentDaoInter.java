package data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import data.dto.MycarCommentDto;

public interface MycarCommentDaoInter extends JpaRepository<MycarCommentDto, Integer>{

	
		//num에 해당하는 댓글목록출력 메서드
	@Query(value = "select * from jpacar_comment where num=:num order by idx desc",nativeQuery = true)
	public List<MycarCommentDto> getMycarCommentList(@Param("num") Long num);
}