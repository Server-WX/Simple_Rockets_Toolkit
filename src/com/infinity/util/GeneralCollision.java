package com.infinity.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

/**
 * 碰撞机制工具类
 * 需传入形参：文件名，碰撞箱，碰撞箱规则，碰撞机制，碰撞的机制
 * <p>
 * 碰撞箱参数为true时才修改其属性，反之不更改
 * 碰撞机制参数为true时才修改其属性，反之不更改
 * <p>
 * 具体规则查阅游戏内的属性值
 */

public class GeneralCollision {

    public GeneralCollision(String fileName, String gcList, String gcrList) throws IOException {

        SAXReader saxReader = new SAXReader();
        Properties props = System.getProperties();
        String filePath = props.getProperty("user.home") + "/Library/Application Support/com.jundroo.SimpleRockets2/UserData/CraftDesigns/";
        Document read = null;

        try {
            read = saxReader.read(filePath + fileName + ".xml");
        } catch (DocumentException e) {
            System.out.println("文件不存在");
        }

        Element rootElement = read.getRootElement();
        List<Element> parts = rootElement.element("Assembly").element("Parts").elements("Part");


        // 修改General Collision的设定值
        switch (gcList) {
            case "Default":
                // 将General Collision设置为Default
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    // 当属性返回值不等于null时说明该属性存在
                    if (config.attribute("partCollisionHandling") != null) {
                        config.remove(config.attribute("partCollisionHandling"));
                    }

                });
                break;
            case "Always":
                // 将General Collision设置为Always
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    // 当属性返回值不等于null时说明该属性存在
                    config.addAttribute("partCollisionHandling", "Always");

                });
                break;
            case "Never":
                // 将General Collision设置为Never
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    // 当属性返回值不等于null时说明该属性存在
                    config.addAttribute("partCollisionHandling", "Never");

                });
                break;
        }


        // 修改General Collision Response的设定值
        switch (gcrList) {
            case "Default":
                // 将General Collision设置为Default
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    // 当属性返回值不等于null时说明该属性存在
                    if (config.attribute("partCollisionResponse") != null) {
                        config.remove(config.attribute("partCollisionResponse"));
                    }

                });
                break;
            case "None":
                // 将碰撞设置为None
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    // 当属性返回值不等于null时说明该属性存在
                    config.addAttribute("partCollisionResponse", "None");

                });
                break;
            case "DisOnly":
                // 将碰撞机制设为撞击后不会发生爆炸
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    // 当属性返回值不等于null时说明该属性存在
                    config.addAttribute("partCollisionResponse", "DisconnectOnly");

                });
                break;
        }


        // 创建输出流保存文件
        org.dom4j.io.OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding(StandardCharsets.UTF_8.name());
        FileOutputStream fos = new FileOutputStream(filePath + fileName + "-Edit.xml");
        XMLWriter xmlWriter = new XMLWriter(fos, outputFormat);
        xmlWriter.write(read);
        xmlWriter.close();

    }

}
