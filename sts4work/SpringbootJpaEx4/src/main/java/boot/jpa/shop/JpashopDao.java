package boot.jpa.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpashopDao {
	@Autowired
	JpashopDaoInter shopInter;
	
	//insert
	public void insertShop(ShopDto dto) {
		shopInter.save(dto);
	}
	
	//전체 list
	public List<ShopDto> getAllDatas(){
		return shopInter.findAll();
	}
	
	//하나의 dto
	public ShopDto getOneData(Integer num) {
		return shopInter.getReferenceById(num);
	}
	
	//update
	public void updateShop(ShopDto dto) {
		shopInter.save(dto);
	}
	
	//delete
	public void deleteShop(Integer num) {
		shopInter.deleteById(num);
	}
}
