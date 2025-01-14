package com.ust.service;

import com.ust.model.Department;
import com.ust.repo.DepartmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo repository;

    public List<Department> getAll() {
        return repository.findAll();
    }

    //from database
	/*public Department findById(Integer deptId) {
		return repository.findById(deptId).get();
	}*/

	/*@Cacheable(value="deptCache", key="#deptId")
	public Department findById(Integer deptId) {
		return repository.findById(deptId).get();
	}*/

    @Cacheable(value="applicationCache", key="#deptId")
    public Department findById(Integer deptId) {
        return repository.findById(deptId).get();
    }

    @CacheEvict(value="applicationCache", allEntries=true)
    public void clearAllCache() {
        System.out.println("**** All cache evicted ***");
    }

    @CacheEvict(value="applicationCache", key="#deptId")
    public void clearDataFromCache(Integer deptId) {
        System.out.println("**** Data evicted from Cache : "+deptId);
    }

}
