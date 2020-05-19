package com.option.user.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: LJJ
 * @Program: option-parent
 * @Description:
 * @Create: 2020-03-17 16:09:09
 * @Modified By:
 */
@Data
@ToString
public class CommonResult<T> {
    private T data;
    private String message;
    private Integer code;

    public CommonResult() {
    }

    public CommonResult(T data, String message, Integer code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public CommonResult(String message, Integer code) {
        this(null, message, code);
    }

    public CommonResult(T data) {
        this(data, "操作成功", 200);
    }
}
