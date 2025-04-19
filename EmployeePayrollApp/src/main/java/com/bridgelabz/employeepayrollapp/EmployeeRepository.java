package com.bridgelabz.employeepayrollapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT username, email FROM employees WHERE username = ?1%")
    List<Employee> findByUsername(String name);

    //JPQL query@Repository
    //    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.email = ?2")
        List<Employee> findByUserNameAndEmail(String username, String email);
    //}
}
