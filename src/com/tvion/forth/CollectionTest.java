package com.tvion.forth;

import com.tvion.first.MyTriangle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/*
 *                       LinkedList vs ArrayList
 *
 *
 *
 *   Вставка в один из этих двух списков зависит от позиции,
 * на которую необходимо произвести вставку и количества вставляемых данных
 *
 * ArrayList:
 * Быстрый доступ к элементу, медленная вставка (Необходимость сдвигать все элементы справа
 * от элемента с нужным индексом). Эффективен при добавление данных в конце списка, и не очень большом количестве
 * добавляемых данных в середине списка.
 *
 * LinkedList:
 * Быстрое добавление элемента (Изменить ссылки в предыдущем и следующим узле) , медленное получения доступа (перебор
 * элементов по очереди, время доступа растет пропорционально размеру списка). Эффективен при добавление
 * элементов в начале списка и добавление большого количества элементов в середине списка.
 *
 *   С удалением дела обстоят так же как и с вставкой.
 *
 *                       Множества
 *   ThreeSet является самым медленным множеством по результатам выполнения основных операций,
 * его стоит использовать когда необходимо упорядочить элементы внутри множества.
 * HashSet и LinkedSet имеют постоянное время для основных операций.
 * LinkedSet используется, когда необходимо хранить элементы в порядке ввода/доступа.
 *
 *                       Отображения
 *   ThreeMap так же является самым медленным отображением, использовать при необходимости сортировки элементов.
 *   Постоянное время для основных операций у HashMap и LinkedHashSet.
 *
 *
 * */

public class CollectionTest {
    static long startTime;
    static long estimatedTime;
    static List<MyTriangle> arrayList=new ArrayList<>();
    static List<MyTriangle> linkedList=new LinkedList<>();
    static Set<MyTriangle> hashSet = new HashSet<>();
    static Set<MyTriangle> linkedHashSet = new LinkedHashSet<>();
    static Set<MyTriangle> treeSet = new TreeSet<>();
    static Map<Integer, String> hashMap = new HashMap<>();
    static Map<Integer, String> linkedHashMap = new HashMap<>();
    static Map<Integer, String> treeMap = new TreeMap<>();
    static final int size = 200000;
    static final int sizeForMaps=10000;
    static final int countForList = 10000;
    static final int countForSet = 10000;
    static final int countForMap = 10000;
    static final int positionForLists = 9000;

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        initMyTriangleCollections(size);
        initMyMaps(sizeForMaps);
        compareLists(countForList,positionForLists);
        compareSets(countForSet);
        compareMaps(countForMap);
    }

    public static void initMyTriangleCollections(int size){
        for (int i = 0; i < size; i++) {
            //MyTriangle реализует интерфейс Comparable<MyTriangle>
            MyTriangle mt = new MyTriangle(0.0, 0.0, (double) i, (Math.random() * 10 - 5) * i, 5.0, 5.0);
            arrayList.add(mt);
            linkedList.add(mt);
            hashSet.add(mt);
            linkedHashSet.add(mt);
            treeSet.add(mt);
        }
    }

    public static void initMyMaps(int sizeForMap){
        int[] ranArray = new int[sizeForMap];
        for (int i = 0; i < sizeForMap; i++) {
            ranArray[i] = (int) (Math.random() * 200);
            hashMap.put(ranArray[i], Character.getName(ranArray[i]));
            linkedHashMap.put(ranArray[i], Character.getName(ranArray[i]));
            treeMap.put(ranArray[i], Character.getName(ranArray[i]));
        }
    }

    public static void compareLists(int count,int position){
        System.out.println();
        System.out.println("*****COMPARE_LISTS*****");
        System.out.println();

        MyTriangle[] mt = new MyTriangle[count];
        for (int i = 0; i < count; i++) {
            mt[i] = new MyTriangle(0.0, 0.0, (double) i, (Math.random() * 10 - 5) * i, i + 5.0, 5.0);
        }

        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.add(mt[i]);
        }
//        Поначалу сокращал код таким образом
        endOfOperation(arrayList,"add",countForList);


        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.add(mt[i]);
        }
        endOfOperation(linkedList,"add",countForList);


        System.out.println();


        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.add(position, mt[i]);
        }
        endOfOperation(arrayList,"add to index",countForList);

        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.add(position, mt[i]);
        }
        endOfOperation(linkedList,"add to index",countForList);


        System.out.println();


        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.remove(position);
        }
        endOfOperation(arrayList,"remove",countForList);

        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.remove(position);
        }
        endOfOperation(linkedList,"remove",countForList);

        System.out.println();
    }

    public static void compareSets(int countForSet) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println();
        System.out.println("*****COMPARE_SETS*****");
        System.out.println();

        MyTriangle[] mt = new MyTriangle[countForSet];
        for (int i = 0; i < countForSet; i++) {
            mt[i] = new MyTriangle(0.0, 0.0, (double) i, (Math.random() * 10 - 5) * i, i + 5.0, 5.0);
        }
//******************************************************************************************************************************************************

        // Глеб, вопрос, можно ли писать подобные методы (ниже) для сокращения кода или это совсем костыль?

        doForSet(hashSet,"add",mt);
        doForSet(linkedHashSet,"add",mt);
        doForSet(treeSet,"add",mt);

        System.out.println();

        doForSet(hashSet,"contains",mt);
        doForSet(linkedHashSet,"contains",mt);
        doForSet(treeSet,"contains",mt);

        System.out.println();

        doForSet(hashSet,"remove",mt);
        doForSet(hashSet,"remove",mt);
        doForSet(hashSet,"remove",mt);

        System.out.println();
    }

//Вариант еще короче

    public static void compareMaps(int countForMap) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println();
        System.out.println("*****COMPARE_MAPS*****");
        System.out.println();

        String[] operationsForMap={"put","containsKey","remove"};

        Integer[] ranAddArray = new Integer[countForMap];
        for (int i = 0; i < countForMap; i++) {
            ranAddArray[i] = (int) (Math.random() * 2000);
        }

        for(String operation:operationsForMap){
            doForMap(hashMap,operation,ranAddArray);
            doForMap(linkedHashMap,operation,ranAddArray);
            doForMap(treeMap,operation,ranAddArray);
            System.out.println();
        }
    }


    public static void doForSet(Collection col,String operation,MyTriangle... mt) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class colClass=col.getClass();
        Method method=colClass.getMethod(operation, Object.class);
        method.setAccessible(true);
        String[] name=colClass.getName().split("\\.");
        startTime = System.nanoTime();
        for (int i = 0; i < mt.length; i++) {
            method.invoke(col,mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(name[name.length-1]+" "+operation+" " + mt.length + " elements time is");
        System.out.println(estimatedTime);
    }


    public static void doForMap(Map col,String operation,Integer... intArray) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class colClass=col.getClass();
        Method method;
        if("containsKey".equals(operation)){
            method=colClass.getMethod(operation, Object.class);
        } else {
            method=colClass.getMethod(operation, Object.class,Object.class);
        }
        method.setAccessible(true);
        String[] name=colClass.getName().split("\\.");
        if("containsKey".equals(operation)){
            startTime = System.nanoTime();
            for (int i = 0; i < intArray.length; i++) {
                method.invoke(col,intArray[i]);
            }
            estimatedTime = System.nanoTime() - startTime;
        } else {
            startTime = System.nanoTime();

            startTime = System.nanoTime();
            for (int i = 0; i < intArray.length; i++) {
                method.invoke(col,intArray[i],Character.getName(intArray[i]));
            }
            estimatedTime = System.nanoTime() - startTime;
        }
        System.out.println(name[name.length-1]+" "+operation+" " + intArray.length + " elements time is");
        System.out.println(estimatedTime);
    }
    




    public static void endOfOperation(Collection col,String operation, int count){
        estimatedTime = System.nanoTime() - startTime;
        String[] name=col.getClass().getName().split("\\.");
        System.out.println(name[name.length-1]+" "+operation+" "+ count + " elements time is");
        System.out.println(estimatedTime);
    }
}







