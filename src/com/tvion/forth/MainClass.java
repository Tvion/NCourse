package com.tvion.forth;

import com.tvion.first.MyTriangle;
import com.tvion.second.MyComplex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class MainClass {
    public static long startTime;
    public static long estimatedTime;
    public static List<MyComplex> libraryLinkedList;
    public static ILinkedList<MyComplex> myLinkedList;
    public static void main(String[] args) {
        long startTime;
        long estimatedTime;
        myLinkedList=new MyLinkedList<>();
        for(int i=0;i<10;i++){
            myLinkedList.add(new MyComplex(i,50-i));
        }
        for(MyComplex c:myLinkedList){
            System.out.println(c);
        }
        MyComplex l=new MyComplex(6,44);
        System.out.println("Index 4+44i element is "+myLinkedList.indexOf(l));
        System.out.println("Add 0+0 on index 3");
        myLinkedList.add(3,new MyComplex(0,0));
        System.out.println("Get 2 element "+myLinkedList.get(1));
        System.out.println();
        for(MyComplex c:myLinkedList){
            System.out.println(c);
        }


        MyComplex mc=new MyComplex(3,47);
        System.out.println("Index of 3+47i is "+myLinkedList.indexOf(mc));
        System.out.println(myLinkedList);
        System.out.println();
compareWithStandard();
    }

    public static void compareWithStandard(){
        System.out.println("*****COMPARE_WITH_STANDARD*****");
        libraryLinkedList= new LinkedList<>();
        myLinkedList.clear();
        for(int i=0;i<10000;i++){
            myLinkedList.add(new MyComplex(i,50-i));
            libraryLinkedList.add(new MyComplex(i,50-i));
        }

        MyComplex target;
        int ind=6000;
        startTime=System.nanoTime();
        target=myLinkedList.get(ind);
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("MyList find target= "+target+" at "+estimatedTime+" time");
        startTime=System.nanoTime();
        target=libraryLinkedList.get(ind);
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("LibraryList find target= "+target+" at "+estimatedTime+" time");
        System.out.println();

        startTime=System.nanoTime();
        myLinkedList.remove(ind);
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("MyList remove target at "+estimatedTime+" time");
        startTime=System.nanoTime();
        libraryLinkedList.remove(ind);
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("LibraryList remove target at "+estimatedTime+" time");
        System.out.println();


        MyComplex p=new MyComplex(10,10);
        startTime=System.nanoTime();
        myLinkedList.add(ind,p);
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("MyList add target at "+estimatedTime+" time");
        startTime=System.nanoTime();
        libraryLinkedList.add(ind,p);
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("LibraryList add target at "+estimatedTime+" time");
        System.out.println();
    }

    public static void doForList(Collection col, String operation, MyTriangle... mt) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class colClass = col.getClass();
        Method method = colClass.getMethod(operation, Object.class);
        method.setAccessible(true);
        String[] name = colClass.getName().split("\\.");
        startTime = System.nanoTime();
        for (int i = 0; i < mt.length; i++) {
            method.invoke(col, mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(name[name.length - 1] + " " + operation + " " + mt.length + " elements time is");
        System.out.println(estimatedTime);
    }
}
