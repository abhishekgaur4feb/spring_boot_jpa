package com.abhishek.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abhishek.dto.DeptEmpDto;
import com.abhishek.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query("SELECT NEW com.abhishek.dto.DeptEmpDto(d.id, e.name, e.email, e.address) "
			+ "FROM Department d INNER JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataInnerJoin();
	@Query("SELECT NEW com.abhishek.dto.DeptEmpDto(d.id, e.name, e.email, e.address) "
			+ "FROM Department d, Employee e")
	List<DeptEmpDto> fetchEmpDeptDataCrossJoin();
}