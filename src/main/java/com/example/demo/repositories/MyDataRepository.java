package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.MyData;

import java.util.List;

@Repository
public interface MyDataRepository  extends JpaRepository<MyData, Long> {
	
	public MyData findById(Long name);
	public List<MyData> findByNameLike(String name);
	public List<MyData> findByIdIsNotNullOrderByIdDesc();
	public List<MyData> findByAgeGreaterThan(Integer age);
	public List<MyData> findByAgeBetween(Integer age1, Integer age2);

}
