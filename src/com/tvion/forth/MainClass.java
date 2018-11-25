package com.tvion.forth;

import com.tvion.second.MyComplex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;


public class MainClass{
    public static long startTime;
    public static long estimatedTime;
    public static List<MyComplex> libraryLinkedList;
    public static ILinkedList<MyComplex> myLinkedList;
    public static final int IND = 6000;
    public static final int SIZE = 10000;
    public static final int COUNT = 10000;

    enum Operations{GET,ADD_TO_INDEX,REMOVE}

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
        System.out.println("Index 6+44i element is " + myLinkedList.indexOf(l));
        System.out.println("Add 0+0 on index 3");
        myLinkedList.add(3, new MyComplex(0, 0));
        System.out.println("Get 2 element " + myLinkedList.get(1));
        System.out.println();

        //Выводим для сравнения
        for (MyComplex c : myLinkedList) {
            System.out.println(c);
        }

        //Проверка toArray и toString
        System.out.println(myLinkedList);

        System.out.println();
    }

    public static void compareWithStandard() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        MyComplex[] myComplex = new MyComplex[COUNT];
        for (int i = 0; i < COUNT; i++) {
            myComplex[i] = new MyComplex(i * i, i - 100);
        }

        System.out.println("*****COMPARE_WITH_STANDARD*****");

        libraryLinkedList = new LinkedList<>();
        myLinkedList.clear();

        for (int i = 0; i < SIZE; i++) {
            myLinkedList.add(new MyComplex(i, 50 - i));
            libraryLinkedList.add(new MyComplex(i, 50 - i));
        }


        for (Operations operation : Operations.values()) {
            doForList(myLinkedList, operation, myComplex);
            doForList(libraryLinkedList, operation, myComplex);
        }
    }

//******************************************************************************************************************************************************

    // Глеб, вопрос, можно ли писать подобные универсальные методы (ниже) или это совсем костыль?

    public static void doForList(Object col, Operations operation, MyComplex... myComplexes) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class colClass = col.getClass();
        Method method = initMethod(colClass, operation);
        method.setAccessible(true);
        String[] name = colClass.getName().split("\\.");
        execMethod(col, method, operation, myComplexes);
        System.out.println(name[name.length - 1] + " " + operation + " " + myComplexes.length + " elements time is");
        System.out.println(estimatedTime);
    }

    public static Method initMethod(Class cl, Operations operation) throws NoSuchMethodException {
        //В дальшейшем увеличивать число поддерживаемых методов
        switch (operation) {
            case ADD_TO_INDEX:
                return cl.getMethod("add", int.class, Object.class);
            default:
                return cl.getMethod(operation.toString().toLowerCase(), int.class);
        }
    }

    public static void execMethod(Object col, Method method, Operations operation, MyComplex... myComplexes) throws InvocationTargetException, IllegalAccessException {
        switch (operation) {
            case ADD_TO_INDEX:
                startTime = System.nanoTime();
                for (int i = 0; i < myComplexes.length; i++) {
                    method.invoke(col, IND, myComplexes[i]);
                }
                estimatedTime = System.nanoTime() - startTime;
                break;
            default:
                startTime = System.nanoTime();
                for (int i = 0; i < myComplexes.length; i++) {
                    method.invoke(col, IND);
                }
                estimatedTime = System.nanoTime() - startTime;
        }
    }
}
