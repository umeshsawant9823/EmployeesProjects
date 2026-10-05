package org.app.service;

import org.app.dto.EmployeeDTO;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    // 1. POST
    EmployeeDTO createEmployee(EmployeeDTO dto);

    // 2. GET All
    List<EmployeeDTO> getAllEmployees();

    // 3. GET by ID
    EmployeeDTO getEmployeeById(Long id);

    // 4. PUT (Full Update)
    EmployeeDTO updateEmployee(Long id, EmployeeDTO dto);

    // 5. PATCH (Partial Update)
    EmployeeDTO patchEmployee(Long id, EmployeeDTO dto);

    // 6. DELETE
    void deleteEmployee(Long id);
}
