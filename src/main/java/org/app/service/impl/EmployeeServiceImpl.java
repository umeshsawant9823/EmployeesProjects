package org.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.app.dto.EmployeeDTO;
import org.app.entity.Employee;
import org.app.exception.ResourceNotFoundException;
import org.app.repository.EmployeeRepository;
import org.app.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    // Helper 1: Entity to DTO
    private EmployeeDTO toDTO(Employee emp) {
        EmployeeDTO dto = new EmployeeDTO();

        BeanUtils.copyProperties(emp, dto);
        return dto;
    }

    // Helper 2: DTO to Entity
    private Employee toEntity(EmployeeDTO dto) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(dto, emp);
        return emp;
    }

    // 1. POST: Create
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        Employee employee = toEntity(dto);
        Employee saved = repository.save(employee);
        return toDTO(saved);
    }

    // 2. GET: Get All
    @Override
    public List<EmployeeDTO> getAllEmployees() {

        List<Employee> employees = repository.findAll();


        List<EmployeeDTO> dtoList = new ArrayList<>();


        for (Employee emp : employees) {
            dtoList.add(toDTO(emp));
        }

        // 4. List return kar di
        return dtoList;
    }


    // 3. GET: Get By ID
    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee emp = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return toDTO(emp);
    }

    // 4. PUT: Full Update
    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        Employee emp = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        emp.setDepartment(dto.getDepartment());
        emp.setEmail(dto.getEmail());

        Employee updated = repository.save(emp);

        return toDTO(updated);
    }


    // 5. PATCH: Partial Update (Only specific fields)
    @Override
    public EmployeeDTO patchEmployee(Long id, EmployeeDTO dto) {
        Employee emp = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        if (dto.getName() != null) {
            emp.setName(dto.getName());
        }
        if (dto.getSalary() != null) {
            emp.setSalary(dto.getSalary());
        }
        if (dto.getDepartment() != null) {
            emp.setDepartment(dto.getDepartment());
        }
        if (dto.getEmail() != null) {
            emp.setEmail(dto.getEmail());
        }

        Employee patched = repository.save(emp);
        return toDTO(patched);
    }


    // 6. DELETE: Delete by IDs
    @Override
    public void deleteEmployee(Long id) {
        Employee emp = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        repository.delete(emp);
    }
}
