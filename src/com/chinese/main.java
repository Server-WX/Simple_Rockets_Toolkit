package com.chinese;

import com.infinity.util.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class main {

    public static void main(String[] args) {
        String titleName = "SR2 Toolkit";
        String titleEditName = titleName + " " + "—— 修改成功";
        JFrame frame = new JFrame(titleName);
        JPanel panel = new JPanel();

        Properties props = System.getProperties();
        String filePath = props.getProperty("user.home") + "/Library/Application Support/com.jundroo.SimpleRockets2/UserData/CraftDesigns/";

        frame.setSize(560, 550);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        frame.setIconImage(new ImageIcon(main.class.getResource("/images/icon.png")).getImage());

        // 背景色面板
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.setBackground(new Color(29, 33, 39));

        // 上方LOGO栏
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        logoPanel.setBackground(null);
        JLabel srtLogo = new JLabel(new ImageIcon(main.class.getResource("/images/TitleLogo.png")));
        JLabel toolLogo = new JLabel(new ImageIcon(main.class.getResource("/images/ToolLogo.png")));
        logoPanel.add(srtLogo);
        logoPanel.add(toolLogo);

        JPanel horizontalLine = new JPanel(); // 水平线
        horizontalLine.setPreferredSize(new Dimension(560, 4));
        horizontalLine.setBackground(new Color(51, 63, 80));

        // 中心面板
        JPanel bodyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 80));
        bodyPanel.setBackground(new Color(29, 33, 39));
        bodyPanel.setPreferredSize(new Dimension(560, 425));

        // 主体内容面板
        JPanel appPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 110, 25));
        appPanel.setPreferredSize(new Dimension(410, 270));
        appPanel.setBackground(new Color(51, 63, 80));

        JLabel titleText = new JLabel("请输入存档名称");
        titleText.setFont(new Font("微软雅黑", Font.BOLD, 22));
        titleText.setForeground(Color.white);

        JTextField inputFileName = new JTextField(); // 文件名输入框
        inputFileName.setPreferredSize(new Dimension(150, 30));
        inputFileName.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        inputFileName.setForeground(Color.white);
        inputFileName.setBackground(new Color(43, 54, 70));
        inputFileName.setHorizontalAlignment(SwingConstants.CENTER);
        inputFileName.requestFocus();

        JButton indexButton = new JButton("确定");
        indexButton.setPreferredSize(new Dimension(100, 45));
        indexButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        indexButton.setBackground(new Color(29, 33, 39));
        indexButton.setOpaque(true);
        indexButton.setBorderPainted(false);
        indexButton.setForeground(Color.white);
        indexButton.setFocusPainted(false);

        JButton indexHelperButton = new JButton("使用说明");
        indexHelperButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        indexHelperButton.setForeground(Color.white);
        indexHelperButton.setBackground(null);
        indexHelperButton.setFocusPainted(false);
        indexHelperButton.setBorderPainted(false);

        appPanel.add(titleText);
        appPanel.add(inputFileName);
        appPanel.add(indexButton);
        appPanel.add(indexHelperButton);

        // 页脚面板
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 140, 0));
        footerPanel.setPreferredSize(new Dimension(560, 85));
        footerPanel.setBackground(Color.black);
        JLabel madeBy = new JLabel("By:JasonCaesar");
        madeBy.setPreferredSize(new Dimension(125, 25));
        madeBy.setFont(new Font("微软雅黑", Font.ITALIC, 16));
        madeBy.setForeground(Color.white);

        JLabel footImg = new JLabel(new ImageIcon(main.class.getResource("/images/FooterImg.png")));
        footImg.setBackground(null);

        footerPanel.add(madeBy);
        footerPanel.add(footImg);


        // 帮助按钮监听
        indexHelperButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "在输入框内填入你存档的名称，不要加.xml后缀"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "如果报错则说明文件名填写有误"
                    , "请仔细阅读使用说明", JOptionPane.PLAIN_MESSAGE);    //消息对话框
        });


        // 菜单面板
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 10));
        menuPanel.setVisible(false);

        menuPanel.setPreferredSize(new Dimension(410, 355));
        menuPanel.setBackground(new Color(51, 63, 80));
        JLabel menuText = new JLabel("功能列表");
        menuText.setFont(new Font("微软雅黑", Font.BOLD, 22));
        menuText.setForeground(Color.white);
        // 按钮面板
        JPanel menuButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        menuButtonPanel.setPreferredSize(new Dimension(160, 250));
        menuButtonPanel.setBackground(null);
        // 功能列表的按钮声明
        JButton reStart = new JButton("重选存档");
        JButton craftReszie = new JButton("存档整体缩放");
        JButton craftCollision = new JButton("存档碰撞属性");
        JButton craftDrag = new JButton("存档阻力属性");
        JButton craftResistances = new JButton("存档抗性设置");
        JButton craftAppearance = new JButton("存档外观设置");
        JButton otherProperties = new JButton("存档其他属性");
        // 按钮样式设定
        reStart.setPreferredSize(new Dimension(150, 30));
        reStart.setFont(new Font("微软雅黑", Font.BOLD, 16));
        reStart.setBackground(new Color(43, 54, 70));
        reStart.setOpaque(true);
        reStart.setBorderPainted(false);
        reStart.setFocusPainted(false);
        reStart.setForeground(Color.white);

        craftReszie.setPreferredSize(new Dimension(150, 30));
        craftReszie.setFont(new Font("微软雅黑", Font.BOLD, 16));
        craftReszie.setBackground(new Color(43, 54, 70));
        craftReszie.setOpaque(true);
        craftReszie.setBorderPainted(false);
        craftReszie.setFocusPainted(false);
        craftReszie.setForeground(Color.white);

        craftCollision.setPreferredSize(new Dimension(150, 30));
        craftCollision.setFont(new Font("微软雅黑", Font.BOLD, 16));
        craftCollision.setBackground(new Color(43, 54, 70));
        craftCollision.setOpaque(true);
        craftCollision.setBorderPainted(false);
        craftCollision.setFocusPainted(false);
        craftCollision.setForeground(Color.white);

        craftDrag.setPreferredSize(new Dimension(150, 30));
        craftDrag.setFont(new Font("微软雅黑", Font.BOLD, 16));
        craftDrag.setBackground(new Color(43, 54, 70));
        craftDrag.setOpaque(true);
        craftDrag.setBorderPainted(false);
        craftDrag.setFocusPainted(false);
        craftDrag.setForeground(Color.white);

        craftResistances.setPreferredSize(new Dimension(150, 30));
        craftResistances.setFont(new Font("微软雅黑", Font.BOLD, 16));
        craftResistances.setBackground(new Color(43, 54, 70));
        craftResistances.setOpaque(true);
        craftResistances.setBorderPainted(false);
        craftResistances.setFocusPainted(false);
        craftResistances.setForeground(Color.white);

        craftAppearance.setPreferredSize(new Dimension(150, 30));
        craftAppearance.setFont(new Font("微软雅黑", Font.BOLD, 16));
        craftAppearance.setBackground(new Color(43, 54, 70));
        craftAppearance.setOpaque(true);
        craftAppearance.setBorderPainted(false);
        craftAppearance.setFocusPainted(false);
        craftAppearance.setForeground(Color.white);

        otherProperties.setPreferredSize(new Dimension(150, 30));
        otherProperties.setFont(new Font("微软雅黑", Font.BOLD, 16));
        otherProperties.setBackground(new Color(43, 54, 70));
        otherProperties.setOpaque(true);
        otherProperties.setBorderPainted(false);
        otherProperties.setFocusPainted(false);
        otherProperties.setForeground(Color.white);

        // 帮助按钮
        JButton menuHelp = new JButton("使用说明");
        menuHelp.setFont(new Font("微软雅黑", Font.BOLD, 14));
        menuHelp.setBackground(new Color(43, 54, 70));
        menuHelp.setOpaque(true);
        menuHelp.setBorderPainted(false);
        menuHelp.setFocusPainted(false);
        menuHelp.setForeground(Color.white);
        // 帮助按钮监听
        menuHelp.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "存档整体缩放包含体积的缩放与质量的缩放"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "存档碰撞包含了存档的碰撞箱开关与碰撞规则的设定"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "存档阻力包含了阻力的开关与阻力大小的调整"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "存档抗性用于更改存档的零件血量与抗热系数"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "存档外观用于修改零件透明、零件阴影、去除油箱默认纹理、以及是否会变成碎片"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "其他选项的设定有：全局张量、零件燃料管路开关、以及喷漆的颜色格子数量"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "注意：每输入一次存档名只能修改一次！"
                            + "\r\n" +
                            "如有多次修改需求请在修改完后点击重选存档，并改为新的存档名称再继续！"
                    , "请仔细阅读使用说明", JOptionPane.PLAIN_MESSAGE);    //消息对话框
        });

        menuButtonPanel.add(reStart);
        menuButtonPanel.add(craftReszie);
        menuButtonPanel.add(craftCollision);
        menuButtonPanel.add(craftDrag);
        menuButtonPanel.add(craftResistances);
        menuButtonPanel.add(craftAppearance);
        menuButtonPanel.add(otherProperties);

        menuPanel.add(menuText);
        menuPanel.add(menuButtonPanel);
        menuPanel.add(menuHelp);

        // 通用面板
        JPanel universalPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 32, 0));
        universalPanel.setPreferredSize(new Dimension(480, 380));
        universalPanel.setBackground(null);
        universalPanel.setVisible(false);

        // 左侧居中面板
        JPanel verticalPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 70));
        verticalPanel.setPreferredSize(new Dimension(180, 380));
        verticalPanel.setBackground(null);

        // 右侧功能面板
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(235, 380));
        rightPanel.setBackground(null);

        // 左侧菜单面板
        JPanel listMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 5));
        listMenu.setPreferredSize(new Dimension(160, 210));
        listMenu.setBackground(null);

        // 菜单按钮
        JButton changeFunction = new JButton("返回功能列表");
        changeFunction.setPreferredSize(new Dimension(160, 35));
        changeFunction.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        changeFunction.setForeground(Color.white);
        changeFunction.setBackground(new Color(43, 54, 70));
        changeFunction.setOpaque(true);
        changeFunction.setBorderPainted(false);
        changeFunction.setFocusPainted(false);
        changeFunction.addActionListener(click -> {
            menuPanel.setVisible(true);
            universalPanel.setVisible(false);
            bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 36));
            frame.setTitle(titleName);
        });

        JButton changeFile = new JButton("更换存档");
        changeFile.setPreferredSize(new Dimension(160, 35));
        changeFile.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        changeFile.setForeground(Color.white);
        changeFile.setBackground(new Color(43, 54, 70));
        changeFile.setOpaque(true);
        changeFile.setBorderPainted(false);
        changeFile.setFocusPainted(false);
        changeFile.addActionListener(click -> {
            appPanel.setVisible(true);
            menuPanel.setVisible(false);
            universalPanel.setVisible(false);
            bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));
            frame.setTitle(titleName);
        });

        JButton officialWebsite = new JButton("SR2官网首页");
        officialWebsite.setPreferredSize(new Dimension(160, 35));
        officialWebsite.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        officialWebsite.setForeground(Color.white);
        officialWebsite.setBackground(new Color(43, 54, 70));
        officialWebsite.setOpaque(true);
        officialWebsite.setBorderPainted(false);
        officialWebsite.setFocusPainted(false);
        officialWebsite.addActionListener(click -> new LinkWeb(new String[]{"https://www.simplerockets.com/"}));

        JButton authorProfile = new JButton("关于软件作者");
        authorProfile.setPreferredSize(new Dimension(160, 35));
        authorProfile.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        authorProfile.setForeground(Color.white);
        authorProfile.setBackground(new Color(43, 54, 70));
        authorProfile.setOpaque(true);
        authorProfile.setBorderPainted(false);
        authorProfile.setFocusPainted(false);
        authorProfile.addActionListener(click -> new LinkWeb(new String[]{"https://www.simplerockets.com/u/JasonCaesar007"}));

        JButton studioFansChat = new JButton("工作室粉丝群");
        studioFansChat.setPreferredSize(new Dimension(160, 35));
        studioFansChat.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        studioFansChat.setForeground(Color.white);
        studioFansChat.setBackground(new Color(43, 54, 70));
        studioFansChat.setOpaque(true);
        studioFansChat.setBorderPainted(false);
        studioFansChat.setFocusPainted(false);
        studioFansChat.addActionListener(click -> new LinkWeb(new String[]{"https://jq.qq.com/?_wv=1027&k=XQkowZVq"}));

        listMenu.add(changeFunction);
        listMenu.add(changeFile);
        listMenu.add(officialWebsite);
        listMenu.add(authorProfile);
        listMenu.add(studioFansChat);

        // 整体缩放面板
        JPanel craftResziePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 15));
        craftResziePanel.setPreferredSize(new Dimension(235, 380));
        craftResziePanel.setBackground(new Color(51, 63, 80));
        JLabel cResizeTitleLabel = new JLabel("存档整体缩放");
        cResizeTitleLabel.setFont(new Font("微软雅黑", Font.BOLD, 22));
        cResizeTitleLabel.setForeground(Color.white);

        JLabel resizeLabel = new JLabel("输入体积缩放倍数:");
        resizeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        resizeLabel.setForeground(Color.white);

        // 缩放倍数
        JTextField resizeNumber = new JTextField();
        resizeNumber.setPreferredSize(new Dimension(150, 30));
        resizeNumber.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        resizeNumber.setBackground(new Color(43, 54, 70));
        resizeNumber.setHorizontalAlignment(SwingConstants.CENTER);
        resizeNumber.setForeground(Color.white);

        JPanel radioPanelResize = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton toWidth = new JRadioButton("仅修改直径", true);
        JRadioButton toScale = new JRadioButton("仅修改三维");
        toWidth.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        toScale.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        toWidth.setForeground(Color.white);
        toScale.setForeground(Color.white);
        toWidth.setFocusPainted(false);
        toScale.setFocusPainted(false);
        toWidth.setBackground(null);
        toScale.setBackground(null);
        radioPanelResize.setBackground(null);

        buttonGroup.add(toWidth);
        buttonGroup.add(toScale);
        radioPanelResize.add(toWidth);
        radioPanelResize.add(toScale);

        // 调整质量的面板
        JLabel massLabel = new JLabel("调整质量倍数");
        massLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        massLabel.setForeground(Color.white);
        JTextField massNumber = new JTextField();
        massNumber.setPreferredSize(new Dimension(150, 30));
        massNumber.setBackground(new Color(43, 54, 70));
        massNumber.setHorizontalAlignment(SwingConstants.CENTER);
        massNumber.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        massNumber.setForeground(Color.white);

        // 确定按钮及监听器
        JButton resizeButton = new JButton("确定");
        resizeButton.setPreferredSize(new Dimension(100, 45));
        resizeButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        resizeButton.setBackground(new Color(29, 33, 39));
        resizeButton.setOpaque(true);
        resizeButton.setBorderPainted(false);
        resizeButton.setForeground(Color.white);
        resizeButton.setFocusPainted(false);
        resizeButton.addActionListener(click -> {
            CraftResize cr = new CraftResize();

            if (!resizeNumber.getText().equals("")) {
                if (cr.craftResizeTool(inputFileName.getText(), resizeNumber.getText(), toWidth.isSelected())) {
                    //错误提示框
                    JOptionPane.showMessageDialog(null, "缩放倍数有误", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (!massNumber.getText().equals("")) {
                try {
                    new GeneralMassScale(inputFileName.getText(), massNumber.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (resizeNumber.getText().equals("") && massNumber.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "你什么都没输入呢", "错误", JOptionPane.ERROR_MESSAGE);
            }

            frame.setTitle(titleEditName);
        });

        // 帮助按钮及监听
        JButton resizeHelpButton = new JButton("使用说明");
        resizeHelpButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        resizeHelpButton.setForeground(Color.white);
        resizeHelpButton.setBackground(null);
        resizeHelpButton.setFocusPainted(false);
        resizeHelpButton.setBorderPainted(false);
        resizeHelpButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "体积缩放功能与下方的质量修改不能同时使用，只能修改其中一个后，重新选择存档进行二次修改！"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "第一个输入框是体积缩放输入框用于整体放大和缩小存档"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "输入框内只能输入正数不能输入负数，举例："
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "将存档放大至200%，输入2。 将存档缩小至20%，输入0.2，以此类推"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "勾选仅修改直径时将指修改油箱的Width和Depth等尺寸"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "勾选仅修改三维时，对油箱的处理转为只修改Tinker Panel中的Part Scale大小"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "第二个输入框用于缩放存档所有部件的质量大小，举例："
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "当输入2时，会将massScale改为200%，输入0.2时会改成20%，以此类推"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "如果需要保留原来的设定请留空，不要输入任何内容"
                            +
                            "如果需还原默认质量，请在质量输入框内输入“DEFAULT”"
                    , "请仔细阅读使用说明", JOptionPane.PLAIN_MESSAGE);    //消息对话框
        });

        craftResziePanel.add(cResizeTitleLabel);
        craftResziePanel.add(resizeLabel);
        craftResziePanel.add(resizeNumber);
        craftResziePanel.add(radioPanelResize);
        craftResziePanel.add(massLabel);
        craftResziePanel.add(massNumber);
        craftResziePanel.add(resizeButton);
        craftResziePanel.add(resizeHelpButton);

        // 存档碰撞修改
        JPanel craftCollisionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 20));
        craftCollisionPanel.setPreferredSize(new Dimension(235, 350));
        craftCollisionPanel.setBackground(new Color(51, 63, 80));
        JLabel cCollisionTitle = new JLabel("存档碰撞属性");
        cCollisionTitle.setFont(new Font("微软雅黑", Font.BOLD, 22));
        cCollisionTitle.setForeground(Color.white);

        JLabel cCollisionLabel = new JLabel("选择一个模式：");
        cCollisionLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        cCollisionLabel.setForeground(Color.white);

        // 下拉列表面板
        JPanel comboBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        comboBoxPanel.setPreferredSize(new Dimension(220, 100));
        comboBoxPanel.setBackground(null);
        JLabel collisionModel = new JLabel("碰撞箱模式：");
        JLabel collisionResponseModel = new JLabel("碰撞箱反应模式：");
        collisionModel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        collisionResponseModel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        collisionModel.setPreferredSize(new Dimension(112, 30));
        collisionModel.setForeground(Color.white);
        collisionResponseModel.setForeground(Color.white);
        // 添加列表框
        JComboBox cModel = new JComboBox();
        cModel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        cModel.addItem("Default");
        cModel.addItem("Always");
        cModel.addItem("Never");
        cModel.addItem("不更改");
        JComboBox crModel = new JComboBox();
        crModel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        crModel.addItem("Default");
        crModel.addItem("None");
        crModel.addItem("DisOnly");
        crModel.addItem("不更改");

        comboBoxPanel.add(collisionModel);
        comboBoxPanel.add(cModel);
        comboBoxPanel.add(collisionResponseModel);
        comboBoxPanel.add(crModel);

        // 确定按钮及监听
        JButton collisionButton = new JButton("确定");
        collisionButton.setPreferredSize(new Dimension(100, 45));
        collisionButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        collisionButton.setBackground(new Color(29, 33, 39));
        collisionButton.setForeground(Color.white);
        collisionButton.setFocusPainted(false);
        collisionButton.setOpaque(true);
        collisionButton.setBorderPainted(false);
        collisionButton.addActionListener(click -> {
            if (cModel.getSelectedItem().equals("不更改") && crModel.getSelectedItem().equals("不更改")) {
                //错误提示框
                JOptionPane.showMessageDialog(null, "你必须修改其中一项！", "错误", JOptionPane.OK_OPTION);
            } else {
                try {
                    new GeneralCollision(inputFileName.getText(), (String) cModel.getSelectedItem(), (String) crModel.getSelectedItem());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            frame.setTitle(titleEditName);
        });

        // 帮助说明
        JButton collisionHelpButton = new JButton("使用说明");
        collisionHelpButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        collisionHelpButton.setForeground(Color.white);
        collisionHelpButton.setBackground(null);
        collisionHelpButton.setFocusPainted(false);
        collisionHelpButton.setBorderPainted(false);
        collisionHelpButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "单击文本旁边的按钮可弹出下拉列表，选择需要修改的属性"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "碰撞箱模式对应Tinker Panel中的Part Collision"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "碰撞箱反应模式对应Tinker Panel中的Collision Response"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "碰撞反应模式中的“DisOnly”对应的是DisconnectOnly选项"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "当你需要保留原来的属性设置不修改时，请选择”不更改“选项后再确认"
                    , "请仔细阅读使用说明", JOptionPane.PLAIN_MESSAGE);    //消息对话框

        });


        craftCollisionPanel.add(cCollisionTitle);
        craftCollisionPanel.add(cCollisionLabel);
        craftCollisionPanel.add(comboBoxPanel);
        craftCollisionPanel.add(collisionButton);
        craftCollisionPanel.add(collisionHelpButton);

        // 全局阻力面板
        JPanel craftDragPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 20));
        craftDragPanel.setPreferredSize(new Dimension(235, 350));
        craftDragPanel.setBackground(new Color(51, 63, 80));
        JLabel cDragTitle = new JLabel("存档阻力属性");
        cDragTitle.setFont(new Font("微软雅黑", Font.BOLD, 22));
        cDragTitle.setForeground(Color.white);

        JLabel cDragLabel = new JLabel("输入或选择功能：");
        cDragLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        cDragLabel.setForeground(Color.white);
        // 输入框与按钮面板
        JPanel airDragPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        airDragPanel.setBackground(null);
        airDragPanel.setPreferredSize(new Dimension(200, 100));
        JLabel airNumberLabel = new JLabel("阻力倍数：");
        airNumberLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        airNumberLabel.setForeground(Color.white);
        JTextField airNumber = new JTextField();
        airNumber.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        airNumber.setPreferredSize(new Dimension(110, 25));
        airNumber.setHorizontalAlignment(SwingConstants.CENTER);
        airNumber.setBackground(new Color(43, 54, 70));
        airNumber.setForeground(Color.white);

        JLabel airDragToggleLabel = new JLabel("阻力模型：");
        airDragToggleLabel.setPreferredSize(new Dimension(80,30));
        airDragToggleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        airDragToggleLabel.setForeground(Color.white);

        JComboBox dragButton = new JComboBox();
        dragButton.addItem("开启");
        dragButton.addItem("关闭");
        dragButton.addItem("不更改");
        dragButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));


        airDragPanel.add(airNumberLabel);
        airDragPanel.add(airNumber);
        airDragPanel.add(airDragToggleLabel);
        airDragPanel.add(dragButton);

        // 确认按钮及监听
        JButton airDragButton = new JButton("确定");
        airDragButton.setPreferredSize(new Dimension(100, 45));
        airDragButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        airDragButton.setBackground(new Color(29, 33, 39));
        airDragButton.setForeground(Color.white);
        airDragButton.setFocusPainted(false);
        airDragButton.setOpaque(true);
        airDragButton.setBorderPainted(false);
        airDragButton.addActionListener(click -> {
            if (airNumber.getText().equals(" ")) {
                System.out.println("不能为空");
                //错误提示框
                JOptionPane.showMessageDialog(null, "请勿输入空格！", "错误", JOptionPane.OK_OPTION);
            } else {
                try {
                    new GeneralDrag(inputFileName.getText(), (String) dragButton.getSelectedItem(), airNumber.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            frame.setTitle(titleEditName);
        });

        JButton dragHelpButton = new JButton("使用说明");
        dragHelpButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        dragHelpButton.setForeground(Color.white);
        dragHelpButton.setBackground(null);
        dragHelpButton.setFocusPainted(false);
        dragHelpButton.setBorderPainted(false);
        dragHelpButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "此功能模块为调整存档整体的阻力设定"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "阻力倍数对应Tinker Panel中的Drag Scale的值"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "阻力模型对应Include In Drag的开关"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "如需还原Drag Scale的默认值请输入”DEFAULT“"
                    , "请仔细阅读使用说明", JOptionPane.PLAIN_MESSAGE);    //消息对话框
        });

        craftDragPanel.add(cDragTitle);
        craftDragPanel.add(cDragLabel);
        craftDragPanel.add(airDragPanel);
        craftDragPanel.add(airDragButton);
        craftDragPanel.add(dragHelpButton);

        // 存档抗性设定面板
        JPanel craftDefendPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 20));
        craftDefendPanel.setPreferredSize(new Dimension(235, 350));
        craftDefendPanel.setBackground(new Color(51, 63, 80));
        JLabel cDefendTitle = new JLabel("存档抗性设置");
        cDefendTitle.setFont(new Font("微软雅黑", Font.BOLD, 22));
        cDefendTitle.setForeground(Color.white);

        JLabel cDefendLabel = new JLabel("输入或选择功能：");
        cDefendLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        cDefendLabel.setForeground(Color.white);
        // 输入框面板
        JPanel defendInputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        defendInputPanel.setBackground(null);
        defendInputPanel.setPreferredSize(new Dimension(200, 100));
        JLabel maxDamageLabel = new JLabel("零件血量：");
        JLabel craftAntiHeat = new JLabel("零件抗热：");
        maxDamageLabel.setForeground(Color.white);
        craftAntiHeat.setForeground(Color.white);
        maxDamageLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        craftAntiHeat.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JTextField maxDamageNumber = new JTextField();
        JTextField craftAntiHeatNumber = new JTextField();
        maxDamageNumber.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        craftAntiHeatNumber.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        maxDamageNumber.setForeground(Color.white);
        craftAntiHeatNumber.setForeground(Color.white);
        maxDamageNumber.setPreferredSize(new Dimension(110, 25));
        maxDamageNumber.setHorizontalAlignment(SwingConstants.CENTER);
        maxDamageNumber.setBackground(new Color(43, 54, 70));
        craftAntiHeatNumber.setPreferredSize(new Dimension(110, 25));
        craftAntiHeatNumber.setHorizontalAlignment(SwingConstants.CENTER);
        craftAntiHeatNumber.setBackground(new Color(43, 54, 70));

        defendInputPanel.add(maxDamageLabel);
        defendInputPanel.add(maxDamageNumber);
        defendInputPanel.add(craftAntiHeat);
        defendInputPanel.add(craftAntiHeatNumber);

        // 确定按钮及监听
        JButton defendButton = new JButton("确定");
        defendButton.setPreferredSize(new Dimension(100, 45));
        defendButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        defendButton.setBackground(new Color(29, 33, 39));
        defendButton.setForeground(Color.white);
        defendButton.setFocusPainted(false);
        defendButton.setOpaque(true);
        defendButton.setBorderPainted(false);
        defendButton.addActionListener(click -> {
            if (maxDamageNumber.getText().equals("") && craftAntiHeatNumber.getText().equals("")) {
                System.out.println("你得输入些什么");
                //错误提示框
                JOptionPane.showMessageDialog(null, "你必须修改其中一项！", "错误", JOptionPane.OK_OPTION);
            } else {
                try {
                    new GeneralDefense(inputFileName.getText(), maxDamageNumber.getText(), craftAntiHeatNumber.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            frame.setTitle(titleEditName);
        });

        // 使用说明及监听
        JButton defendHelpButton = new JButton("使用说明");
        defendHelpButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        defendHelpButton.setForeground(Color.white);
        defendHelpButton.setBackground(null);
        defendHelpButton.setFocusPainted(false);
        defendHelpButton.setBorderPainted(false);
        defendHelpButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "零件血量对应Config节点中的maxDamage属性，指代零件的最大血量"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "例如新版发动机加入耐久设定后如不修改发动机默认的maxDamage"
                            + "\r\n" +
                            "在发动机启动后maxDamage到达临界值将发生爆炸"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "零件抗热对应Tinker Panel中的Heat Shield滑条的值"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "如需还原默认值请输入”DEFAULT“"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "如需要保持原文件的设定值请留空，不要在输入框内填写任何内容"
                    , "请仔细阅读使用说明", JOptionPane.PLAIN_MESSAGE);    //消息对话框
        });

        craftDefendPanel.add(cDefendTitle);
        craftDefendPanel.add(cDefendLabel);
        craftDefendPanel.add(defendInputPanel);
        craftDefendPanel.add(defendButton);
        craftDefendPanel.add(defendHelpButton);

        // 全局外观面板
        JPanel generalExterior = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        generalExterior.setPreferredSize(new Dimension(235, 350));
        generalExterior.setBackground(new Color(51, 63, 80));
        JLabel cExteriorTitle = new JLabel("存档外观设置");
        cExteriorTitle.setFont(new Font("微软雅黑", Font.BOLD, 22));
        cExteriorTitle.setForeground(Color.white);

        JLabel cExteriorLabel = new JLabel("请选择一个功能：");
        cExteriorLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        cExteriorLabel.setForeground(Color.white);
        // 控件面板
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        btnPanel.setPreferredSize(new Dimension(230, 150));
        btnPanel.setBackground(null);
        JLabel preventDebrisLabel = new JLabel("碎片化零件保留：");
        JLabel transparencySupportLabel = new JLabel("零件支持透明化：");
        JLabel shadowLabel = new JLabel("零件产生阴影：");
        shadowLabel.setPreferredSize(new Dimension(112,30));
        JLabel textureRemovalLabel = new JLabel("油箱纹理清除：");

        preventDebrisLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        transparencySupportLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        shadowLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        textureRemovalLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        preventDebrisLabel.setForeground(Color.white);
        transparencySupportLabel.setForeground(Color.white);
        shadowLabel.setForeground(Color.white);
        textureRemovalLabel.setForeground(Color.white);
        // 下拉列表选项
        // 零件碎片化
        JComboBox preventDebrisList = new JComboBox();
        preventDebrisList.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        preventDebrisList.addItem("关");
        preventDebrisList.addItem("开");
        preventDebrisList.addItem("不更改");
        // 零件透明化
        JComboBox transparencySupportList = new JComboBox();
        transparencySupportList.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        transparencySupportList.addItem("开");
        transparencySupportList.addItem("关");
        transparencySupportList.addItem("不更改");
        // 清除油箱纹理
        JCheckBox textureRemovalButton = new JCheckBox();
        textureRemovalButton.setBackground(null);
        // 零件阴影
        JComboBox shadowList = new JComboBox();
        shadowList.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        shadowList.addItem("开");
        shadowList.addItem("关");
        shadowList.addItem("不更改");


        btnPanel.add(preventDebrisLabel);
        btnPanel.add(preventDebrisList);
        btnPanel.add(transparencySupportLabel);
        btnPanel.add(transparencySupportList);
        btnPanel.add(shadowLabel);
        btnPanel.add(shadowList);
        btnPanel.add(textureRemovalLabel);
        btnPanel.add(textureRemovalButton);

        // 确定按钮及监听
        JButton exteriorButton = new JButton("确定");
        exteriorButton.setPreferredSize(new Dimension(100, 45));
        exteriorButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        exteriorButton.setBackground(new Color(29, 33, 39));
        exteriorButton.setForeground(Color.white);
        exteriorButton.setFocusPainted(false);
        exteriorButton.setOpaque(true);
        exteriorButton.setBorderPainted(false);
        exteriorButton.addActionListener(click -> {

            if (preventDebrisList.getSelectedItem().equals("不更改")
                    &&
                    transparencySupportList.getSelectedItem().equals("不更改")
                    &&
                    !textureRemovalButton.isSelected()
                    &&
                    shadowList.getSelectedItem().equals("不更改")
            ) {
                //错误提示框
                JOptionPane.showMessageDialog(null, "你必须修改些选项", "错误", JOptionPane.OK_OPTION);
            } else {
                new GeneralExterior(inputFileName.getText(),
                        (String) preventDebrisList.getSelectedItem(),
                        (String) transparencySupportList.getSelectedItem(),
                        String.valueOf(textureRemovalButton.isSelected()),
                        (String) shadowList.getSelectedItem()
                );
                frame.setTitle(titleEditName);
            }

        });

        // 使用说明及监听
        JButton exteriorHelpButton = new JButton("使用说明");
        exteriorHelpButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        exteriorHelpButton.setForeground(Color.white);
        exteriorHelpButton.setBackground(null);
        exteriorHelpButton.setFocusPainted(false);
        exteriorHelpButton.setBorderPainted(false);
        exteriorHelpButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "碎片化零件保留对应Tinker Panel中的Prevent Debris开关"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "零件支持透明化对应Tinker Panel中的Supports Transparency开关"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "油箱纹理清除只会把所有油箱的Texture设为None，不修改其他零件"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "零件产生阴影对应Tinker Panel中的Cast Shadows开关"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "注意："
                            + "\r\n" +
                            "如需还原默认值请在对应的下拉列表中选择”不更改选项“或取勾复选框"
                    , "请仔细阅读使用说明", JOptionPane.PLAIN_MESSAGE);    //消息对话框
        });

        generalExterior.add(cExteriorTitle);
        generalExterior.add(cExteriorLabel);
        generalExterior.add(btnPanel);
        generalExterior.add(exteriorButton);
        generalExterior.add(exteriorHelpButton);

        // 其他功能面板
        JPanel otherItem = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        otherItem.setPreferredSize(new Dimension(235, 350));
        otherItem.setBackground(new Color(51, 63, 80));
        JLabel otherItemTitle = new JLabel("存档其他属性");
        otherItemTitle.setFont(new Font("微软雅黑", Font.BOLD, 22));
        otherItemTitle.setForeground(Color.white);

        JLabel otherItemLabel = new JLabel("请选择一个功能：");
        otherItemLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        otherItemLabel.setForeground(Color.white);
        // 控件面板
        JPanel otherPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        otherPanel.setPreferredSize(new Dimension(200, 140));
        otherPanel.setBackground(null);
        JLabel colorBlockLabel = new JLabel("添加颜色格子：");
        colorBlockLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        colorBlockLabel.setForeground(Color.white);

        JLabel inertiaTensorLabel = new JLabel("惯性张量：");
        inertiaTensorLabel.setPreferredSize(new Dimension(98, 25));
        inertiaTensorLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        inertiaTensorLabel.setForeground(Color.white);

        JLabel fuelLineLabel = new JLabel("零件燃料管道：");
        fuelLineLabel.setPreferredSize(new Dimension(100,30));
        fuelLineLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        fuelLineLabel.setForeground(Color.white);

        JTextField colorBlockNumber = new JTextField();
        colorBlockNumber.setPreferredSize(new Dimension(100, 25));
        colorBlockNumber.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        colorBlockNumber.setBackground(new Color(43, 54, 70));
        colorBlockNumber.setHorizontalAlignment(SwingConstants.CENTER);
        colorBlockNumber.setForeground(Color.white);

        JTextField inertiaTensorNumber = new JTextField();
        inertiaTensorNumber.setPreferredSize(new Dimension(100, 25));
        inertiaTensorNumber.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        inertiaTensorNumber.setBackground(new Color(43, 54, 70));
        inertiaTensorNumber.setHorizontalAlignment(SwingConstants.CENTER);
        inertiaTensorNumber.setForeground(Color.white);

        JComboBox fuelLineList = new JComboBox();
        fuelLineList.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        fuelLineList.addItem("关闭");
        fuelLineList.addItem("开启");
        fuelLineList.addItem("不更改");

        otherPanel.add(colorBlockLabel);
        otherPanel.add(colorBlockNumber);
        otherPanel.add(inertiaTensorLabel);
        otherPanel.add(inertiaTensorNumber);
        otherPanel.add(fuelLineLabel);
        otherPanel.add(fuelLineList);

        // 确定按钮及监听
        JButton otherButton = new JButton("确定");
        otherButton.setPreferredSize(new Dimension(100, 45));
        otherButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        otherButton.setBackground(new Color(29, 33, 39));
        otherButton.setForeground(Color.white);
        otherButton.setFocusPainted(false);
        otherButton.setOpaque(true);
        otherButton.setBorderPainted(false);
        otherButton.addActionListener(click -> {
            if (colorBlockNumber.getText().equals("") && inertiaTensorNumber.getText().equals("") && fuelLineList.getSelectedItem().equals("不更改")) {
                //错误提示框
                JOptionPane.showMessageDialog(null, "你必须得修改些什么", "错误", JOptionPane.OK_OPTION);
            } else {
                new OtherItem(inputFileName.getText(), colorBlockNumber.getText(), inertiaTensorNumber.getText(), (String) fuelLineList.getSelectedItem());
            }
            frame.setTitle(titleEditName);
        });

        JButton otherHelpButton = new JButton("使用说明");
        otherHelpButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        otherHelpButton.setForeground(Color.white);
        otherHelpButton.setBackground(null);
        otherHelpButton.setFocusPainted(false);
        otherHelpButton.setBorderPainted(false);
        otherHelpButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "添加颜色格子对应Paint Tool工具中颜色格子的数量"
                            + "\r\n" +
                            "当前v0.9.906版本所支持的最大上限数量是50个格子"
                            + "\r\n" +
                            "默认情况下只有25个，也就是只能增加25个，多余的将不会生效"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "惯性张量对应零件中Config节点的inertiaTensorUserScale属性和曾经存在的Stability Modifier滑条"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "零件燃料管道对应Advanced Part Settings中的Fuel Line开关"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "注意！"
                            + "\r\n" +
                            "如需还原默认值请在输入框输入”DEFAULT“，以及将下拉列表设为”不更改“选项"
                    , "请仔细阅读使用说明", JOptionPane.PLAIN_MESSAGE);    //消息对话框
        });

        otherItem.add(otherItemTitle);
        otherItem.add(otherItemLabel);
        otherItem.add(otherPanel);
        otherItem.add(otherButton);
        otherItem.add(otherHelpButton);

        // 右侧功能面板载入
        craftResziePanel.setVisible(false);
        craftCollisionPanel.setVisible(false);
        craftDragPanel.setVisible(false);
        craftDefendPanel.setVisible(false);
        generalExterior.setVisible(false);
        otherItem.setVisible(false);
        rightPanel.add(craftResziePanel);
        rightPanel.add(craftCollisionPanel);
        rightPanel.add(craftDragPanel);
        rightPanel.add(craftDefendPanel);
        rightPanel.add(generalExterior);
        rightPanel.add(otherItem);

        verticalPanel.add(listMenu);
        universalPanel.add(verticalPanel);
        universalPanel.add(rightPanel);

        // 按钮面板对应的监听器
        reStart.addActionListener(e -> {
            appPanel.setVisible(true);
            menuPanel.setVisible(false);
            universalPanel.setVisible(false);
            bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));
        });
        craftReszie.addActionListener(e -> {
            menuPanel.setVisible(false);
            universalPanel.setVisible(true);
            craftResziePanel.setVisible(true);
            bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 22));
            rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        });
        craftCollision.addActionListener(e -> {
            menuPanel.setVisible(false);
            craftResziePanel.setVisible(false);
            universalPanel.setVisible(true);
            craftCollisionPanel.setVisible(true);
            rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
            bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 22));
        });
        craftDrag.addActionListener(e -> {
            menuPanel.setVisible(false);
            craftResziePanel.setVisible(false);
            craftCollisionPanel.setVisible(false);
            universalPanel.setVisible(true);
            craftDragPanel.setVisible(true);
            rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
            bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 22));
        });
        craftResistances.addActionListener(e -> {
            menuPanel.setVisible(false);
            craftResziePanel.setVisible(false);
            craftCollisionPanel.setVisible(false);
            craftDragPanel.setVisible(false);
            universalPanel.setVisible(true);
            craftDefendPanel.setVisible(true);
            rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
            bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 22));
        });
        craftAppearance.addActionListener(e -> {
            menuPanel.setVisible(false);
            craftResziePanel.setVisible(false);
            craftCollisionPanel.setVisible(false);
            craftDragPanel.setVisible(false);
            craftDefendPanel.setVisible(false);
            universalPanel.setVisible(true);
            generalExterior.setVisible(true);
            rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
            bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 22));
        });
        otherProperties.addActionListener(e -> {
            menuPanel.setVisible(false);
            craftResziePanel.setVisible(false);
            craftCollisionPanel.setVisible(false);
            craftDragPanel.setVisible(false);
            craftDefendPanel.setVisible(false);
            generalExterior.setVisible(false);
            universalPanel.setVisible(true);
            otherItem.setVisible(true);
            rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
            bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 22));
        });

        // 确认按钮的监听器
        indexButton.addActionListener(click -> {
            /*appPanel.setVisible(false);
            menuPanel.setVisible(true);
            bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));*/

            File ifFile = new File(filePath + inputFileName.getText() + ".xml");
            if (ifFile.exists()) {
                appPanel.setVisible(false);
                menuPanel.setVisible(true);

                bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 36));
            } else {
                System.out.println("文件不存在");
                //错误提示框
                JOptionPane.showMessageDialog(null, "指定的文件不存在", "错误", JOptionPane.OK_OPTION);
            }
        });

        bodyPanel.add(appPanel);
        bodyPanel.add(menuPanel);
        bodyPanel.add(universalPanel);

        panel.add(logoPanel);
        panel.add(horizontalLine);
        panel.add(bodyPanel);
        panel.add(footerPanel);

        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
