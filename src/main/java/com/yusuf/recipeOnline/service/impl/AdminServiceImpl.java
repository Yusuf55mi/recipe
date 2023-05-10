package com.yusuf.recipeOnline.service.impl;

import com.yusuf.recipeOnline.dto.AdminDto;
import com.yusuf.recipeOnline.model.Admin;
import com.yusuf.recipeOnline.repository.AdminRepository;
import com.yusuf.recipeOnline.repository.RoleRepository;
import com.yusuf.recipeOnline.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin save(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setName(adminDto.getName());
        admin.setSurname(adminDto.getSurname());
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        admin.setRoles(Arrays.asList(roleRepository.findByName("ADMIN")));
        return adminRepository.save(admin);
    }
}
