package com.train.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MemberRegisterReq {
    @Pattern(regexp = "^1\\d{10}$",message = "手机号码错误")
    @NotBlank(message = "手机号不能为空")
    private String mobile;
}
