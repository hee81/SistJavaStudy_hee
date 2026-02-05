package db.data.car;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao implements CarDaoInter {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		return session.selectOne("TotalCountOfCar");
	}

	@Override
	public void insertCar(CarDto dto) {
		session.insert("insertOfCar", dto);
	}

	@Override
	public List<CarDto> getAllDatas() {
		return session.selectList("GetAllDatasOfCar");
	}

	@Override
	public void deleteCar(int num) {
		session.delete("deleteOfCar", num);
	}
}
