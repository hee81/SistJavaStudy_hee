package myshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class ShopDao {
	
	DbConnect db=new DbConnect();
	
	//insert
	public void insertShop(ShopDto dto)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="insert into myshop (sangpum,photo,price,ipgoday,writeday) values (?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setString(1, dto.getSangpum());
			pstmt.setString(2, dto.getPhoto());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getIpgoday());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//전체목록
	public List<ShopDto> getAllDatas()
	{
		//List-인터페이스를 구현한 클래스
		List<ShopDto> list=new Vector<ShopDto>();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myshop order by num";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				ShopDto dto=new ShopDto();
				
				//db에서 가져와서 dto에 넣기
				dto.setNum(rs.getString("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setPhoto(rs.getString("photo"));
				dto.setPrice(rs.getInt("price"));
				dto.setIpgoday(rs.getString("ipgoday"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//list에 dto추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
	
	//하나의 데이터...(1.디테일페이지 2.수정폼)
	public ShopDto getOneData(String num)
	{
		ShopDto dto=new ShopDto();
		
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myshop where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				//db에서 가져와서 dto에 넣기
				dto.setNum(rs.getString("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setPhoto(rs.getString("photo"));
				dto.setPrice(rs.getInt("price"));
				dto.setIpgoday(rs.getString("ipgoday"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
	
	//delete
	public void deleteShop(String num)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="delete from myshop where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//update
	public void updateShop(ShopDto dto)
	{
		Connection conn=db.getDbConnect();
		PreparedStatement pstmt=null;
		
		String sql="update myshop set sangpum=?,photo=?,price=?,ipgoday=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setString(1, dto.getSangpum());
			pstmt.setString(2, dto.getPhoto());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getIpgoday());
			pstmt.setString(5, dto.getNum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
}
