package boot.mycar.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="mycar") //자동으로 mycar테이블이 mysql에 만들어진다
public class MyCarDto {
	
	@Id //식별아이디 각 엔티티를 구별하도록 설계(시퀀스)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long num;
	
	@Column(name = "carname") //이름 같으면 생략가능
	private String carname;
	
	@Column
	private String carcolor;
	
	@Column
	private int carprice;
	
	@Column
	private String guipday;
	
	@CreationTimestamp //entity가 생성되는 시점에 자동등록!
	@Column(updatable = false) //해당 컬럼은 수정하지 않겠다라는 의미
	private Timestamp writeday;
	
}
