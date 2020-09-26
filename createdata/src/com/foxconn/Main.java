package com.foxconn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        File file = new File("D:\\dataFactory\\test2.csv");
//        BufferedReader br=new BufferedReader(new FileReader(file));
//        String ling;
//        while ((ling=br.readLine())!=null){
//            System.out.println(ling);
//        }
//        br.close();
        writeData(file, 4, 3080);
        writeData(file, 3, 4620);
        writeData(file, 2, 1540);
        writeData(file, 1, 770);
    }

    public static void writeData(File file, int pattern, int times) throws IOException {
        CreateLine createLine = new CreateLine();
        createLine.load();
        if (pattern == 4) {
            cycle(file, createLine.kinds, times);
        } else if (pattern == 3) {
            List<String> kinds = new ArrayList<>();
            kinds.add("设备安灯");
            kinds.add("品质安灯");
            kinds.add("物料安灯");
            cycle(file, kinds, times);
        } else if (pattern == 2) {
            List<String> kinds = new ArrayList<>();
            kinds.add("品质安灯");
            kinds.add("物料安灯");
            cycle(file, kinds, times);
        } else if (pattern == 1) {
            List<String> kinds = new ArrayList<>();
            kinds.add("物料安灯");
            cycle(file, kinds, times);
        } else {
            System.out.println("模式设置错误");
        }

    }

    public static void cycle(File file, List<String> kinds, int times) throws IOException {
        CreateLine createLine = new CreateLine();
        createLine.load();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        bw.newLine();
        StringBuilder sb;
        Random random = new Random();
        //写入好坏各有的数据
        for (int i = 0; i < times * 0.476; i++) {
            sb = new StringBuilder();
            Integer id = createLine.ids.get(random.nextInt(createLine.ids.size()));
            sb.append(id);
            sb.append(",");

            String kind = kinds.get(random.nextInt(kinds.size()));
            sb.append(kind);
            sb.append(",");

            String state00 = createLine.states0.get(0);
            sb.append(state00);
            sb.append(",");
            String state01 = createLine.states1.get(0);
            sb.append(state01);
            sb.append(",");

            String date = createLine.dates.get(random.nextInt(createLine.dates.size()));
            sb.append(date);
            sb.append(",");

            Integer time = createLine.times.get(random.nextInt(createLine.times.size()));
            sb.append(time);
            sb.append(",");
            String str1 = null;
            String str2 = null;
            String str3 = null;
            if (kind.equals("设备安灯")) {
                str1 = createLine.warningkind1.get(random.nextInt(createLine.warningkind1.size()));
                sb.append(str1);
            } else if (kind.equals("品质安灯")) {
                str2 = createLine.warningkind2.get(random.nextInt(createLine.warningkind2.size()));
                sb.append(str2);
            } else if (kind.equals("物料安灯")) {
                str3 = createLine.warningkind3.get(random.nextInt(createLine.warningkind3.size()));
                sb.append(str3);
            } else if (kind.equals("保养安灯")) {
                sb.append(createLine.warningkind4.get(0));
            }
            sb.append(",");
            sb.append(1);
            sb.append(",");
            sb.append(0);
            String string = sb.toString();
            bw.write(string);
            sb.delete(0, sb.length());
            bw.newLine();

            sb.append(id);
            sb.append(",");

            sb.append(kind);
            sb.append(",");

            String state10 = createLine.states0.get(1);
            sb.append(state10);
            sb.append(",");
            String state11 = createLine.states1.get(1);
            sb.append(state11);
            sb.append(",");

            sb.append(date);
            sb.append(",");

            sb.append(time);
            sb.append(",");

            if (kind.equals("设备安灯")) {
                sb.append(str1);
            } else if (kind.equals("品质安灯")) {
                sb.append(str2);
            } else if (kind.equals("物料安灯")) {
                sb.append(str3);
            } else if (kind.equals("保养安灯")) {
                sb.append(createLine.warningkind4.get(0));
            }
            sb.append(",");
            sb.append(1);

            sb.append(",");
            if (kind.equals("设备安灯")) {
                sb.append(1.5);
            } else if (kind.equals("品质安灯")) {
                sb.append(0.5);
            } else if (kind.equals("物料安灯")) {
                sb.append(0.8);
            } else if (kind.equals("保养安灯")) {
                sb.append(2.25);
            }

            String string2 = sb.toString();
            bw.write(string2);
            bw.newLine();
        }
        //写入不好的数据
        for (int i = 0; i < times * 0.048; i++) {
            sb = new StringBuilder();
            Integer id = createLine.ids.get(random.nextInt(createLine.ids.size()));
            sb.append(id);
            sb.append(",");

            String kind = kinds.get(random.nextInt(kinds.size()));
            sb.append(kind);
            sb.append(",");

            String state0 = createLine.states0.get(0);
            sb.append(state0);
            sb.append(",");
            String state1 = createLine.states1.get(0);
            sb.append(state1);
            sb.append(",");

            String date = createLine.dates.get(random.nextInt(createLine.dates.size()));
            sb.append(date);
            sb.append(",");

            Integer time = createLine.times.get(random.nextInt(createLine.times.size()));
            sb.append(time);
            sb.append(",");

            if (kind.equals("设备安灯")) {
                String str1 = createLine.warningkind1.get(random.nextInt(createLine.warningkind1.size()));
                sb.append(str1);
            } else if (kind.equals("品质安灯")) {
                String str2 = createLine.warningkind2.get(random.nextInt(createLine.warningkind2.size()));
                sb.append(str2);
            } else if (kind.equals("物料安灯")) {
                String str3 = createLine.warningkind3.get(random.nextInt(createLine.warningkind3.size()));
                sb.append(str3);
            } else if (kind.equals("保养安灯")) {
                sb.append(createLine.warningkind4.get(0));
            }
            sb.append(",");
            sb.append(1);
            sb.append(" ");
            sb.append(0);
            String string = sb.toString();
            bw.write(string);
            bw.newLine();
        }
        bw.close();
        System.out.println("写入成功，写入数量：" + times);
    }
}
