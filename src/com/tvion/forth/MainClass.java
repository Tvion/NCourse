package com.tvion.forth;

import com.tvion.second.MyComplex;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        ILinkedList<MyComplex> s=new MyLinkedList<>();
        for(int i=0;i<100;i++){
            s.add(new MyComplex(i,50-i));
        }
        for(MyComplex c:s){
            System.out.println(c);
        }
        MyComplex mc=new MyComplex(13,37);
        System.out.println(s.indexOf(mc));
//        s.clear();
        System.out.println(s);
//        System.out.println(s.get(0));
    }

}
