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
 * 修改全局零件的质量大小
 * 参数：文件名，质量数字
 * 还原默认传入“默认”
 */

public class GeneralMassScale {
    private String fileName;
    private String massNumber;

    public GeneralMassScale(String fileName, String massNumber) throws IOException {
        this.fileName = fileName;
        this.massNumber = massNumber;

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

        if (massNumber.equals("DEFAULT")) {
            parts.forEach(ret -> {
                Element config = ret.element("Config");
                if (config.attribute("massScale") != null) { // 还原默认值
                    config.remove(config.attribute("massScale"));
                }

            });
        } else {
            parts.forEach(ret -> {
                Element config = ret.element("Config");
                // 修改零件质量
                config.addAttribute("massScale", massNumber);
            });
        }


        // 创建输出流保存文件至存档目录
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding(StandardCharsets.UTF_8.name());
        FileOutputStream fos = new FileOutputStream(filePath + fileName + "-Edit.xml");
        XMLWriter xmlWriter = new XMLWriter(fos, outputFormat);
        xmlWriter.write(read);
        xmlWriter.close();
    }
}
