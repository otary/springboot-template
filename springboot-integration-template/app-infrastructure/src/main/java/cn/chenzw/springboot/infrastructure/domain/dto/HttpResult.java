package cn.chenzw.springboot.infrastructure.domain.dto;

import javax.servlet.http.HttpServletResponse;

/**
 * @param <T>
 * @author chenzw
 */
public class HttpResult<T> implements Result<T> {

    private Integer code;

    private String message;

    private T data;

    public HttpResult(){}

    public HttpResult(Integer code) {
        this.code = code;
    }

    public HttpResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> HttpResult<T> ok() {
        return new HttpResult<>(HttpServletResponse.SC_OK);
    }

    public static <T> HttpResult<T> ok(T data) {
        return new HttpResult<>(HttpServletResponse.SC_OK, "", data);
    }

    public static <T> HttpResult<T> ok(String message, T data) {
        return new HttpResult<>(HttpServletResponse.SC_OK, message, data);
    }

    public static <T> HttpResult<T> error(Integer code, String message) {
        return new HttpResult<>(code, message);
    }

    public static <T> HttpResult<T> error(String message) {
        return new HttpResult<>(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message);
    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public T getData() {
        return this.data;
    }
}
