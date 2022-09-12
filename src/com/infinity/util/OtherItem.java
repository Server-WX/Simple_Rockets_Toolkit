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
 *
 * 其他功能工具类
 * 参数：文件名，颜色格子数量，惯性张量值，燃料管道开关
 *
 * */

public class OtherItem {
    private String fileName;
    private String colorBlockNumber;
    private String inertiaTensorNumber;
    private String fuelLineToggle;

    public OtherItem(String fileName, String colorBlockNumber, String inertiaTensorNumber, String fuelLineToggle) {
        this.fileName = fileName;
        this.colorBlockNumber = colorBlockNumber;
        this.inertiaTensorNumber = inertiaTensorNumber;
        this.fuelLineToggle = fuelLineToggle;

        SAXReader reader = new SAXReader();
        Properties props = System.getProperties();

        Document read = null;

        try { // 当文件不存在时报错
            read = reader.read(props.getProperty("user.home") + "\\AppData\\LocalLow\\Jundroo\\SimpleRockets 2\\UserData\\CraftDesigns\\" + fileName + ".xml");
        } catch (DocumentException e) {
            System.out.println("文件不存在");
        }

        Element rootEmt = read.getRootElement();

        // 添加颜色格子功能
        if (!colorBlockNumber.equals("")) {
            // 获取DesignerSettings子节点
            List<Element> designerSettings = rootEmt.elements("DesignerSettings");

            designerSettings.forEach(ret -> {
                // 获取颜色格子所在的Theme字节点
                Element theme = ret.element("Theme");
                for (int i = 0; i < Integer.valueOf(colorBlockNumber); i++) {
                    // 循环添加颜色格子的Material子节点以及属性
                    Element material = theme.addElement("Material");
                    material.addAttribute("color", "FFFFFF");
                    material.addAttribute("m", "0");
                    material.addAttribute("s", "0");
                }
            });
            // 获取Themes子节点
            List<Element> themes = rootEmt.elements("Themes");
            themes.forEach(ret -> {
                // 获取颜色格子所在的Theme字节点
                Element theme = ret.element("Theme");
                for (int i = 0; i < Integer.valueOf(colorBlockNumber); i++) {
                    // 循环添加颜色格子的Material子节点以及属性
                    Element material = theme.addElement("Material");
                    material.addAttribute("color", "FFFFFF");
                    material.addAttribute("m", "0");
                    material.addAttribute("s", "0");
                }
            });
        }

        // 惯性张量设置
        if (!inertiaTensorNumber.equals("")) {
            List<Element> parts = rootEmt.element("Assembly").element("Parts").elements("Part");

            // 修改零件的惯性张量
            if (inertiaTensorNumber.equals("DEFAULT")) {
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    if (config.attribute("inertiaTensorUserScale") != null) { // 还原默认值
                        config.remove(config.attribute("inertiaTensorUserScale"));
                    }
                });
            }

            if (!inertiaTensorNumber.equals("")) {
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    config.addAttribute("inertiaTensorUserScale", inertiaTensorNumber);
                });
            }
        }

        // 零件油路开关
        List<Element> parts = rootEmt.element("Assembly").element("Parts").elements("Part");
        switch (fuelLineToggle){
            case "ON":
                parts.forEach(ret->{
                    Element config = ret.element("Config");
                    config.addAttribute("fuelLine","true");
                });
                break;
            case "OFF":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    if (config.attribute("fuelLine") != null) {
                        config.remove(config.attribute("fuelLine"));
                    }
                });
                break;
            case "开启":
                parts.forEach(ret->{
                    Element config = ret.element("Config");
                    config.addAttribute("fuelLine","true");
                });
                break;
            case "关闭":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    if (config.attribute("fuelLine") != null) {
                        config.remove(config.attribute("fuelLine"));
                    }
                });
                break;
        }


        // 创建输出流保存文件至存档目录
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding(StandardCharsets.UTF_8.name());
        try {
            FileOutputStream fos = new FileOutputStream(props.getProperty("user.home") + "\\AppData\\LocalLow\\Jundroo\\SimpleRockets 2\\UserData\\CraftDesigns\\" + fileName + "-Edit.xml");
            XMLWriter xmlWriter = new XMLWriter(fos, outputFormat);
            xmlWriter.write(read);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
