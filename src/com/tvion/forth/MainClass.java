package com.tvion.forth;

import com.tvion.second.MyComplex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;


public class MainClass {
    public static long startTime;
    public static long estimatedTime;
    public static List<MyComplex> libraryLinkedList;
    public static ILinkedList<MyComplex> myLinkedList;
    public static final int ind = 6000;
    public static final int size = 10000;
    public static final int count = 10000;
    public static final String[] operations = {"get", "add to index", "remove"};

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        testMyClass();
        compareWithStandard();
    }

    public static void testMyClass() {
        //Создаем наш список
        myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            myLinkedList.add(new MyComplex(i, 50 - i));
        }
        for (MyComplex c : myLinkedList) {
            System.out.println(c);
        }

        //Изменяем
        MyComplex l = new MyComplex(6, 44);
        System.out.println("Index 4+44i element is " + myLinkedList.indexOf(l));
        System.out.println("Add 0+0 on index 3");
        myLinkedList.add(3, new MyComplex(0, 0));
        System.out.println("Get 2 element " + myLinkedList.get(1));
        System.out.println();

        //Выводим для сравнения
        for (MyComplex c : myLinkedList) {
            System.out.println(c);
        }

        MyComplex mc = new MyComplex(3, 47);
        System.out.println("Index of 3+47i is " + myLinkedList.indexOf(mc));
        System.out.println(myLinkedList);
        System.out.println();
    }

    public static void compareWithStandard() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        MyComplex[] myComplex = new MyComplex[count];
        for (int i = 0; i < count; i++) {
            myComplex[i] = new MyComplex(i * i, i - 100);
        }

        System.out.println("*****COMPARE_WITH_STANDARD*****");

        libraryLinkedList = new LinkedList<>();
        myLinkedList.clear();

        for (int i = 0; i < size; i++) {
            myLinkedList.add(new MyComplex(i, 50 - i));
            libraryLinkedList.add(new MyComplex(i, 50 - i));
        }


        for (String operation : operations) {
            doForList(myLinkedList, operation, myComplex);
            doForList(libraryLinkedList, operation, myComplex);
        }
    }

    // Вопрос по подобным методам в классе CollectionTest
    //Просто эксперимент
    public static void doForList(Object col, String operation, MyComplex... myComplexes) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class colClass = col.getClass();
        Method method;
        if ("add to index".equals(operation)) {
            method = colClass.getMethod("add", int.class, Object.class);
        } else {
            method = colClass.getMethod(operation, int.class);
        }
        method.setAccessible(true);
        String[] name = colClass.getName().split("\\.");
        if ("add to index".equals(operation)) {
            startTime = System.nanoTime();
            for (int i = 0; i < myComplexes.length; i++) {
                method.invoke(col, ind, myComplexes[i]);
            }
            estimatedTime = System.nanoTime() - startTime;
        } else {
            startTime = System.nanoTime();
            for (int i = 0; i < myComplexes.length; i++) {
                method.invoke(col, ind);
            }
            estimatedTime = System.nanoTime() - startTime;
        }
        System.out.println(name[name.length - 1] + " " + operation + " " + myComplexes.length + " elements time is");
        System.out.println(estimatedTime);
        System.out.println();
    }

}
