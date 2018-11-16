package com.tvion.forth;

import com.tvion.first.MyTriangle;

import java.util.*;

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

    public static void main(String[] args) {
    initMyTriangleCollections(size);
    initMyMaps(sizeForMaps);
    compareLists(countForList);
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

    public static void compareLists(int count){
        MyTriangle[] mt = new MyTriangle[count];

        for (int i = 0; i < count; i++) {
            mt[i] = new MyTriangle(0.0, 0.0, (double) i, (Math.random() * 10 - 5) * i, i + 5.0, 5.0);
        }
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.add(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList add " + count + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.add(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList add " + count + " elements time is");
        System.out.println(estimatedTime);

        System.out.println();

        int position = 9000;

        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.add(position, mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList add to index " + position + " " + count + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.add(position, mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList add to index " + position + " " + count + " elements time is");
        System.out.println(estimatedTime);


        System.out.println();


        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.remove(position);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList remove on index " + position + " " + count + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.remove(position);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList remove on index " + position + " " + count + " elements time is");
        System.out.println(estimatedTime);
    }

    public static void compareSets(int countForSet){
        System.out.println("*****COMPARE_SETS*****");
        System.out.println();
        MyTriangle[] mt = new MyTriangle[countForSet];

        for (int i = 0; i < countForSet; i++) {
            mt[i] = new MyTriangle(0.0, 0.0, (double) i, (Math.random() * 10 - 5) * i, i + 5.0, 5.0);
        }
        startTime = System.nanoTime();
        for (int i = 0; i < countForSet; i++) {
            hashSet.add(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("hashSet add " + countForSet + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < countForSet; i++) {
            linkedHashSet.add(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashSet add " + countForSet + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < countForSet; i++) {
            treeSet.add(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeSet add " + countForSet + " elements time is");
        System.out.println(estimatedTime);


        System.out.println();


        startTime = System.nanoTime();
        for (int i = 0; i < countForSet; i++) {
            hashSet.contains(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("hashSet find elements" + " for time is");
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < countForSet; i++) {
            linkedHashSet.contains(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashSet find elements" + " for time is");
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < countForSet; i++) {
            treeSet.contains(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeSet find elements" + " for time is");
        System.out.println(estimatedTime);


        System.out.println();


        for (int i = 0; i < countForSet; i++) {
            hashSet.remove(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("hashSet remove " + countForSet + " elements time is");
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < countForSet; i++) {
            linkedHashSet.remove(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashSet remove " + countForSet + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < countForSet; i++) {
            treeSet.remove(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeSet remove " + countForSet + " elements time is");
        System.out.println(estimatedTime);
        System.out.println();
    }


    public static void compareMaps(int countForMap){
        System.out.println("*****COMPARE_MAPS*****");
        System.out.println();
        Integer[] ranAddArray = new Integer[countForMap];
        for (int i = 0; i < countForMap; i++) {
            ranAddArray[i] = (int) (Math.random() * 2000);
        }
        startTime = System.nanoTime();
        for (int i = 0; i < countForMap; i++) {
            hashMap.put(ranAddArray[i], Character.getName(ranAddArray[i]));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashMap add " + countForMap + " elements time is");
        System.out.println(estimatedTime);

        for (int i = 0; i < countForMap; i++) {
            linkedHashMap.put(ranAddArray[i], Character.getName(ranAddArray[i]));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedHashMap add " + countForMap + " elements time is");
        System.out.println(estimatedTime);

        for (int i = 0; i < countForMap; i++) {
            treeMap.put(ranAddArray[i], Character.getName(ranAddArray[i]));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("TreeHashMap add " + countForMap + " elements time is");
        System.out.println(estimatedTime);


        System.out.println();


        startTime = System.nanoTime();
        for (int i = 0; i < countForMap; i++) {
            hashMap.containsKey(ranAddArray[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("hashMap find elements" + " for time is");
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < countForMap; i++) {
            linkedHashMap.containsKey(ranAddArray[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashMap find elements" + " for time is");
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < countForMap; i++) {
            treeMap.containsKey(ranAddArray[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeMap find elements" + " for time is");
        System.out.println(estimatedTime);


        System.out.println();


        for (int i = 0; i < countForMap; i++) {
            hashMap.remove(i, Character.getName(i));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashMap remove " + countForMap + " elements time is");
        System.out.println(estimatedTime);

        for (int i = 0; i < countForMap; i++) {
            linkedHashMap.remove(i, Character.getName(i));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedHashMap remove " + countForMap + " elements time is");
        System.out.println(estimatedTime);

        for (int i = 0; i < countForMap; i++) {
            treeMap.remove(i, Character.getName(i));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("TreeHashMap remove " + countForMap + " elements time is");
        System.out.println(estimatedTime);
    }

}







