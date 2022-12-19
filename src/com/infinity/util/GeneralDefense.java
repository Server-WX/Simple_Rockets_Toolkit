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
 * 修改全局零件抗性工具类
 * 参数：文件名，血量，抗热系数
 *
 * 还原默认值时传入默认
 *
 * 不需要使用时传空字符串
 */

public class GeneralDefense {
    private String fileName;
    private String damageNumber;
    private String antiHeat;

    public GeneralDefense(String fileName, String damageNumber, String antiHeat) throws IOException {
        this.fileName = fileName;
        this.damageNumber = damageNumber;
        this.antiHeat = antiHeat;

        SAXReader saxReader = new SAXReader();
        Properties props = System.getProperties();
        String filePath = props.getProperty("user.home") + "\\AppData\\LocalLow\\Jundroo\\SimpleRockets 2\\UserData\\CraftDesigns\\";
        Document read = null;

        try {
            read = saxReader.read(filePath + fileName + ".xml");
        } catch (DocumentException e) {
            System.out.println("文件不存在");
        }

        Element rootElement = read.getRootElement();
        List<Element> parts = rootElement.element("Assembly").element("Parts").elements("Part");

        if (damageNumber.equals("DEFAULT")) {
            parts.forEach(ret -> {
                Element config = ret.element("Config");
                if (config.attribute("maxDamage") != null) { // 恢复默认
                    config.remove(config.attribute("maxDamage"));
                }
            });
        } else {
            parts.forEach(ret -> {
                Element config = ret.element("Config");

                if (!damageNumber.equals("")) {
                    // 零件血量
                    config.addAttribute("maxDamage", damageNumber);
                }

            });
        }

        if (antiHeat.equals("DEFAULT")) {
            parts.forEach(ret -> {
                Element config = ret.element("Config");
                if (config.attribute("heatShield") != null) { // 还原默认值
                    config.remove(config.attribute("heatShield"));
                }

            });
        } else {
            parts.forEach(ret -> {
                Element config = ret.element("Config");

                if (!antiHeat.equals("")) {
                    // 零件抗热系数
                    config.addAttribute("heatShield", antiHeat);
                }
                if (config.attribute("heatShield") != null) { // 移除内鬼
                    config.remove(config.attribute("heatShield"));
                }

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
