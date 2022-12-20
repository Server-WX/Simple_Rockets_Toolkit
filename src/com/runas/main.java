package com.runas;

import com.infinity.util.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class main {

    public static void main(String[] args) {
        String titleName = "SR2 Toolkit";
        String titleEditName = titleName + " " + "— Property Modified Successfully";
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

        JLabel titleText = new JLabel("Please Type In The File Name");
        titleText.setFont(new Font("微软雅黑", Font.BOLD, 22));
        titleText.setForeground(Color.white);

        JTextField inputFileName = new JTextField(); // 文件名输入框
        inputFileName.setPreferredSize(new Dimension(150, 30));
        inputFileName.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        inputFileName.setForeground(Color.white);
        inputFileName.setBackground(new Color(43, 54, 70));
        inputFileName.setHorizontalAlignment(SwingConstants.CENTER);
        inputFileName.requestFocus();

        JButton indexButton = new JButton("Apply");
        indexButton.setPreferredSize(new Dimension(100, 45));
        indexButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        indexButton.setBackground(new Color(29, 33, 39));
        indexButton.setOpaque(true);
        indexButton.setForeground(Color.white);
        indexButton.setFocusPainted(false);
        indexButton.setBorderPainted(false);

        JButton indexHelperButton = new JButton("Instructions");
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
                    "Fill your file's name (without the .xml suffix) into the box"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "If report errors,your file name may be wrong"
                    , "Please Read the Instructions Carefully", JOptionPane.PLAIN_MESSAGE);    //消息对话框
        });


        // 菜单面板
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 10));
        menuPanel.setVisible(false);

        menuPanel.setPreferredSize(new Dimension(410, 355));
        menuPanel.setBackground(new Color(51, 63, 80));
        JLabel menuText = new JLabel("Functions");
        menuText.setFont(new Font("微软雅黑", Font.PLAIN, 22));
        menuText.setForeground(Color.white);
        // 按钮面板
        JPanel menuButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        menuButtonPanel.setPreferredSize(new Dimension(160, 250));
        menuButtonPanel.setBackground(null);
        // 功能列表的按钮声明
        JButton reStart = new JButton("Back to select file");
        JButton craftReszie = new JButton("Craft Resizer");
        JButton craftCollision = new JButton("Craft Collisions");
        JButton craftDrag = new JButton("Craft Drag");
        JButton craftResistances = new JButton("Craft Resistance");
        JButton craftAppearance = new JButton("Craft Appearance");
        JButton otherProperties = new JButton("Other Properties");
        // 按钮样式设定
        reStart.setPreferredSize(new Dimension(180, 30));
        reStart.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        reStart.setBackground(new Color(43, 54, 70));
        reStart.setFocusPainted(false);
        reStart.setForeground(Color.white);
        reStart.setOpaque(true);
        reStart.setBorderPainted(false);

        craftReszie.setPreferredSize(new Dimension(180, 30));
        craftReszie.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        craftReszie.setBackground(new Color(43, 54, 70));
        craftReszie.setFocusPainted(false);
        craftReszie.setForeground(Color.white);
        craftReszie.setOpaque(true);
        craftReszie.setBorderPainted(false);

        craftCollision.setPreferredSize(new Dimension(180, 30));
        craftCollision.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        craftCollision.setBackground(new Color(43, 54, 70));
        craftCollision.setFocusPainted(false);
        craftCollision.setForeground(Color.white);
        craftCollision.setOpaque(true);
        craftCollision.setBorderPainted(false);

        craftDrag.setPreferredSize(new Dimension(180, 30));
        craftDrag.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        craftDrag.setBackground(new Color(43, 54, 70));
        craftDrag.setFocusPainted(false);
        craftDrag.setForeground(Color.white);
        craftDrag.setOpaque(true);
        craftDrag.setBorderPainted(false);

        craftResistances.setPreferredSize(new Dimension(180, 30));
        craftResistances.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        craftResistances.setBackground(new Color(43, 54, 70));
        craftResistances.setFocusPainted(false);
        craftResistances.setForeground(Color.white);
        craftResistances.setOpaque(true);
        craftResistances.setBorderPainted(false);

        craftAppearance.setPreferredSize(new Dimension(180, 30));
        craftAppearance.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        craftAppearance.setBackground(new Color(43, 54, 70));
        craftAppearance.setFocusPainted(false);
        craftAppearance.setForeground(Color.white);
        craftAppearance.setOpaque(true);
        craftAppearance.setBorderPainted(false);

        otherProperties.setPreferredSize(new Dimension(180, 30));
        otherProperties.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        otherProperties.setBackground(new Color(43, 54, 70));
        otherProperties.setFocusPainted(false);
        otherProperties.setForeground(Color.white);
        otherProperties.setOpaque(true);
        otherProperties.setBorderPainted(false);

        // 帮助按钮
        JButton menuHelp = new JButton("Instructions");
        menuHelp.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        menuHelp.setBackground(new Color(43, 54, 70));
        menuHelp.setFocusPainted(false);
        menuHelp.setForeground(Color.white);
        menuHelp.setOpaque(true);
        menuHelp.setBorderPainted(false);
        // 帮助按钮监听
        menuHelp.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "The ”Craft Resizer“ includes the zooming of the size and the mass of your craft."
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The “Craft Collisions“ includes the settings of part collisions and the collision response."
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The “Craft Drag” includes the switch of the drag and the modification of the value of drag scale."
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The ”Craft Resistance“ is for modify the part health amd the part heat resistance."
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The ”Craft Appearance“ is for modify the transparency, shadows,fuel tanks' textures and the debris settings of your craft."
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The ”Other Properties“ has the settings of Inertia tensor, parts' fuel lines and the count of the painting checks."
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "Attention: You can only modify once a file-name's input!"
                            + "\r\n" +
                            "If you need multiple modifications, press “Back to select file” and change to the new file name to continue!"
                    , "Please Read the Instructions Carefully", JOptionPane.PLAIN_MESSAGE);    //消息对话框
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
        listMenu.setPreferredSize(new Dimension(180, 210));
        listMenu.setBackground(null);

        // 菜单按钮
        JButton changeFunction = new JButton("Back Functions Menu");
        changeFunction.setPreferredSize(new Dimension(180, 35));
        changeFunction.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        changeFunction.setForeground(Color.white);
        changeFunction.setBackground(new Color(43, 54, 70));
        changeFunction.setFocusPainted(false);
        changeFunction.setOpaque(true);
        changeFunction.setBorderPainted(false);
        changeFunction.addActionListener(click -> {
            menuPanel.setVisible(true);
            universalPanel.setVisible(false);
            bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 36));
            frame.setTitle(titleName);
        });

        JButton changeFile = new JButton("Change File");
        changeFile.setPreferredSize(new Dimension(180, 35));
        changeFile.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        changeFile.setForeground(Color.white);
        changeFile.setBackground(new Color(43, 54, 70));
        changeFile.setFocusPainted(false);
        changeFile.setOpaque(true);
        changeFile.setBorderPainted(false);
        changeFile.addActionListener(click -> {
            appPanel.setVisible(true);
            menuPanel.setVisible(false);
            universalPanel.setVisible(false);
            bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));
            frame.setTitle(titleName);
        });

        JButton officialWebsite = new JButton("SR2 Website");
        officialWebsite.setPreferredSize(new Dimension(180, 35));
        officialWebsite.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        officialWebsite.setForeground(Color.white);
        officialWebsite.setBackground(new Color(43, 54, 70));
        officialWebsite.setFocusPainted(false);
        officialWebsite.setOpaque(true);
        officialWebsite.setBorderPainted(false);
        officialWebsite.addActionListener(click -> new LinkWeb(new String[]{"https://www.simplerockets.com/"}));

        JButton authorProfile = new JButton("Author");
        authorProfile.setPreferredSize(new Dimension(180, 35));
        authorProfile.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        authorProfile.setForeground(Color.white);
        authorProfile.setBackground(new Color(43, 54, 70));
        authorProfile.setFocusPainted(false);
        authorProfile.setOpaque(true);
        authorProfile.setBorderPainted(false);
        authorProfile.addActionListener(click -> new LinkWeb(new String[]{"https://www.simplerockets.com/u/JasonCaesar007"}));

        JButton studioFansChat = new JButton("Studio Fans' Group");
        studioFansChat.setPreferredSize(new Dimension(180, 35));
        studioFansChat.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        studioFansChat.setForeground(Color.white);
        studioFansChat.setBackground(new Color(43, 54, 70));
        studioFansChat.setFocusPainted(false);
        studioFansChat.setOpaque(true);
        studioFansChat.setBorderPainted(false);
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
        JLabel cResizeTitleLabel = new JLabel("Totally Craft Resize");
        cResizeTitleLabel.setFont(new Font("微软雅黑", Font.BOLD, 22));
        cResizeTitleLabel.setForeground(Color.white);

        JLabel resizeLabel = new JLabel("Part Size Multiple:");
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
        JRadioButton toWidth = new JRadioButton("Only For Diameter", true);
        JRadioButton toScale = new JRadioButton("Only For Size");
        toWidth.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        toScale.setFont(new Font("微软雅黑", Font.PLAIN, 12));
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
        JLabel massLabel = new JLabel("Mass Scale Multiple");
        massLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        massLabel.setForeground(Color.white);
        JTextField massNumber = new JTextField();
        massNumber.setPreferredSize(new Dimension(150, 30));
        massNumber.setBackground(new Color(43, 54, 70));
        massNumber.setHorizontalAlignment(SwingConstants.CENTER);
        massNumber.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        massNumber.setForeground(Color.white);

        // Apply按钮及监听器
        JButton resizeButton = new JButton("Apply");
        resizeButton.setPreferredSize(new Dimension(100, 45));
        resizeButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        resizeButton.setBackground(new Color(29, 33, 39));
        resizeButton.setForeground(Color.white);
        resizeButton.setFocusPainted(false);
        resizeButton.setOpaque(true);
        resizeButton.setBorderPainted(false);
        resizeButton.addActionListener(click -> {
            CraftResize cr = new CraftResize();

            if (!resizeNumber.getText().equals("")) {
                if (cr.craftResizeTool(inputFileName.getText(), resizeNumber.getText(), toWidth.isSelected())) {
                    //Error提示框
                    JOptionPane.showMessageDialog(null, "Wrong Multiple Data.", "Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "You Didn't Input Anything Yet.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            frame.setTitle(titleEditName);
        });

        // 帮助按钮及监听
        JButton resizeHelpButton = new JButton("Instructions");
        resizeHelpButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        resizeHelpButton.setForeground(Color.white);
        resizeHelpButton.setBackground(null);
        resizeHelpButton.setFocusPainted(false);
        resizeHelpButton.setBorderPainted(false);
        resizeHelpButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "The Part Scale and the Mass Scale below cannot be used at the same time."
                            + "\r\n" +
                            "You can only modify one of them once a time, and then select the craft file again for secondary modification!"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The first box is the resizer box, for resize the total size of your craft."
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "You Can ONLY type in Positive Numbers instead of Negatives, for example:"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "To enlarge the craft to 200%, enter number 2, to narrow it to 20%, enter 0.2"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "Check the “Only For Diameter“ will modify the Width,Depth and other properties."
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "Check the ”Only For Size” will modify the Part Scale in the Tinker Panel."
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The Second Box is for resize the Mass Scale of all the parts from your craft."
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "If input 2, it will set the Mass Scale to 200%, if 0.2 then it will be 20%, and so on."
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "If you need to retain the customary property, Don't Type Anything into it."
                            + "\r\n" +
                            "If You need to turn the Mass back To Default , Type “DEFAULT“ into the box."
                    , "Please Read the Instructions Carefully", JOptionPane.PLAIN_MESSAGE);    //消息对话框
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
        JLabel cCollisionTitle = new JLabel("Craft Collisions");
        cCollisionTitle.setFont(new Font("微软雅黑", Font.BOLD, 22));
        cCollisionTitle.setForeground(Color.white);

        JLabel cCollisionLabel = new JLabel("Select A Mode：");
        cCollisionLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        cCollisionLabel.setForeground(Color.white);

        // 下拉列表面板
        JPanel comboBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        comboBoxPanel.setPreferredSize(new Dimension(235, 100));
        comboBoxPanel.setBackground(null);
        JLabel collisionModel = new JLabel("Part Collision：");
        JLabel collisionResponseModel = new JLabel("Collision Response：");
        collisionModel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        collisionResponseModel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        collisionModel.setPreferredSize(new Dimension(130, 30));
        collisionModel.setForeground(Color.white);
        collisionResponseModel.setForeground(Color.white);
        // 添加列表框
        JComboBox cModel = new JComboBox();
        cModel.setFont(new Font("微软雅黑", Font.PLAIN, 11));
        cModel.setPreferredSize(new Dimension(90, 20));
        cModel.addItem("Default");
        cModel.addItem("Always");
        cModel.addItem("Never");
        cModel.addItem("No Edit");
        JComboBox crModel = new JComboBox();
        crModel.setFont(new Font("微软雅黑", Font.PLAIN, 11));
        crModel.setPreferredSize(new Dimension(90, 20));
        crModel.addItem("Default");
        crModel.addItem("None");
        crModel.addItem("DisOnly");
        crModel.addItem("No Edit");

        comboBoxPanel.add(collisionModel);
        comboBoxPanel.add(cModel);
        comboBoxPanel.add(collisionResponseModel);
        comboBoxPanel.add(crModel);

        // Apply按钮及监听
        JButton collisionButton = new JButton("Apply");
        collisionButton.setPreferredSize(new Dimension(100, 45));
        collisionButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        collisionButton.setBackground(new Color(29, 33, 39));
        collisionButton.setForeground(Color.white);
        collisionButton.setFocusPainted(false);
        collisionButton.setOpaque(true);
        collisionButton.setBorderPainted(false);
        collisionButton.addActionListener(click -> {
            if (cModel.getSelectedItem().equals("Default") && crModel.getSelectedItem().equals("Default")) {
                //Error提示框
                JOptionPane.showMessageDialog(null, "You MUST choose one of them!", "Error", JOptionPane.OK_OPTION);
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
        JButton collisionHelpButton = new JButton("Instructions");
        collisionHelpButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        collisionHelpButton.setForeground(Color.white);
        collisionHelpButton.setBackground(null);
        collisionHelpButton.setFocusPainted(false);
        collisionHelpButton.setBorderPainted(false);
        collisionHelpButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "Tap the button near the text will get the list to choose."
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The ”Part Collision” mode is corresponding the “Part Collision“ in the Tinker Panel in Game"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The ”Collision Response” mode is corresponding the “Collision Response“ in the Tinker Panel in Game"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The ”DisOnly”mode is corresponding the “DisconnectOnly“ in Game"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "You need to select the ”No Edit“ button  if you don't want to modify the property"
                    , "Please Read the Instructions Carefully", JOptionPane.PLAIN_MESSAGE);    //消息对话框

        });


        craftCollisionPanel.add(cCollisionTitle);
        craftCollisionPanel.add(cCollisionLabel);
        craftCollisionPanel.add(comboBoxPanel);
        craftCollisionPanel.add(collisionButton);
        craftCollisionPanel.add(collisionHelpButton);

        // 全局阻力面板
        JPanel craftDragPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 15));
        craftDragPanel.setPreferredSize(new Dimension(235, 350));
        craftDragPanel.setBackground(new Color(51, 63, 80));
        JLabel cDragTitle = new JLabel("Craft Drag");
        cDragTitle.setFont(new Font("微软雅黑", Font.BOLD, 22));
        cDragTitle.setForeground(Color.white);

        JLabel cDragLabel = new JLabel("Type OR Select ：");
        cDragLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        cDragLabel.setForeground(Color.white);
        // 输入框与按钮面板
        JPanel airDragPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        airDragPanel.setBackground(null);
        airDragPanel.setPreferredSize(new Dimension(220, 110));
        JLabel airNumberLabel = new JLabel("Drag Multiple：");
        airNumberLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        airNumberLabel.setForeground(Color.white);
        JTextField airNumber = new JTextField();
        airNumber.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        airNumber.setPreferredSize(new Dimension(100, 25));
        airNumber.setHorizontalAlignment(SwingConstants.CENTER);
        airNumber.setBackground(new Color(43, 54, 70));
        airNumber.setForeground(Color.white);

        JLabel airDragToggleLabel = new JLabel("Include In Drag：");
        airDragToggleLabel.setPreferredSize(new Dimension(130, 30));
        airDragToggleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        airDragToggleLabel.setForeground(Color.white);

        JComboBox dragButton = new JComboBox();
        dragButton.setPreferredSize(new Dimension(70, 20));
        dragButton.addItem("ON");
        dragButton.addItem("OFF");
        dragButton.addItem("No Edit");
        dragButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));


        airDragPanel.add(airNumberLabel);
        airDragPanel.add(airNumber);
        airDragPanel.add(airDragToggleLabel);
        airDragPanel.add(dragButton);

        // 确认按钮及监听
        JButton airDragButton = new JButton("Apply");
        airDragButton.setPreferredSize(new Dimension(100, 45));
        airDragButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        airDragButton.setBackground(new Color(29, 33, 39));
        airDragButton.setForeground(Color.white);
        airDragButton.setFocusPainted(false);
        airDragButton.setOpaque(true);
        airDragButton.setBorderPainted(false);
        airDragButton.addActionListener(click -> {
            if (airNumber.getText().equals("") && dragButton.getSelectedItem().equals("No Edit")) {
                //Error提示框
                JOptionPane.showMessageDialog(null, "You MUST choose one of them!", "Error", JOptionPane.OK_OPTION);
            } else {
                try {
                    new GeneralDrag(inputFileName.getText(), (String) dragButton.getSelectedItem(), airNumber.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            frame.setTitle(titleEditName);
        });

        JButton dragHelpButton = new JButton("Instructions");
        dragHelpButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        dragHelpButton.setForeground(Color.white);
        dragHelpButton.setBackground(null);
        dragHelpButton.setFocusPainted(false);
        dragHelpButton.setBorderPainted(false);
        dragHelpButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "This function is for setting the total drag properties of your craft"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "If You need to turn the Drag Scale back To Default , Type ”DEFAULT” into the box"
                    , "Please Read the Instructions Carefully", JOptionPane.PLAIN_MESSAGE);    //消息对话框
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
        JLabel cDefendTitle = new JLabel("Craft Resistance");
        cDefendTitle.setFont(new Font("微软雅黑", Font.BOLD, 22));
        cDefendTitle.setForeground(Color.white);

        JLabel cDefendLabel = new JLabel("Type OR Select：");
        cDefendLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        cDefendLabel.setForeground(Color.white);
        // 输入框面板
        JPanel defendInputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        defendInputPanel.setBackground(null);
        defendInputPanel.setPreferredSize(new Dimension(215, 110));
        JLabel maxDamageLabel = new JLabel("Part Health：");
        JLabel craftAntiHeat = new JLabel("Part Heat Resist：");
        maxDamageLabel.setForeground(Color.white);
        craftAntiHeat.setForeground(Color.white);
        maxDamageLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        craftAntiHeat.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        JTextField maxDamageNumber = new JTextField();
        JTextField craftAntiHeatNumber = new JTextField();
        maxDamageNumber.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        craftAntiHeatNumber.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        maxDamageNumber.setForeground(Color.white);
        craftAntiHeatNumber.setForeground(Color.white);
        maxDamageNumber.setPreferredSize(new Dimension(110, 25));
        maxDamageNumber.setHorizontalAlignment(SwingConstants.CENTER);
        maxDamageNumber.setBackground(new Color(43, 54, 70));
        craftAntiHeatNumber.setPreferredSize(new Dimension(90, 25));
        craftAntiHeatNumber.setHorizontalAlignment(SwingConstants.CENTER);
        craftAntiHeatNumber.setBackground(new Color(43, 54, 70));

        defendInputPanel.add(maxDamageLabel);
        defendInputPanel.add(maxDamageNumber);
        defendInputPanel.add(craftAntiHeat);
        defendInputPanel.add(craftAntiHeatNumber);

        // Apply按钮及监听
        JButton defendButton = new JButton("Apply");
        defendButton.setPreferredSize(new Dimension(100, 45));
        defendButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        defendButton.setBackground(new Color(29, 33, 39));
        defendButton.setForeground(Color.white);
        defendButton.setFocusPainted(false);
        defendButton.setBorderPainted(false);
        defendButton.setOpaque(true);
        defendButton.addActionListener(click -> {
            if (maxDamageNumber.getText().equals("") && craftAntiHeatNumber.getText().equals("")) {
                //Error提示框
                JOptionPane.showMessageDialog(null, "You MUST choose one of them!", "Error", JOptionPane.OK_OPTION);
            } else {
                try {
                    new GeneralDefense(inputFileName.getText(), maxDamageNumber.getText(), craftAntiHeatNumber.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            frame.setTitle(titleEditName);
        });

        // Instructions及监听
        JButton defendHelpButton = new JButton("Instructions");
        defendHelpButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        defendHelpButton.setForeground(Color.white);
        defendHelpButton.setBackground(null);
        defendHelpButton.setFocusPainted(false);
        defendHelpButton.setBorderPainted(false);
        defendHelpButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "The “Part Health“ is corresponding the ”max Damage” in Overload"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "For example,if we don't change the maxDamage of the rocket engines,they will explode when their damage goes to 100%"
                            + "\r\n" +
                            "The “Part Heat Resistance“ is corresponding the  “Heat Shield“ in Tinker Panel in Game"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "If You need to turn the value back To Default , Type ”DEFAULT” into the box"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "You needn't to type things if you don't want to modify the property"
                    , "Please Read the Instructions Carefully", JOptionPane.PLAIN_MESSAGE);    //消息对话框
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
        JLabel cExteriorTitle = new JLabel("Craft Appearance");
        cExteriorTitle.setFont(new Font("微软雅黑", Font.BOLD, 22));
        cExteriorTitle.setForeground(Color.white);

        JLabel cExteriorLabel = new JLabel("Select A Function：");
        cExteriorLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        cExteriorLabel.setForeground(Color.white);
        // 控件面板
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        btnPanel.setPreferredSize(new Dimension(230, 150));
        btnPanel.setBackground(null);
        JLabel preventDebrisLabel = new JLabel("Prevent Debris：");
        preventDebrisLabel.setPreferredSize(new Dimension(148, 30));
        JLabel transparencySupportLabel = new JLabel("Support Transparency：");
        JLabel shadowLabel = new JLabel("Shadow Casting：");
        shadowLabel.setPreferredSize(new Dimension(148, 30));
        JLabel textureRemovalLabel = new JLabel(" Fuel Tanks Texture Removal：");

        preventDebrisLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        transparencySupportLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        shadowLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textureRemovalLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        preventDebrisLabel.setForeground(Color.white);
        transparencySupportLabel.setForeground(Color.white);
        shadowLabel.setForeground(Color.white);
        textureRemovalLabel.setForeground(Color.white);
        // 下拉列表选项
        // 零件碎片化
        JComboBox preventDebrisList = new JComboBox();
        preventDebrisList.setPreferredSize(new Dimension(80, 20));
        preventDebrisList.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        preventDebrisList.addItem("OFF");
        preventDebrisList.addItem("ON");
        preventDebrisList.addItem("No Edit");
        // 零件透明化
        JComboBox transparencySupportList = new JComboBox();
        transparencySupportList.setPreferredSize(new Dimension(80, 20));
        transparencySupportList.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        transparencySupportList.addItem("ON");
        transparencySupportList.addItem("OFF");
        transparencySupportList.addItem("No Edit");
        // 清除油箱纹理
        JCheckBox textureRemovalButton = new JCheckBox();
        textureRemovalButton.setBackground(null);
        // 零件阴影
        JComboBox shadowList = new JComboBox();
        shadowList.setPreferredSize(new Dimension(80, 20));
        shadowList.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        shadowList.addItem("ON");
        shadowList.addItem("OFF");
        shadowList.addItem("No Edit");


        btnPanel.add(preventDebrisLabel);
        btnPanel.add(preventDebrisList);
        btnPanel.add(transparencySupportLabel);
        btnPanel.add(transparencySupportList);
        btnPanel.add(shadowLabel);
        btnPanel.add(shadowList);
        btnPanel.add(textureRemovalLabel);
        btnPanel.add(textureRemovalButton);

        // Apply按钮及监听
        JButton exteriorButton = new JButton("Apply");
        exteriorButton.setPreferredSize(new Dimension(100, 45));
        exteriorButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        exteriorButton.setBackground(new Color(29, 33, 39));
        exteriorButton.setForeground(Color.white);
        exteriorButton.setFocusPainted(false);
        exteriorButton.setBorderPainted(false);
        exteriorButton.setOpaque(true);
        exteriorButton.addActionListener(click -> {

            if (preventDebrisList.getSelectedItem().equals("OFF")
                    &&
                    transparencySupportList.getSelectedItem().equals("ON")
                    &&
                    !textureRemovalButton.isSelected()
                    &&
                    shadowList.getSelectedItem().equals("ON")
            ) {
                //Error提示框
                JOptionPane.showMessageDialog(null, "You MUST choose one of them!", "Error", JOptionPane.OK_OPTION);
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

        // Instructions及监听
        JButton exteriorHelpButton = new JButton("Instructions");
        exteriorHelpButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        exteriorHelpButton.setForeground(Color.white);
        exteriorHelpButton.setBackground(null);
        exteriorHelpButton.setFocusPainted(false);
        exteriorHelpButton.setBorderPainted(false);
        exteriorHelpButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "The ”Prevent Debris” is corresponding the  ”Prevent Debris” in Tinker Panel in Game"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The “Support Transparency“ is corresponding the  “Supports Transparency“ in Tinker Panel in Game"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The “Fuel Tanks' Texture Removal“ is to set the textures on the Fuel Tanks to none,it doesn't modify other properties or parts"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The “Shadow Casting“ is corresponding the  “Cast Shadows“ in Tinker Panel in Game"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "Attention:"
                            + "\r\n" +
                            "You need to select the “No Edit“ button if you don't want to modify the property"
                    , "Please Read the Instructions Carefully", JOptionPane.PLAIN_MESSAGE);    //消息对话框
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
        JLabel otherItemTitle = new JLabel("Other Properties");
        otherItemTitle.setFont(new Font("微软雅黑", Font.BOLD, 22));
        otherItemTitle.setForeground(Color.white);

        JLabel otherItemLabel = new JLabel("Select A Function：");
        otherItemLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        otherItemLabel.setForeground(Color.white);
        // 控件面板
        JPanel otherPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        otherPanel.setPreferredSize(new Dimension(235, 150));
        otherPanel.setBackground(null);
        JLabel colorBlockLabel = new JLabel("Add Paint Checks：");
        colorBlockLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        colorBlockLabel.setForeground(Color.white);

        JLabel inertiaTensorLabel = new JLabel("Inertia Tensor Scale：");
        inertiaTensorLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        inertiaTensorLabel.setForeground(Color.white);

        JLabel fuelLineLabel = new JLabel("Parts' Fuel Line：");
        fuelLineLabel.setPreferredSize(new Dimension(145, 30));
        fuelLineLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        fuelLineLabel.setForeground(Color.white);

        JTextField colorBlockNumber = new JTextField();
        colorBlockNumber.setPreferredSize(new Dimension(100, 25));
        colorBlockNumber.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        colorBlockNumber.setBackground(new Color(43, 54, 70));
        colorBlockNumber.setHorizontalAlignment(SwingConstants.CENTER);
        colorBlockNumber.setForeground(Color.white);

        JTextField inertiaTensorNumber = new JTextField();
        inertiaTensorNumber.setPreferredSize(new Dimension(87, 25));
        inertiaTensorNumber.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        inertiaTensorNumber.setBackground(new Color(43, 54, 70));
        inertiaTensorNumber.setHorizontalAlignment(SwingConstants.CENTER);
        inertiaTensorNumber.setForeground(Color.white);

        JComboBox fuelLineList = new JComboBox();
        fuelLineList.setPreferredSize(new Dimension(80, 20));
        fuelLineList.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        fuelLineList.addItem("OFF");
        fuelLineList.addItem("ON");
        fuelLineList.addItem("No Edit");

        otherPanel.add(colorBlockLabel);
        otherPanel.add(colorBlockNumber);
        otherPanel.add(inertiaTensorLabel);
        otherPanel.add(inertiaTensorNumber);
        otherPanel.add(fuelLineLabel);
        otherPanel.add(fuelLineList);

        // Apply按钮及监听
        JButton otherButton = new JButton("Apply");
        otherButton.setPreferredSize(new Dimension(100, 45));
        otherButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
        otherButton.setBackground(new Color(29, 33, 39));
        otherButton.setForeground(Color.white);
        otherButton.setFocusPainted(false);
        otherButton.setBorderPainted(false);
        otherButton.setOpaque(true);
        otherButton.addActionListener(click -> {
            if (colorBlockNumber.getText().equals("") && inertiaTensorNumber.getText().equals("") && fuelLineList.getSelectedItem().equals("OFF")) {
                //Error提示框
                JOptionPane.showMessageDialog(null, "You MUST choose one of them!", "Error", JOptionPane.OK_OPTION);
            } else {
                new OtherItem(inputFileName.getText(), colorBlockNumber.getText(), inertiaTensorNumber.getText(), (String) fuelLineList.getSelectedItem());
            }
            frame.setTitle(titleEditName);
        });

        JButton otherHelpButton = new JButton("Instructions");
        otherHelpButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        otherHelpButton.setForeground(Color.white);
        otherHelpButton.setBackground(null);
        otherHelpButton.setFocusPainted(false);
        otherHelpButton.setBorderPainted(false);
        otherHelpButton.addActionListener(click -> {
            JOptionPane.showMessageDialog(null,
                    "The ”Add Paint Checks”  is corresponding the painting tool in Game"
                            + "\r\n" +
                            "The maximum color count in the game is 50 checks (in the latest version)"
                            + "\r\n" +
                            "The Default count is 25, so you can only add extra 25 checks , more redundancy won't work"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The ”Inertia Tensor Scale” is corresponding the ”inertiaTensorUserScale” in Overload, also the hidden slider ”Stability Modifier” in Game"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "The ”Parts' Fuel Line”  is corresponding the switch called ”Fuel Line” in Game"
                            + "\r\n" +
                            " "
                            + "\r\n" +
                            "Attention!"
                            + "\r\n" +
                            "If You need to turn the value back To Default , Type “DEFAULT“ into the box,select the list to ”No Edit”"
                    , "Please Read the Instructions Carefully", JOptionPane.PLAIN_MESSAGE);    //消息对话框
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
                //Error提示框
                JOptionPane.showMessageDialog(null, "File Is Not Exist", "Error", JOptionPane.OK_OPTION);
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
