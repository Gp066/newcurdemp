package com.gp.controller;

import com.gp.pojo.Emp;
import com.gp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/add")
    public void addEmp(@RequestBody Emp emp){
        empService.addEmp(emp);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmpById(@PathVariable Integer id){
        empService.deleteEmpById(id);
    }

    @GetMapping("/findAll")
    public List<Emp> findAll(){
        return empService.findAll();
    }

    @PutMapping("/update/{id}")
    public void updateById(@PathVariable Integer id,@RequestBody Emp emp){
        System.out.println(emp);
        empService.updateById(id,emp);
    }

    @GetMapping("/findAllName")
    public List<Emp> findAllLikeName(@RequestParam String name){
        Emp emp = new Emp();
        emp.setName(name);
        return empService.findAllLikeName(emp);
    }

    @GetMapping("/findById/{id}")
    public Emp findById(@PathVariable Integer id){
        return empService.findById(id);
    }


    @RequestMapping(value = "/json/point",method = RequestMethod.GET)
    public String point(@RequestBody List[] points, HttpServletResponse response){

        List[] p = new List[4];
        p[0] = new ArrayList();
        p[1] = new ArrayList();
        p[2] = new ArrayList();
        p[3] = new ArrayList();
        p[0].add("119.037089, 32.259867");
        p[1].add("118.821489, 32.077388");
        p[2].add("118.80657099, 32.0353893");
        p[3].add("118.894173, 32.077862");
        if (points!=null)
        {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < points.length; j++) {
                    if (points[j].toString().equals(p[i].toString())) {
                        System.out.println(p[i] + "存在");

                        String result =  "{\"name\":\"John\"}";


                        return "json";
                    }
                }
            }

            return "niaho1";
        }else{
            return "buhao";
        }

    }
}
