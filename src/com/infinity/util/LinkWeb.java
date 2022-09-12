package com.infinity.util;

import java.io.IOException;

/**
 * 跳转浏览器打开指定网址
 */

public class LinkWeb {

    public LinkWeb(String[] urls) {
        for (String url : urls) {
            if (java.awt.Desktop.isDesktopSupported()) {
                //创建一个URI实例,注意不是URL
                java.net.URI uri = java.net.URI.create(url);
                //获取当前系统桌面扩展
                java.awt.Desktop dp = java.awt.Desktop.getDesktop();
                //判断系统桌面是否支持要执行的功能
                if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    //获取系统默认浏览器打开链接
                    try {
                        dp.browse(uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /*public static void main(String[] args) throws IOException, InterruptedException {
        openBrowse(new String[]{"https://www.simplerockets.com/"});
    }*/

}
