package com.baicai.pojo;

import java.util.List;

/**
 * EasyUI分页对象
 * tips: total和rows是Datagrid固定的参数key,所以属性要和前端保持一致
 */
public class EasyUIPage {
    private Long total;
    private List<?> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
