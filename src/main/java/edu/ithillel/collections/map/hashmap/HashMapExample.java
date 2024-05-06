package edu.ithillel.collections.map.hashmap;

import java.util.HashSet;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        Set<MyObject> set = new HashSet<>();
        set.add(new MyObject(1, "A"));
        set.add(new MyObject(3, "C"));
        set.add(new MyObject(2, "B"));
        set.add(new MyObject(4, "A"));
        set.add(new MyObject(5, "C"));
        set.add(new MyObject(6, "B"));
        set.add(new MyObject(7, "A"));
        set.add(new MyObject(8, "C"));
        set.add(new MyObject(9, "B"));
        set.add(new MyObject(10, "A"));
        set.add(new MyObject(11, "C"));
        set.add(new MyObject(12, "B"));
        set.forEach(System.out::println);
    }

    static class MyObject {
        private int id;
        private String name;

        public MyObject(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyObject{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
