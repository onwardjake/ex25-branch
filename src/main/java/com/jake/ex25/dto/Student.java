package com.jake.ex25.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    
    @NotBlank(message = "이름은 필수 항목입니다.")
    private String name;
    
    @Email(message = "이메일 양식에 맞게 입력해주세요.")
    private String email;
    
    @Min(value = 1, message = "나이는 1 이상으로 입력해주세요.")
    private Integer age;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
