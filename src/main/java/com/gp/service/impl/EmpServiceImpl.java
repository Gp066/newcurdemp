package com.gp.service.impl;

import com.gp.dao.EmpDao;
import com.gp.pojo.Emp;
import com.gp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public void addEmp(Emp emp) {
        empDao.save(emp);
    }

    @Override
    public void deleteEmpById(Integer id) {
        empDao.deleteById(id);
    }

    @Override
    public List<Emp> findAll() {
        return empDao.findAll();
    }

    @Override
    public void updateById(Integer id, Emp emp) {
        emp.setId(id);
        empDao.save(emp);
    }

    @Override
    public List<Emp> findAllLikeName(Emp emp) {
        //方式一：
//        String name = emp.getName();
//        return empDao.findByNameContaining(name);

        //方式二
        Specification specification = creatSpecification(emp);
        return empDao.findAll(specification);
    }

    @Override
    public Emp findById(Integer id) {
        return empDao.findById(id).get();
    }

    private Specification creatSpecification(Emp emp) {
        return new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (emp.getName()!=null&&emp.getName()!=""){
                    predicates.add(criteriaBuilder.like(root.get("name").as(String.class),"%"+emp.getName()+"%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
