package com.ymm.info.logplatform.model;

import java.util.List;

/**
 * @author fanyu9488
 * @version Id: PageVO, v 0.1 2018/8/23 12:13 fanyu9488 Exp $
 */
public class PageVO<T> {

    //总页数
    private Long totalPage;

    //总记录数
    private Long totalCount;

    //每页显示集合
    private List<T> rows;


    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
