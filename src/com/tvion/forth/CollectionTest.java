package com.tvion.forth;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        long startTime;
        long estimatedTime;
        int size = 100000;
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
            hashSet.add(i);
            linkedHashSet.add(i);
            treeSet.add(i);
        }
        int count = 1000;
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.add(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList add " + count + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.add(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList add " + count + " elements time is");
        System.out.println(estimatedTime);


        int position = 1000;

        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.add(position, i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList add to index " + position + " " + count + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.add(position, i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList add to index " + position + " " + count + " elements time is");
        System.out.println(estimatedTime);


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
        int countForHash = 10000;
        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            hashSet.add(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("hashSet add " + countForHash + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            linkedHashSet.add(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashSet add " + countForHash + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            treeSet.add(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeSet add " + countForHash + " elements time is");
        System.out.println(estimatedTime);

        System.out.println();


        int positionForHash = 1000;
        int searchedInt = 6000;
        startTime = System.nanoTime();
        hashSet.contains(searchedInt);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("hashSet find " + searchedInt + " for time is");
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        linkedHashSet.contains(searchedInt);

        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashSet find " + searchedInt + " for time is");
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        treeSet.contains(searchedInt);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeSet find " + searchedInt + " for time is");
        System.out.println(estimatedTime);
        System.out.println();


        for (int i = 0; i < countForHash; i++) {
            hashSet.remove(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("hashSet remove " + countForHash + " elements time is");
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            linkedHashSet.remove(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashSet remove " + countForHash + " elements time is");
        System.out.println(estimatedTime);


        startTime = System.nanoTime();
        for (int i = 0; i < countForHash; i++) {
            treeSet.remove(i);
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
            ran= (int) (Math.random()*200);
            hashMap.put(ran, Character.getName(ran));
            linkedHashMap.put(ran, Character.getName(ran));
            treeMap.put(ran, Character.getName(ran));
        }

        int countForMap = 10000;
        startTime = System.nanoTime();
        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            ran= (int) (Math.random()*2000);
            hashMap.put(ran, Character.getName(ran));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashMap add " + countForMap + " elements time is");
        System.out.println(estimatedTime);
//
        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            ran= (int) (Math.random()*2000);
            linkedHashMap.put(ran, Character.getName(ran));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedHashMap add " + countForMap + " elements time is");
        System.out.println(estimatedTime);

//
        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            ran= (int) (Math.random()*2000);
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







