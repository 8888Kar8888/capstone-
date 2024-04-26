package aua.capstone.storeApp.service;

import aua.capstone.storeApp.model.entity.Admin;
import aua.capstone.storeApp.model.entity.Customer;
import aua.capstone.storeApp.repository.CustomerRepository;
import aua.capstone.storeApp.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminService.class);
    private final CustomerRepository customerRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(CustomerRepository customerRepository, AdminRepository adminRepository)
    {
        this.customerRepository = customerRepository;
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(Admin admin)
    {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Integer adminId, Admin updatedAdmin)
    {
        return adminRepository.findById(adminId).map(admin ->
        {
            admin.setUsername(updatedAdmin.getUsername());
            admin.setEmail(updatedAdmin.getEmail());
            admin.setRoles(updatedAdmin.getRoles());

            return adminRepository.save(admin);
        }).orElseThrow(() -> new EntityNotFoundException("Admin not found with id: " + adminId));
    }

    public void deleteAdmin(Integer adminId)
    {
        adminRepository.deleteById(adminId);
    }

    @Transactional
    public void blockUser(Integer customerId)
    {
        if (customerId == null || customerId <= 0)
        {
            throw new IllegalArgumentException("Invalid customer ID");
        }
        log.info("Attempting to block customer with ID: {}", customerId);
        Customer customer = customerRepository.findById((customerId))
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));
        customer.setBlocked(true);
        customerRepository.save(customer);
        log.info("Customer with ID: {} has been blocked", customerId);
    }

    @Transactional
    public void unblockUser(Integer customerId)
    {
        log.info("Attempting to unblock customer with ID: {}", customerId);
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));
        customer.setBlocked(false);
        customerRepository.save(customer);
        log.info("Customer with ID: {} has been unblocked", customerId);
    }

}
