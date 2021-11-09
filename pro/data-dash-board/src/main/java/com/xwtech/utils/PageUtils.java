package com.xwtech.utils;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/6
 */
public class PageUtils {

    /**
     * @param pageNum
     * @param pageSize
     * @param select   通过 ISelect 查询的结果会直接返回到 Page 中，且以第一条执行的 Sql 为准。
     * @return
     */
    public static PageInfo page(int pageNum, int pageSize, ISelect select) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(select);
    }

    public static PageInfo page(Map<String, Object> params, int pageSize, ISelect select) {
        Integer pageNum = params.get("pageNum") == null ? 1 : Integer.valueOf(params.get("pageNum").toString());
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(select);
    }

}