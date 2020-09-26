package com.foxconn;

import java.util.ArrayList;
import java.util.List;

public class CreateLine {
   List<Integer> ids = new ArrayList();
   public List<String> kinds = new ArrayList<>();
   public List<String> states0 = new ArrayList<>();
   public List<String> states1 = new ArrayList<>();
   public List<String> dates = new ArrayList<>();
   public List<Integer> times = new ArrayList<>();
   public List<String> warningkind1=new ArrayList<>();

   public List<String> warningkind2=new ArrayList<>();

   public List<String> warningkind3=new ArrayList<>();


   public List<String> warningkind4=new ArrayList<>();

    public  void load(){
        for (int i = 0; i < 10; i++) {
            ids.add(i);
        }

        kinds.add("设备安灯");
        kinds.add("品质安灯");
        kinds.add("物料安灯");
        kinds.add("保养安灯");

        states0.add("1");
        states0.add("");
        states1.add("");
        states1.add("1");

        for (int i = 1; i < 8; i++) {
            dates.add("7-" + i);
        }

        for (int i = 0; i < 24; i++) {
            times.add(i);
        }
        warningkind1.add("设备异常类型1");
        warningkind1.add("设备异常类型2");
        warningkind2.add("品质异常类型1");
        warningkind2.add("品质异常类型2");
        warningkind3.add("物料缺失类型1");
        warningkind3.add("物料缺失类型2");
        warningkind4.add("待保养");
    }

}
