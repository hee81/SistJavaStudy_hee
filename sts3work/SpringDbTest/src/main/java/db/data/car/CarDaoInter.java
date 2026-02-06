package db.data.car;

import java.util.List;

public interface CarDaoInter {
	public int getTotalCount();
	public void insertCar(CarDto dto);
	public List<CarDto> getAllDatas();
	public void deleteCar(String num);
	public CarDto getOneData(String num);
	public void updateCar(CarDto dto);
}
