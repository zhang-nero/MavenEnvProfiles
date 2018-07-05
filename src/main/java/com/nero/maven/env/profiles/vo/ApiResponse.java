package com.nero.maven.env.profiles.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Nero
 * @since 2018-07-04 19:56
 */
@Setter
@Getter
public class ApiResponse<T> {
    private static final Integer success = 1001;
    private static final Integer fail = 1002;

    private Integer code;
    private String errorMessage;
    private T data;

    private boolean isOk(){
        return success.equals(code);
    }

    public static ApiResponse success(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(success);
        return apiResponse;
    }

    public static <T> ApiResponse success(T data){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(success);
        apiResponse.setData(data);
        return apiResponse;
    }

    public static ApiResponse fail(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(fail);
        return apiResponse;
    }

    public static ApiResponse fail(Integer code){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(code);
        return apiResponse;
    }

    public static ApiResponse fail(Integer code, String errorMessage){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(code);
        apiResponse.setErrorMessage(errorMessage);
        return apiResponse;
    }
}
