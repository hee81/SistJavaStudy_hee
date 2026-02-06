package db.data.carmember;

import java.util.Date;

public class MemberDto {
	private int num;
	private String name;
	private String hp;
	private String addr;
	private Date gaipday;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getGaipday() {
		return gaipday;
	}
	public void setGaipday(Date gaipday) {
		this.gaipday = gaipday;
	}
}
