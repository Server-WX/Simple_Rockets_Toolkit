package com.infinity.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 整体缩放功能的工具类
 * 需传形参：文件名，缩放数值，缩放模式
 * <p>
 * 缩放模式为true时仅修改Part Scale的大小
 * 为false时仅修改Part Shape的尺寸
 */

public class CraftResize {

    private static final Pattern type = Pattern.compile("partType=\"(.*?)\"");
    private static final Pattern position = Pattern.compile("position=\"(.*?)\"");
    private static final Pattern partScale = Pattern.compile("partScale=\"(.*?)\"");
    private static final Pattern massScale = Pattern.compile("massScale=\"(.*?)\"");
    private static final Pattern bottomScale = Pattern.compile("bottomScale=\"(.*?)\"");
    private static final Pattern topScale = Pattern.compile("topScale=\"(.*?)\"");
    private static final Pattern offset = Pattern.compile("offset=\"(.*?)\"");
    private static final Pattern fuel = Pattern.compile("fuel=\"(.*?)\"");
    private static final Pattern capacity = Pattern.compile("capacity=\"(.*?)\"");
    private static final Pattern size = Pattern.compile("size=\"(.*?)\"");
    private static final Pattern scale = Pattern.compile("scale=\"(.*?)\"");
    private static final Pattern rootLeading = Pattern.compile("rootLeadingOffset=\"(.*?)\"");
    private static final Pattern rootTrailing = Pattern.compile("rootTrailingOffset=\"(.*?)\"");
    private static final Pattern tipLeading = Pattern.compile("tipLeadingOffset=\"(.*?)\"");
    private static final Pattern tipTrailing = Pattern.compile("tipTrailingOffset=\"(.*?)\"");
    private static final Pattern tipPosition = Pattern.compile("tipPosition=\"(.*?)\"");

    private static final ArrayList<String> resizableParts = new ArrayList<String>(Arrays.asList("CargoBay1",
            "Detacher1", "Fairing1", "FairingBase1", "FairingNoseCone1", "Fuselage1", "Gyroscope1", "HeatShield1",
            "Inlet1", "Fin1", "JetEngine1", "LandingGear1", "LandingLeg1", "NoseCone1", "Piston1", "RocketEngine1",
            "RoverWheel1", "Shock1", "SolarPanel1", "SolarPanelArray", "StructuralPanel1", "Strut1", "Wing1"));
    @SuppressWarnings("unused")
    private static final ArrayList<String> tinkerParts = new ArrayList<String>(
            Arrays.asList("Block1", "Camera1", "CommandChip1", "CommandPod1", "DetacherSide1", "DockingPort1",
                    "ElectricMotor1", "Engine1", "Engine2", "Engine3", "FuelAdapter1", "HingeRotator1", "IonEngine1",
                    "Light1", "Parachute1", "RCSNozzle1", "RCSNozzle2", "Rotator1", "TestPilot"));

    public Boolean craftResizeTool(String fileName, String resizeNumber, Boolean model) {

        Boolean error = false;

        Double resize = 1.0;
        try {
            resize = Double.parseDouble(resizeNumber);
        } catch (NumberFormatException e) {
            error = true;
        }

        if (error) {
            return true;
        }

        Properties props = System.getProperties(); //从指定位置加载文件
        String name = props.getProperty("user.home") + "\\AppData\\LocalLow\\Jundroo\\SimpleRockets 2\\UserData\\CraftDesigns\\" + fileName;

        Scanner input = null;
        PrintWriter output = null;
        try {
            input = new Scanner(new FileInputStream(name.concat(".xml")));
            File file = new File(name.concat("_" + resize + "xResized.xml"));
            file.createNewFile();
            output = new PrintWriter(new FileOutputStream(file, false));

            long startTime = System.nanoTime();
            if (!model)
                Tinkered(resize, input, output);
            if (model)
                Legit(resize, input, output);
        } catch (IOException e) {
            System.out.println("文件不存在");
        } finally {
            input.close();
            output.close();
        }
        return false;
    }

    public void Tinkered(Double resize, Scanner input, PrintWriter output) {
        String line = null;
        while (input.hasNextLine()) {
            if ((line = input.nextLine()).contains("</Parts>"))
                break;
            if (line.contains("<Part")) {
                line = Replace(line, "position", position, 3, resize);
            } else if (line.contains("<Config")) {
                Matcher scaleMatch = partScale.matcher(line);
                if (scaleMatch.find()) {
                    String[] value = scaleMatch.group(1).trim().split(",");
                    line = scaleMatch.replaceFirst("partScale=\"" + Double.parseDouble(value[0]) * resize + ","
                            + Double.parseDouble(value[1]) * resize + "," + Double.parseDouble(value[2]) * resize
                            + "\"");
                } else
                    line = line.replace("<Config",
                            "<Config partScale=\"" + resize + "," + resize + "," + resize + "\" ");
				/*Matcher massMatch = massScale.matcher(line);
				if (massMatch.find()) {
					String value = massMatch.group(1).trim();
					line = massMatch.replaceFirst("massScale=\"" + Double.parseDouble(value) * Math.pow(resize, 3) + "\"");
				} else
					line = line.replace("<Config", "<Config massScale=\"" + Math.pow(resize, 3) + "\" ");*/
            }
            output.println(line);
        }
        while (input.hasNextLine()) {
            output.println(line);
            line = input.nextLine();
        }
        System.out.println(line);
        output.print(line);
    }

    public void Legit(Double resize, Scanner input, PrintWriter output) {
        String line = null;
        Boolean tinkerSize = false;
        while (input.hasNextLine()) {
            if ((line = input.nextLine()).contains("</Parts>"))
                break;
            if (line.contains("<Part")) {
                tinkerSize = false;
                Matcher findType = type.matcher(line);
                if (findType.find())
                    if (!resizableParts.contains(findType.group(1).trim()))
                        tinkerSize = true;
                line = Replace(line, "position", position, 3, resize);
            } else if (line.contains("<Config") && tinkerSize) {
                Matcher scaleMatch = partScale.matcher(line);
                if (scaleMatch.find()) {
                    String[] value = scaleMatch.group(1).trim().split(",");
                    line = scaleMatch.replaceFirst("partScale=\"" + Double.parseDouble(value[0]) * resize + ","
                            + Double.parseDouble(value[1]) * resize + "," + Double.parseDouble(value[2]) * resize
                            + "\"");
                } else
                    line = line.replace("<Config",
                            "<Config partScale=\"" + resize + "," + resize + "," + resize + "\" ");
				/*Matcher massMatch = massScale.matcher(line);
				if (massMatch.find()) {
					String value = massMatch.group(1).trim();
					line = massMatch
							.replaceFirst("massScale=\"" + Double.parseDouble(value) * Math.pow(resize, 3) + "\"");
				} else
					line = line.replace("<Config", "<Config massScale=\"" + Math.pow(resize, 3) + "\" ");*/
            } else if (line.contains("<Fuselage")) {
                line = Replace(line, "bottomScale", bottomScale, 2, resize);
                line = Replace(line, "topScale", topScale, 2, resize);
                line = Replace(line, "offset", offset, 3, resize);
            } else if (line.contains("<FuelTank")) {
                line = Replace(line, "capacity", capacity, 1, Math.pow(resize, 3));
                line = Replace(line, "fuel", fuel, 1, Math.pow(resize, 3));
            } else if (line.contains("<Wing")) {
                line = Replace(line, "rootTrailingOffset", rootTrailing, 1, resize);
                line = Replace(line, "rootLeadingOffset", rootLeading, 1, resize);
                line = Replace(line, "tipTrailingOffset", tipTrailing, 1, resize);
                line = Replace(line, "tipLeadingOffset", tipLeading, 1, resize);
                line = Replace(line, "tipPosition", tipPosition, 3, resize);
            } else if (line.contains("<Suspension") || line.contains("<LandingGear") || line.contains("<ResizableWheel")
                    || line.contains("<JetEngine") || line.contains("<RocketEngine")) {
                line = Replace(line, "size", size, 1, resize);
            } else if (line.contains("<SolarPanelArray") || line.contains("<LandingLeg") || line.contains("<Piston"))
                line = Replace(line, "scale", scale, 1, resize);
            output.println(line);
        }
        while (input.hasNextLine()) {
            output.println(line);
            line = input.nextLine();
        }
        output.print(line);
    }

    private String Replace(String line, String atribute, Pattern pattern, int slots, Double resize) {
        Matcher match = pattern.matcher(line);
        if (match.find()) {
            String[] value = match.group(1).trim().split(",");
            if (slots == 1)
                line = match.replaceFirst(atribute + "=\"" + Double.parseDouble(value[0]) * resize + "\"");
            else if (slots == 2)
                line = match.replaceFirst(atribute + "=\"" + Double.parseDouble(value[0]) * resize + ","
                        + Double.parseDouble(value[1]) * resize + "\"");
            else if (slots == 3)
                line = match.replaceFirst(atribute + "=\"" + Double.parseDouble(value[0]) * resize + ","
                        + Double.parseDouble(value[1]) * resize + "," + Double.parseDouble(value[2]) * resize + "\"");
        }
        return line;
    }

}
