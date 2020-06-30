package com.xiaoguo.model;

import java.util.List;

public class PageInfo<T> {
    private Integer curPageNum;// 当前页
    private Integer countRow;//总行数
    private List<T> data;//分页查询的数据

    public Integer getCurPageNum() {
        return curPageNum;
    }

    public void setCurPageNum(Integer curPageNum) {
        this.curPageNum = curPageNum;
    }

    public Integer getCountRow() {
        return countRow;
    }

    public void setCountRow(Integer countRow) {
        this.countRow = countRow;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
