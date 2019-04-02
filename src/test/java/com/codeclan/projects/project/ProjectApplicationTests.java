package com.codeclan.projects.project;

import com.codeclan.projects.project.Models.Department;
import com.codeclan.projects.project.Models.Employee;
import com.codeclan.projects.project.Models.Project;
import com.codeclan.projects.project.Repositories.DepartmentRepository;
import com.codeclan.projects.project.Repositories.EmployeeRepository;
import com.codeclan.projects.project.Repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canPrepareDatabase() {

		Department department1 = new Department("Colouring in");
		departmentRepository.save(department1);
		Employee employee1 = new Employee("Ian", "Bone", "H123456", department1);
		employeeRepository.save(employee1);
		Employee employee2 = new Employee("Aunt","Sally","H654321", department1);
		employeeRepository.save(employee2);
		department1.addEmployee(employee1);
		department1.addEmployee(employee2);
		departmentRepository.save(department1);
		Project project1 = new Project("Sharpen Pencils", 10);
		project1.addEmployee(employee1);
		project1.addEmployee(employee2);
		projectRepository.save(project1);


	}
}
