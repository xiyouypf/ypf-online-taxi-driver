package com.ypf.driver.api.model.param;

import lombok.Data;

/**
 * @author ypf
 * @date 2023/05/05 01:28
 */
@Data
public class BaseVerificationCodeParam {
    /**
     * 电话号码
     */
    private String phone;

    /**
     * 用户类型
     */
    private Integer identityType;
}
