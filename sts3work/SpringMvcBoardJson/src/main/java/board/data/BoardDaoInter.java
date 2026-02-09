package board.data;

import java.util.List;

public interface BoardDaoInter {
	public int getTotalCount();
	public void insertBoard(BoardDto dto);
	public List<BoardDto> getPagingList(int start,int perpage);
	public void updateReadCount(int num);
	public BoardDto getOneData(int num);
	public int getCheckPass(int num,int pass);
	public void updateBoard(BoardDto dto);
	public void deleteBoard(int num);
}
