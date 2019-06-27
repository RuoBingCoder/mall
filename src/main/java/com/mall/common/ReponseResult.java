package com.mall.common;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * @author : 石建雷
 * @date :2019/6/26
 */
@Setter
@Getter
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ReponseResult<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    public ReponseResult(int status) {
        this.status = status;
    }

    public ReponseResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ReponseResult(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ReponseResult(int status, T data) {
        this.status = status;
        this.data = data;
    }

    //    使之不在json序列化之中
    @JsonIgnore
    public boolean isSucceess() {
        return status == ResponseEnum.SUCCESS.getCode();
    }

    public static <T> ReponseResult<T> createBySuccess() {
        return new ReponseResult<T>(ResponseEnum.SUCCESS.getCode());

    }

    public static <T> ReponseResult<T> createBySuccessMessage(String msg) {
        return new ReponseResult<T>(ResponseEnum.SUCCESS.getCode(), msg);

    }

    public static <T> ReponseResult<T> createBySuccess(T data) {
        return new ReponseResult<T>(ResponseEnum.SUCCESS.getCode(), data);

    }

    public static <T> ReponseResult<T> createBySuccess(String msg, T data) {
        return new ReponseResult<T>(ResponseEnum.SUCCESS.getCode(), msg, data);

    }

    public static <T> ReponseResult<T> createByError() {
        return new ReponseResult<T>(ResponseEnum.ERROR.getCode());
    }

    public static <T> ReponseResult<T> createByErrorMeaage(String errorMsg) {
        return new ReponseResult<T>(ResponseEnum.ERROR.getCode(), errorMsg);
    }

    public static <T> ReponseResult<T> createByError(int errorCode, String errorMsg) {
        return new ReponseResult<T>(errorCode, errorMsg);
    }
}
