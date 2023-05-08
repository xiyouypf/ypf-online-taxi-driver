package com.ypf.driver.web.rservice.impl;

import com.ypf.common.enums.ExceptionCodeEnum;
import com.ypf.common.enums.UserTypeEnum;
import com.ypf.common.response.ServiceResponse;
import com.ypf.driver.api.exception.DriverException;
import com.ypf.driver.web.convert.VerificationCodeConvert;
import com.ypf.driver.api.model.param.BaseVerificationCodeParam;
import com.ypf.driver.api.model.param.VerificationCodeCheckParam;
import com.ypf.driver.api.model.param.VerificationCodeGenerateParam;
import com.ypf.driver.api.rservice.VerificationCodeRService;
import com.ypf.permission.api.VerificationCodeRpcService;
import com.ypf.permission.model.param.VerificationCodeCheckDTO;
import com.ypf.permission.model.param.VerificationCodeGenerateDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author ypf
 * @date 2023/05/05 00:02
 */
@RestController
@Slf4j
public class VerificationCodeRServiceImpl implements VerificationCodeRService {
    @Reference
    private VerificationCodeRpcService verificationCodeRpcService;

    @PostMapping("/driver/verificationCode/get")
    @Override
    public ServiceResponse<Boolean> verificationCodeGet(VerificationCodeGenerateParam generateParam) {
        try {
            checkParam(generateParam);
            VerificationCodeGenerateDTO verificationCodeGenerateDTO = VerificationCodeConvert.convertParam2DTO(generateParam);
            return verificationCodeRpcService.generateVerificationCode(verificationCodeGenerateDTO);
        } catch (DriverException e) {
            log.info("获取验证码程序异常generateParam = {}", generateParam);
            return ServiceResponse.buildErrorResponse(e.getErrorCode(), e.getErrorMsg());
        } catch (Exception e) {
            log.info("获取验证码系统异常", e);
            return ServiceResponse.buildErrorResponse(ExceptionCodeEnum.ERROR.getCode(), ExceptionCodeEnum.VERIFICATION_CODE_ERROR.getMsg());
        }
    }

    @PostMapping("/driver/verificationCode/check")
    @Override
    public ServiceResponse<Boolean> checkVerificationCode(VerificationCodeCheckParam param) {
        try {
            checkParam(param);
            VerificationCodeCheckDTO verificationCodeCheckDTO = VerificationCodeConvert.convertParam2DTO(param);
            return verificationCodeRpcService.checkVerificationCode(verificationCodeCheckDTO);
        } catch (DriverException e) {
            log.info("校验验证码程序异常generateParam = {}", param);
            return ServiceResponse.buildErrorResponse(e.getErrorCode(), e.getErrorMsg());
        } catch (Exception e) {
            log.info("校验验证码系统异常", e);
            return ServiceResponse.buildErrorResponse(ExceptionCodeEnum.ERROR.getCode(), ExceptionCodeEnum.VERIFICATION_CODE_ERROR.getMsg());
        }
    }

    private void checkParam(BaseVerificationCodeParam param) {
        if (!Objects.equals(param.getIdentityType(), UserTypeEnum.DRIVER_IDENTITY.getIdentityType())) {
            throw new DriverException(ExceptionCodeEnum.VERIFICATION_CODE_ERROR.getCode(), "参数错误");
        }
    }
}
