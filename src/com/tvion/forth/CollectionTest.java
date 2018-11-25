package com.tvion.forth;

import com.tvion.first.MyTriangle;
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
 * от элемента с нужным индексом). Эффективен при получении элемента по индексу, и при добавлении не очень большого количества
 * данных в середину списка.
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
    static List<MyTriangle> arrayList = new ArrayList<>();
    static List<MyTriangle> linkedList = new LinkedList<>();
    static Set<MyTriangle> hashSet = new HashSet<>();
    static Set<MyTriangle> linkedHashSet = new LinkedHashSet<>();
    static Set<MyTriangle> treeSet = new TreeSet<>();
    static Map<Integer, String> hashMap = new HashMap<>();
    static Map<Integer, String> linkedHashMap = new HashMap<>();
    static Map<Integer, String> treeMap = new TreeMap<>();
    static final int SIZE = 200000;
    static final int SIZE_FOR_MAPS = 100000;
    static final int COUNT_FOR_LIST = 10000;
    static final int COUNT_FOR_SET = 10000;
    static final int COUNT_FOR_MAP = 10000;
    static final int POSITION_FOR_LISTS = 9000;

    public static void main(String[] args) {
        initMyTriangleCollections(SIZE);
        initMyMaps(SIZE_FOR_MAPS);
        compareLists(COUNT_FOR_LIST, POSITION_FOR_LISTS);
        compareSets(COUNT_FOR_SET);
        compareMaps(COUNT_FOR_MAP);
    }

    public static void initMyTriangleCollections(int size) {
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

    public static void initMyMaps(int sizeForMap) {
        int[] ranArray = new int[sizeForMap];
        for (int i = 0; i < sizeForMap; i++) {
            ranArray[i] = (int) (Math.random() * 200);
            hashMap.put(ranArray[i], Character.getName(ranArray[i]));
            linkedHashMap.put(ranArray[i], Character.getName(ranArray[i]));
            treeMap.put(ranArray[i], Character.getName(ranArray[i]));
        }
    }

    public static void compareLists(int count, int position) {
        System.out.println();
        System.out.println("*****COMPARE_LISTS*****");
        System.out.println();

        MyTriangle[] mt = new MyTriangle[count];
        for (int i = 0; i < count; i++) {
            mt[i] = new MyTriangle(0.0, 0.0, (double) i, (Math.random() * 10 - 5) * i, i + 5.0, 5.0);
        }

        addToCollection(arrayList, mt);
        addToCollection(linkedList, mt);


        System.out.println();


        addToListByIndex(arrayList, position, mt);
        addToListByIndex(linkedList, position, mt);


        System.out.println();


        removeFromList(arrayList, position);
        removeFromList(linkedList, position);

        System.out.println();
    }

    public static void compareSets(int countForSet){

        System.out.println();
        System.out.println("*****COMPARE_SETS*****");
        System.out.println();

        MyTriangle[] mt = new MyTriangle[countForSet];
        for (int i = 0; i < countForSet; i++) {
            mt[i] = new MyTriangle(0.0, 0.0, (double) i, (Math.random() * 10 - 5) * i, i + 5.0, 5.0);
        }


        addToCollection(hashSet, mt);
        addToCollection(linkedHashSet, mt);
        addToCollection(treeSet, mt);


        System.out.println();


        containsInSet(hashSet, mt);
        containsInSet(linkedHashSet, mt);
        containsInSet(treeSet, mt);


        System.out.println();


        removeFromSet(hashSet, mt);
        removeFromSet(linkedHashSet, mt);
        removeFromSet(treeSet, mt);

        System.out.println();
    }


    public static void compareMaps(int countForMap){
        System.out.println();
        System.out.println("*****COMPARE_MAPS*****");
        System.out.println();

        Integer[] ranAddArray = new Integer[countForMap];
        for (int i = 0; i < countForMap; i++) {
            ranAddArray[i] = (int) (Math.random() * 2000);
        }

        putInMap(hashMap, ranAddArray);
        putInMap(linkedHashMap, ranAddArray);
        putInMap(treeMap, ranAddArray);


        System.out.println();


        containInMap(hashMap, ranAddArray);
        containInMap(linkedHashMap, ranAddArray);
        containInMap(treeMap, ranAddArray);


        System.out.println();


        removeFromMap(hashMap, ranAddArray);
        removeFromMap(linkedHashMap, ranAddArray);
        removeFromMap(treeMap, ranAddArray);

        System.out.println();
    }

    public static String getEndClassName(Object obj) {
        String[] name = obj.getClass().getName().split("\\.");
        return name[name.length - 1];
    }


    public static void addToCollection(Collection<? super MyTriangle> collection, MyTriangle... myTriangles) {
        startTime = System.nanoTime();
        for (MyTriangle mt : myTriangles) {
            collection.add(mt);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(getEndClassName(collection) + " add " + myTriangles.length + " elements time is");
        System.out.println(estimatedTime);

    }


    public static void addToListByIndex(List list, int index, MyTriangle... myTriangles) {
        startTime = System.nanoTime();
        for (MyTriangle mt : myTriangles) {
            list.add(index, mt);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(getEndClassName(list) + " add to index " + index + " " + myTriangles.length + " elements time is");
        System.out.println(estimatedTime);
    }


    public static void removeFromList(List<? super MyTriangle> list, int index) {
        startTime = System.nanoTime();
        for (int i = 0; i < COUNT_FOR_LIST; i++) {
            list.remove(index);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(getEndClassName(list) + "remove " + COUNT_FOR_LIST + " elements time is");
        System.out.println(estimatedTime);
    }




    public static void containsInSet(Set<? super MyTriangle> set, MyTriangle... myTriangles) {
        startTime = System.nanoTime();
        for (MyTriangle mt : myTriangles) {
            set.contains(mt);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(getEndClassName(set) + " contains " + myTriangles.length + " elements time is");
        System.out.println(estimatedTime);
    }


    public static void removeFromSet(Set<? super MyTriangle> set, MyTriangle... myTriangles) {
        startTime = System.nanoTime();
        for (MyTriangle mt : myTriangles) {
            set.remove(mt);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(getEndClassName(set) + " remove " + myTriangles.length + " elements time is");
        System.out.println(estimatedTime);
    }




    public static void putInMap(Map map,Integer[] integers){
        startTime = System.nanoTime();
        for (int i=0;i<integers.length;i++) {
            map.put(integers[i],Character.getName(integers[i]));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(getEndClassName(map) + " put " + integers.length + " elements time is");
        System.out.println(estimatedTime);
    }


    public static void containInMap(Map map,Integer[] integers){
        startTime = System.nanoTime();
        for (int i=0;i<integers.length;i++) {
            map.containsKey(integers[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(getEndClassName(map) + " contains " + integers.length + " elements time is");
        System.out.println(estimatedTime);
    }


    public static void removeFromMap(Map map,Integer[] integers){
        startTime = System.nanoTime();
        for (int i=0;i<integers.length;i++) {
            map.remove(integers[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(getEndClassName(map) + " remove " + integers.length + " elements time is");
        System.out.println(estimatedTime);
    }
}