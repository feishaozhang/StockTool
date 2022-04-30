package com.stock.catchengine;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.alibaba.fastjson.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DefaultCatchEngine implements CatchEngine{

    private TemplateConfig templateConfig;
    private WebDriver driver;
    private String configPath = "/channel/jbyj.json";

    @Override
    public void init() {
        synchronized (DefaultCatchEngine.class){
            templateConfig = loadTemplateConfig();
            driver = DriverManger.getDriver();
        }
    }

    public TemplateConfig loadTemplateConfig() {
        ClassPathResource classPathResource = new ClassPathResource(configPath);
        String s = FileUtil.readUtf8String(classPathResource.getFile());
        return JSONObject.parseObject(s,TemplateConfig.class);
    }

    @Override
    public boolean process(List tasks) {
        driver.get(templateConfig.getPath());

        List<String> tags = templateConfig.getTags();
        if(CollectionUtil.isEmpty(tags)){
            throw new RuntimeException("template tags cannot be null");
        }

        String firstTag = tags.stream().findFirst().get();
        WebElement firstWebElement = driver.findElement(By.ByTagName.tagName(firstTag));

        Class<?> aClass = null;
        try {
            aClass = Class.forName(templateConfig.getModelName());
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
        if(aClass == null){
            throw new RuntimeException("model not exist");
        }

        //判空firstWebElement
        recursionGet(firstWebElement,tags,0);


        return true;
    }

    private void recursionGet(WebElement webElement,List<String> tags,int index,){
        if(webElement == null || index > tags.size())
            return ;

        List<WebElement> webElementList = webElement.findElements(By.ByTagName.tagName(tags.get(index++)));
        final int currentIndex = index+1;
        webElementList.stream().forEach(webElementTemp->recursionGet(webElementTemp,tags,currentIndex));
    }
}
