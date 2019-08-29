package cn.chenzw.springboot.infrastructure.domain.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 分页响应值
 */
public interface PageResult<T> extends Serializable {

    /**
     * 获取总记录数
     *
     * @return
     */
    Integer getTotal();

    /**
     * 获取总页数
     *
     * @return
     */
    Integer getPages();

    /**
     * 获取每页条数
     *
     * @return
     */
    Integer getLimit();

    /**
     * 获取当前页码
     *
     * @return
     */
    Integer getOffset();

    /**
     * 获取数据列表
     *
     * @return
     */
    List<T> getData();
}
