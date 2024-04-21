package aua.capstone.storeApp.repository;

import aua.capstone.storeApp.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    // Method to find an admin by their username
    Admin findByUsername(String username);


}