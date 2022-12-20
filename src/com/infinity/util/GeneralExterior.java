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
 * 全局外观工具类
 * 参数：文件名，零件碎片化，零件透明化，油箱纹理，零件阴影
 * 零件透明化默认值false
 * 零件透明化默认值true
 * 清除邮箱默认值false
 * 零件阴影默认值true
 */

public class GeneralExterior {

    public GeneralExterior(String fileName, String preventDebris, String transparencySupport, String textureRemoval, String shadowToggle) {
        SAXReader saxReader = new SAXReader();
        Properties props = System.getProperties();
        String filePath = props.getProperty("user.home") + "/Library/Application Support/com.jundroo.SimpleRockets2/UserData/CraftDesigns/";
        Document read = null;

        {
            try {
                read = saxReader.read(filePath + fileName + ".xml");
            } catch (DocumentException e) {
                System.out.println("文件不存在");
            }
        }

        Element rootElement = read.getRootElement();
        List<Element> parts = rootElement.element("Assembly").element("Parts").elements("Part");

        // 修改零件是否碎片化
        switch (preventDebris) {
            case "ON":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    config.addAttribute("preventDebris", "true");
                });
                break;
            case "OFF":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    if (config.attribute("preventDebris") != null) { // 还原默认值
                        config.remove(config.attribute("preventDebris"));
                    }
                });
                break;
            case "开":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    config.addAttribute("preventDebris", "true");
                });
                break;
            case "关":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    if (config.attribute("preventDebris") != null) { // 还原默认值
                        config.remove(config.attribute("preventDebris"));
                    }
                });
                break;
        }

        // 修改零件是否透明化
        switch (transparencySupport) {
            case "ON":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    if (config.attribute("supportsTransparency") != null) { // 还原默认值
                        config.remove(config.attribute("supportsTransparency"));
                    }
                });
                break;
            case "OFF":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    config.addAttribute("supportsTransparency", "false");
                });
                break;
            case "开":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    if (config.attribute("supportsTransparency") != null) { // 还原默认值
                        config.remove(config.attribute("supportsTransparency"));
                    }
                });
                break;
            case "关":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    config.addAttribute("supportsTransparency", "false");
                });
                break;
        }

        // 清除油箱纹理
        switch (textureRemoval) {
            case "true":
                parts.forEach(ret -> {
                    if (ret.attribute("partType").getText().equals("Fuselage1")) {
                        ret.addAttribute("texture", "Default");
                    }
                });
                break;
        }

        // 修改零件阴影
        switch (shadowToggle) {
            case "ON":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    if (config.attribute("castShadows") != null) { // 还原默认值
                        config.remove(config.attribute("castShadows"));
                    }
                });
                break;
            case "OFF":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    config.addAttribute("castShadows", "false");
                });
                break;
            case "开":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    if (config.attribute("castShadows") != null) { // 还原默认值
                        config.remove(config.attribute("castShadows"));
                    }
                });
                break;
            case "关":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    config.addAttribute("castShadows", "false");
                });
                break;
        }

        // 创建输出流保存文件
        org.dom4j.io.OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding(StandardCharsets.UTF_8.name());
        try {
            FileOutputStream fos = new FileOutputStream(filePath + fileName + "-Edit.xml");
            XMLWriter xmlWriter = new XMLWriter(fos, outputFormat);
            xmlWriter.write(read);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
