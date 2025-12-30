package myboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.db.DbConnect;

public class BoardAnswerDao {
	
	DbConnect db=new DbConnect();
	
	//insert
	public void insertAnswer(BoardAnswerDto dto)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="insert into myboardanswer values(null,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setString(1, dto.getNum());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getComment());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//전체댓글출력
	public List<BoardAnswerDto> getAllAnswers(String num)
	{
		List<BoardAnswerDto> alist=new ArrayList<BoardAnswerDto>();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myboardanswer where num=? order by idx desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				BoardAnswerDto dto=new BoardAnswerDto();
				dto.setIdx(rs.getString("idx"));
				dto.setNum(rs.getString("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setComment(rs.getString("comment"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				alist.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return alist;
	}
	
	//삭제delete
	public void deleteAnswer(String idx)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="delete from myboardanswer where idx=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, idx);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//수정_idx에 대한 하나의 dto리턴
	public BoardAnswerDto getOneAnswer(String idx)
	{
		BoardAnswerDto dto=new BoardAnswerDto();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myboardanswer where idx=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, idx);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setIdx(rs.getString("idx"));
				dto.setNum(rs.getString("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setComment(rs.getString("comment"));
				dto.setWriteday(rs.getTimestamp("writeday"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	//수정
	public void updateAnswer(BoardAnswerDto dto)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="update myboardanswer set nickname=?,comment=? where idx=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getComment());
			pstmt.setString(3, dto.getIdx());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
}

























