package com.ypf.driver.web.rservice;

import com.ypf.common.response.ServiceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 作者
 * @date 2023/05/04 18:56
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public ServiceResponse<String> test() {
        return ServiceResponse.buildSuccessResponse("测试成功");
    }
}
