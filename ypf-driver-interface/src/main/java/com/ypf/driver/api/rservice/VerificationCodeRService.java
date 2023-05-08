package com.ypf.driver.api.rservice;

import com.ypf.common.response.ServiceResponse;
import com.ypf.driver.api.model.param.VerificationCodeCheckParam;
import com.ypf.driver.api.model.param.VerificationCodeGenerateParam;

/**
 * @author 作者
 * @date 2023/05/05 10:57
 */
public interface VerificationCodeRService {
    /**
     * 请求获取验证码
     */
    ServiceResponse<Boolean> verificationCodeGet(VerificationCodeGenerateParam generateParam);

    /**
     * 检查验证码是否正确
     */
    ServiceResponse<Boolean> checkVerificationCode(VerificationCodeCheckParam param);
}
