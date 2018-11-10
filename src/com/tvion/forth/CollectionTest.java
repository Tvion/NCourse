package com.tvion.forth;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        long startTime;
        long estimatedTime;
        int size=10000;
    List<Integer> arrayList= new ArrayList<>();
    List<Integer> linkedList= new LinkedList<>();
        Set<Integer> hashSet=new HashSet<>();
        Set<Integer> linkedHashSet=new LinkedHashSet<>();
        Set<Integer> treeSet=new TreeSet<>();
    for(int i=0;i<size;i++){
        arrayList.add(i);
        linkedList.add(i);
        hashSet.add(i);
        linkedHashSet.add(i);
        treeSet.add(i);
    }
    int count=1000;
    startTime=System.nanoTime();
    for(int i=0;i<count;i++){
        arrayList.add(i);
    }
    estimatedTime=System.nanoTime()-startTime;
        System.out.println("ArrayList add "+count+" elements time = "+ estimatedTime);

        startTime=System.nanoTime();
        for(int i=0;i<count;i++){
            linkedList.add(i);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("LinkedList add "+count+" elements time = "+ estimatedTime);

        int position=1000;

        startTime=System.nanoTime();
        for(int i=0;i<count;i++){
            arrayList.add(position,i);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("ArrayList add to index "+count+" elements time = "+ estimatedTime);

        startTime=System.nanoTime();
        for(int i=0;i<count;i++){
            linkedList.add(position,i);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("LinkedList add to index "+count+" elements time = "+ estimatedTime);



        startTime=System.nanoTime();
        for(int i=0;i<count;i++){
            arrayList.remove(position);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("ArrayList add to index "+count+" elements time = "+ estimatedTime);

        startTime=System.nanoTime();
        for(int i=0;i<count;i++){
            linkedList.remove(position);
        }
        estimatedTime=System.nanoTime()-startTime;
        System.out.println("LinkedList add to index "+count+" elements time = "+ estimatedTime);
}



}


