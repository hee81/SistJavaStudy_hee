package data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import data.dto.MycarDto;


public interface MycarDaoInter extends JpaRepository<MycarDto, Long>{


}
