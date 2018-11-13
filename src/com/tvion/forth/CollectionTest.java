package com.tvion.forth;

import com.tvion.first.MyTriangle;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        long startTime;
        long estimatedTime;
        int size = 100000;
        List<MyTriangle> arrayList = new ArrayList<>();
        List<MyTriangle> linkedList = new LinkedList<>();
        Set<MyTriangle> hashSet = new HashSet<>();
        Set<MyTriangle> linkedHashSet = new LinkedHashSet<>();
        Set<MyTriangle> treeSet = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            //MyTriangle реализует интерфейс Comparable<MyTriangle>
            MyTriangle mt = new MyTriangle(0.0, 0.0, (double) i, (Math.random() * 10 - 5) * i, 5.0, 5.0);
            arrayList.add(mt);
            linkedList.add(mt);
            hashSet.add(mt);
            linkedHashSet.add(mt);
            treeSet.add(mt);
        }
//        Вывод сторон
/*
        for (MyTriangle t : hashSet) {
            System.out.println(Arrays.toString(t.getSides()));
        }
        System.out.println();
        System.out.println();
        for (MyTriangle t : linkedHashSet) {
            System.out.println(Arrays.toString(t.getSides()));
        }
        System.out.println();
        System.out.println();
        for (MyTriangle t : treeSet) {
            System.out.println(Arrays.toString(t.getSides()));
        }
*/

        int count = 10000;
        MyTriangle[] mt= new MyTriangle[count];

        for(int i=0;i<count;i++){
            mt[i]=new MyTriangle(0.0, 0.0, (double) i, (Math.random() * 10 - 5) * i, i+5.0, 5.0);
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

        int position = 3;

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
//

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

        System.out.println();


        ///////////////////////
        int countForHash = 100000;
        mt= new MyTriangle[countForHash];

        for(int i=0;i<countForHash;i++){
            mt[i]=new MyTriangle(0.0, 0.0, (double) i, (Math.random() * 10 - 5) * i, i+5.0, 5.0);
        }
        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            hashSet.add(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("hashSet add " + countForHash + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            linkedHashSet.add(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashSet add " + countForHash + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            treeSet.add(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeSet add " + countForHash + " elements time is");
        System.out.println(estimatedTime);

        System.out.println();


//        int positionForHash = 20000;
//        MyTriangle mt = new MyTriangle(0.0, 0.0, (double) 5, (Math.random() * 10 - 5) * 5, 5+5.0, 5.0);
        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            hashSet.contains(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("hashSet find " + "mt" + " for time is");
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            linkedHashSet.contains(mt[i]);
        }


        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashSet find " + "mt" + " for time is");
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            treeSet.contains(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeSet find " + "mt" + " for time is");
        System.out.println(estimatedTime);
        System.out.println();


        for (int i = 0; i < countForHash; i++) {
            hashSet.remove(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("hashSet remove " + countForHash + " elements time is");
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            linkedHashSet.remove(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashSet remove " + countForHash + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            treeSet.remove(mt[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeSet remove " + countForHash + " elements time is");
        System.out.println(estimatedTime);
        System.out.println();

        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new HashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        int sizeForMap = 10000;
        int ran;
        for (int i = 0; i < sizeForMap; i++) {
            ran = (int) (Math.random() * 200);
            hashMap.put(ran, Character.getName(ran));
            linkedHashMap.put(ran, Character.getName(ran));
            treeMap.put(ran, Character.getName(ran));
        }

        int countForMap = 10000;
        startTime = System.nanoTime();
        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            ran = (int) (Math.random() * 2000);
            hashMap.put(ran, Character.getName(ran));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashMap add " + countForMap + " elements time is");
        System.out.println(estimatedTime);
//
        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            ran = (int) (Math.random() * 2000);
            linkedHashMap.put(ran, Character.getName(ran));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedHashMap add " + countForMap + " elements time is");
        System.out.println(estimatedTime);

//
        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            ran = (int) (Math.random() * 2000);
            treeMap.put(ran, Character.getName(ran));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("TreeHashMap add " + countForMap + " elements time is");
        System.out.println(estimatedTime);

//
        System.out.println();
//
        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            hashMap.remove(i, Character.getName(i));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashMap remove " + countForMap + " elements time is");
        System.out.println(estimatedTime);

//
        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            linkedHashMap.remove(i, Character.getName(i));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedHashMap remove " + countForMap + " elements time is");
        System.out.println(estimatedTime);

//
        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            treeMap.remove(i, Character.getName(i));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("TreeHashMap remove " + countForMap + " elements time is");
        System.out.println(estimatedTime);
    }


}







