package com.gp.service;

import com.gp.pojo.Emp;

import java.util.List;

public interface EmpService {
    void addEmp(Emp emp);

    void deleteEmpById(Integer id);

    List<Emp> findAll();

    void updateById(Integer id, Emp emp);

    List<Emp> findAllLikeName(Emp emp);

    Emp findById(Integer id);
}
