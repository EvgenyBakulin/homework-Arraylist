package ru.skypro;

public class Main {

    public static void main(String[] args) {
        MyStringList list = new MyStringArrayList();
        MyStringList otherlist = new MyStringArrayList();
        System.out.println(list.isEmpty());
        list.add("aaa");
        list.add("bbb");
        otherlist.add("aaa");
        otherlist.add("bbb");
        System.out.println(list.equals(otherlist));
        list.add(1, "ccc");
        System.out.println(list);
        list.set(1, "ddd");
        System.out.println(list);
        System.out.println(list.size());
        list.remove("aaa");
        System.out.println(list);
        list.add("aaa");
        System.out.println(list.indexOf("bbb"));
        System.out.println(list.lastIndexOf("aaa"));
        String[] arr = list.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        list.remove(0);
        System.out.println(list);
        list.clear();
        System.out.println(list);
    }
}
