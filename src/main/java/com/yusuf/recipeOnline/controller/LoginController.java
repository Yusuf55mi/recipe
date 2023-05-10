package com.yusuf.recipeOnline.controller;

import com.yusuf.recipeOnline.dto.AdminDto;
import com.yusuf.recipeOnline.model.Admin;
import com.yusuf.recipeOnline.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("adminDto", new AdminDto());
        return "register";
    }

    @PostMapping("/register-new")
    public String addNewAdmin(@Valid @ModelAttribute("adminDto") AdminDto adminDto,
                              BindingResult result,
                              Model model,
                              RedirectAttributes redirectAttributes) {
        try {
            if (result.hasErrors()) {
                model.addAttribute("adminDto", adminDto);
                result.toString();
                return "register";
            }
            String username = adminDto.getUsername();
            Admin admin = adminService.findByUsername(username);
            if (admin != null) {
                model.addAttribute("adminDto", adminDto);
                redirectAttributes.addFlashAttribute("message", "Bu mail kullanılmakta");
                System.out.println("Admin nesnesi dolu");
                return "register";
            }
            if (adminDto.getPassword().equals(adminDto.getRepeatPassword())) {
                adminService.save(adminDto);
                System.out.println("Kayıt Başarılı!");
                model.addAttribute("adminDto", adminDto);
                redirectAttributes.addFlashAttribute("message", "Kayıt Başarılı!");
            } else {
                model.addAttribute("adminDto", adminDto);
                redirectAttributes.addFlashAttribute("message", "Şifreler eşleşmiyor");
                System.out.println("Şifreler eşleşmiyor");
                return "register";
            }
            adminService.save(adminDto);
            model.addAttribute("adminDto", adminDto);
            redirectAttributes.addFlashAttribute("message", "Kayıt başarılı!");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Server hatası. Kayıt Başarısız!");
        }
        return "register";

    }


}
