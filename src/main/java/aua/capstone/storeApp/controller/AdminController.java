package aua.capstone.storeApp.controller;

import aua.capstone.storeApp.model.responses.ApiResponse;
import aua.capstone.storeApp.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {


    public AdminController(AdminService adminService)
    {
    }

    @PutMapping("/block-user/{customerId}")
    public ResponseEntity<ApiResponse> blockUser(@PathVariable Integer customerId)
    {
    }

    @PutMapping("/unblock-user/{customerId}")
    public ResponseEntity<ApiResponse> unblockUser(@PathVariable Integer customerId)
    {
    }

}
