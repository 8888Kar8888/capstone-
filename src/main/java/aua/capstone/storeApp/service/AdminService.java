package aua.capstone.storeApp.service;

import aua.capstone.storeApp.model.entity.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {



    public Admin createAdmin(Admin admin) {
    }

    public Admin updateAdmin(Integer adminId, Admin updatedAdmin) {

    }

    public void deleteAdmin(Integer adminId) {
    }

    @Transactional
    public void blockUser(Integer customerId) {

    }

    @Transactional
    public void unblockUser(Integer customerId) {

    }

}
