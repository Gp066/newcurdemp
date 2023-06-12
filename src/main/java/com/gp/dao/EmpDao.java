package com.gp.dao;

import com.gp.pojo.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EmpDao extends JpaRepository<Emp,Integer>, JpaSpecificationExecutor<Emp> {

    List<Emp> findByNameContaining(String name);
}
