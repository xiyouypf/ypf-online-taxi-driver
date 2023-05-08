package com.ypf.driver.api.exception;

import lombok.Data;

/**
 * @author ypf
 * @date 2023/05/05 00:22
 */
@Data
public class DriverException extends RuntimeException {
    private Integer errorCode;
    private String errorMsg;

    public DriverException() {}

    public DriverException(int errorCode, String errorMsg) {
        super("{\"errorCode\":" + errorCode + ",\"errorMsg\":\"" + errorMsg + "\"}");
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
