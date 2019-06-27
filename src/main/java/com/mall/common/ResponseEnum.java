package com.mall.common;

import lombok.Getter;

/**
 * @author : 石建雷
 * @date :2019/6/26
 */
@Getter
public enum ResponseEnum {
    SUCCESS(0, "成功！"),
    ERROR(1, "失败"),
    ILLEGAL_USERS(10, "非法用户！"),
    ;
    private int code;
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
