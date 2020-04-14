package cn.chenzw.springboot.infrastructure.domain.dto;

import java.io.Serializable;

/**
 * @param <T>
 * @author chenzw
 */
public interface Result<T> extends Serializable {

    Integer getCode();


    String getMessage();

    T getData();

}
