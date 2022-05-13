package ru.skypro;

public class Main {

    public static void main(String[] args) {
        MyIntList list = new MyIntListArray();
        MyIntList otherlist = new MyIntListArray();
        System.out.println(list.isEmpty());
        list.add(10);
        list.add(15);
        otherlist.add(10);
        otherlist.add(15);
        System.out.println(list.equals(otherlist));
        list.add(1, 25);
        System.out.println(list);
        list.set(1, 33);
        System.out.println(list);
        System.out.println(list.size());
        list.remove(10);
        System.out.println(list);
        list.add(10);
        list.add(100);
        list.add(200);
        System.out.println(list);
        System.out.println(list.contains(100));
        System.out.println(list.indexOf(25));
        System.out.println(list.lastIndexOf(33));
        /*String[] arr = list.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
        list.clear();
        System.out.println(list);
        SortsComparation array = new SortsComparation();
        array.mostQuickSort();
    }
}
