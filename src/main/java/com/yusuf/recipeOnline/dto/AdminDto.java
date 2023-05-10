package com.yusuf.recipeOnline.dto;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    @Size(min = 3, max = 10, message = "İsim minimum 3 maksimum 10 karakter uzunluğunda olmalı!")
    private String name;
    @Size(min = 3, max = 10, message = "Soyadı minimum 3 maksimum 10 karakter uzunluğunda olmalı!")
    private String surname;
    private String username;
    @Size(min = 5, max = 15, message = "Şifre minimum 5 maksimum 15 karakter uzunluğunda olmalı!")
    private String password;
    private String repeatPassword;

}
