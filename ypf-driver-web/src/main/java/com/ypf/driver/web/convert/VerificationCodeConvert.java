package com.ypf.driver.web.convert;

import com.ypf.driver.api.model.param.VerificationCodeCheckParam;
import com.ypf.driver.api.model.param.VerificationCodeGenerateParam;
import com.ypf.permission.model.param.VerificationCodeCheckDTO;
import com.ypf.permission.model.param.VerificationCodeGenerateDTO;

/**
 * @author 作者
 * @date 2023/05/07 00:07
 */
public class VerificationCodeConvert {
    public static VerificationCodeGenerateDTO convertParam2DTO(VerificationCodeGenerateParam param) {
        VerificationCodeGenerateDTO generateDTO = new VerificationCodeGenerateDTO();
        generateDTO.setPhone(param.getPhone());
        generateDTO.setIdentityType(param.getIdentityType());
        return generateDTO;
    }

    public static VerificationCodeCheckDTO convertParam2DTO(VerificationCodeCheckParam param) {
        VerificationCodeCheckDTO checkDTO = new VerificationCodeCheckDTO();
        checkDTO.setPhone(param.getPhone());
        checkDTO.setIdentityType(param.getIdentityType());
        checkDTO.setVerificationCode(param.getVerificationCode());
        return checkDTO;
    }
}
