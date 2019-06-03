package com.zidongxiangxi.practise.two.container;

import java.util.HashSet;
import java.util.Set;

/**
 * 动态数据源上线文
 *
 * @author chenxudong
 * @date 2019/06/03
 */
public class DynamicDataSourceContextHolder {
    /**
     * 当前使用的数据源，用threadLocal保存
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 规定的数据源id
     */
    public static Set<String> dataSourceIds = new HashSet<>();

    /**
     * 设置数据源
     *
     * @param dataSource 数据源
     */
    public static void setDataSource(String dataSource) {
        CONTEXT_HOLDER.set(dataSource);
    }

    /**
     * 返回当前数据源
     * @return 当前数据源
     */
    public static String getDataSource() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清楚数据源设置
     */
    public static void clearDataSource() {
        CONTEXT_HOLDER.remove();
    }

    /**
     * 判断数据源是否存在
     * @param dataSource
     * @return
     */
    public static boolean containsDataSource(String dataSource){
        return dataSourceIds.contains(dataSource);
    }
}
