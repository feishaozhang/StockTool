package com.stock.catchengine;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TemplateConfig {

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 标签列表
     */
    private List<String> tags;

    /**
     * 映射文件
     */
    private Map<String,String> mapping;

    /**
     * model名称
     */
    private String modelName;

    private String path;
}
