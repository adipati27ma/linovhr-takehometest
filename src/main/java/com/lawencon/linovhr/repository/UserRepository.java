package com.lawencon.linovhr.repository;

import com.lawencon.linovhr.model.entity.*;
import org.jspecify.annotations.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

@NullMarked
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmployeeCode(String email);
}
