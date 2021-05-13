package com.abhishek.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abhishek.dto.DeptEmpDto;
import com.abhishek.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	@Query("SELECT NEW com.abhishek.dto.DeptEmpDto(d.id, e.name, e.email, e.address) "
			+ "FROM Department d LEFT JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataLeftJoin();
	@Query("SELECT NEW com.abhishek.dto.DeptEmpDto(d.id, e.name, e.email, e.address) "
			+ "FROM Department d RIGHT JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataRightJoin();
}