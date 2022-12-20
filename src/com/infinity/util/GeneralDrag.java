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
 * 阻力设定类
 * 需传形参：文件名，开关阻力，阻力值
 * 开关阻力为 true 时开启 Include In Drag反之关闭
 * 阻力值为 Drag Scale 滑条的值:
 * 更改新数值时传入字符串数字
 * 还原默认值时传入默认
 * 保持不变时传入空字符串
 */

public class GeneralDrag {
    public GeneralDrag(String fileName, String gdModel, String gdValue) throws IOException {

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


        // 修改General Drag的设定值
        switch (gdModel){
            case "ON":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    // 当属性返回值不等于null时说明该属性存在
                    if (config.attribute("includeInDrag") != null) {
                        config.remove(config.attribute("includeInDrag"));
                    }
                });
                break;
            case "OFF":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    config.addAttribute("includeInDrag", "false");

                });
                break;
            case "开启":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    // 当属性返回值不等于null时说明该属性存在
                    if (config.attribute("includeInDrag") != null) {
                        config.remove(config.attribute("includeInDrag"));
                    }
                });
                break;
            case "关闭":
                parts.forEach(ret -> {
                    Element config = ret.element("Config");
                    config.addAttribute("includeInDrag", "false");

                });
                break;
        }

        // 修改General Drag Value的设定值
        if (gdValue.equals("DEFAULT")) {
            // 将阻力滑条还原默认
            parts.forEach(ret -> {
                Element config = ret.element("Config");
                if (config.attribute("dragScale") != null) {
                    config.remove(config.attribute("dragScale"));
                }

            });
        } else if (!gdValue.equals("DEFAULT") && !gdValue.equals("")) {
            // 设定为指定的阻力值
            parts.forEach(ret -> {
                Element config = ret.element("Config");
                config.addAttribute("dragScale", gdValue);

            });
        }


        org.dom4j.io.OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding(StandardCharsets.UTF_8.name());
        FileOutputStream fos = new FileOutputStream(filePath + fileName + "-Edit.xml");
        XMLWriter xmlWriter = new XMLWriter(fos, outputFormat);
        xmlWriter.write(read);
        xmlWriter.close();

    }
}
