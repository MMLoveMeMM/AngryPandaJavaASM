package com.org;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class aimHello {
	// ���� һ������
    public static final String FLAG = "���ǳ���";

    // ��ͨ����
    public void display(){
        for (int i = 0; i < 8; i++) {
            System.out.println(">>>>>>>>>>" + FLAG);
        }
    }

    // ����List����ֵ
    public List<String> testList(){
        List<String> list = new ArrayList<>();
        list.add("Tome");
        list.add("Jack");
        list.add("Lily");
        System.out.println(">>>>>>>>>>testList > list.size = " + list.size());
        return list;
    }

    // ���ͷ���ֵ������List��Map
    // ��������������ΪMap����
    public List<Map<String, String>> testMapList(boolean val, Map<String, String>... map){
        List<Map<String, String>> list = new ArrayList<>();
        if(val){
            for (Map<String, String> m : map) {
                list.add(m);
            }
        }
        System.out.println(">>>>>>>>>>testMapList > list.size = " + list.size());
        return list;
    }
}
