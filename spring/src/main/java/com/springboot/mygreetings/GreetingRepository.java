package com.springboot.mygreetings;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<GreetingDetails, Long> {

}
