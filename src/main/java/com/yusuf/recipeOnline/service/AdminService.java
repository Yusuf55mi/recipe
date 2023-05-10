package com.yusuf.recipeOnline.service;

import com.yusuf.recipeOnline.dto.AdminDto;
import com.yusuf.recipeOnline.model.Admin;

public interface AdminService {
    Admin findByUsername(String username);

    Admin save(AdminDto adminDto);
}
