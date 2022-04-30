package com.stock.model;

import lombok.Data;

/**
 * 业绩信息模型
 */
@Data
public class YjInfo {
    /**
     * 股票代码
     */
    private String stockCode;

    /**
     * 股票简称
     */
    private String stockSimpleName;

    /**
     * 详情
     */
    private String stockDetail;

    /**
     * 每股收益
     */
    private String earningPerShare;

    /**
     * 每股净资产
     */
    private String meiGuJingZiChan;

    /**
     * 净资产收益率%
     */
    private String jingZiChanShouYiLv;

    /**
     * 每股经营现金流量（元）
     */
    private String meiGuJingYingXianJinLiuLiang;

    /**
     * 销售毛利率 %
     */
    private String xiaoShouMaoLiLv;

    /**
     * 行业
     */
    private String hangYe;

    /**
     * 公告日期
     */
    private String gongGaoRiQi;

    /**
     * 净利润
     */
    private String jingLiRun;

    /**
     * 同比增长
     */
    private String tongBiZengzZhang;


    /**
     * 季度环比
     */
    private String YingYeZongShouRuJiDuHuanBi;

    /**
     * 营业总收入
     */
    private String yingYeShouRu;

    /**
     * 同比增长
     */
    private String tongbiZengZhang;

    /**
     * 季度环比
     */
    private String JingLiRunJiDuHuanBi;

}
