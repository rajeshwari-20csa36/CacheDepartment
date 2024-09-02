package com.ust.controller;



import java.util.List;

import com.ust.model.Department;
import com.ust.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/dept/findAll")
    public List<Department> findAll() {
        return service.getAll();
    }

    @GetMapping("/dept/find/{id}")
    public Department findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping("/dept/clearAllCache")
    public String clearAllCache() {
        service.clearAllCache();
        return "Data cleared from cache";
    }

    @GetMapping("/dept/clearDataFromCache/{id}")
    public String clearDataFromCache(@PathVariable Integer id) {
        service.clearDataFromCache(id);
        return id+" cleared from cache";
    }

}