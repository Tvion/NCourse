package com.tvion.forth;

import com.tvion.first.MyTriangle;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {

        /*
        *                       LinkedList vs ArrayList
        *   Добавление в ArrayList получается медленнее, т.к. необоходимо переодически увеличивать массив
        * при его заполнии (Создание новго массива, копирование в него значений существующего)
        *
        *   Вставка в один из этих двух списков зависит от позиции на которую необходимо произвести вставку
        * При большом размере коллекции
        * ArrayList: Быстрая вставка в конце, медленная в начале ( Необходимость сдвигать последующие элементы)
        * LinkedList: Быстрая вставка в начале и в конце (т.к. двусвязный) медленная в середине
        * ( Большие затраты на получение нужного элемента)
        *
        *   С удалением дела обстоят так же как и с вставкой.
        *
        *                       Множества
        *   ThreeSet является самым медленным множеством по результатам выполнения основных операций,
        * его стоит использовать когда необходимо упорядочить элементы внутри множества.
        * HashSet и LinkedSet меют постоянное время для основных операций.
        *
        *                       Отображения
        *   ThreeMap так же является самым медленным отображением.
        *   Постоянное время для основных операций у HashMap и HashSet.
        *
        *
        * */

        long startTime;
        long estimatedTime;
        int size = 10000;
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

        int position = 5000;

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


        System.out.println();
        System.out.println("*****COMPARE_SETS*****");
        System.out.println();


        int countForSet = 100000;
        mt= new MyTriangle[countForSet];

        for(int i=0;i<countForSet;i++){
            mt[i]=new MyTriangle(0.0, 0.0, (double) i, (Math.random() * 10 - 5) * i, i+5.0, 5.0);
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


        System.out.println();
        System.out.println("*****COMPARE_MAPS*****");
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

        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            ran = (int) (Math.random() * 2000);
            linkedHashMap.put(ran, Character.getName(ran));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedHashMap add " + countForMap + " elements time is");
        System.out.println(estimatedTime);

        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            ran = (int) (Math.random() * 2000);
            treeMap.put(ran, Character.getName(ran));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("TreeHashMap add " + countForMap + " elements time is");
        System.out.println(estimatedTime);


        System.out.println();


        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            hashMap.remove(i, Character.getName(i));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashMap remove " + countForMap + " elements time is");
        System.out.println(estimatedTime);

        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            linkedHashMap.remove(i, Character.getName(i));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedHashMap remove " + countForMap + " elements time is");
        System.out.println(estimatedTime);

        for (int i = sizeForMap; i < sizeForMap + countForMap; i++) {
            treeMap.remove(i, Character.getName(i));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("TreeHashMap remove " + countForMap + " elements time is");
        System.out.println(estimatedTime);
    }


}







