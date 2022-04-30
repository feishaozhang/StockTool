package com.stock.catchengine;

import java.util.List;

/**
 * 数据抓取引擎
 */
public interface CatchEngine<T> {

    void init();

    boolean process(List<T> tasks);
}
