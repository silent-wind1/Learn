package main.java.test.strand;

import main.java.datastructure.strand.ArrayStrand;

public class ArrayStrandTest {
    public static void main(String[] args) {
        ArrayStrand strand = new ArrayStrand(5);
        strand.insert('a');
        strand.insert('b');
        strand.insert('c');
//        strand.toUpperCase();
//        ArrayStrand strand1 = new ArrayStrand(1);
//        strand.insert('B', 2);
//        for (Object s : strand) {
//            System.out.println(s);
//        }
//
//        System.out.println(strand.subString(1, 2));
        ArrayStrand t = new ArrayStrand(3);
        t.insert('a');
        t.insert('b');
        t.insert('c');
//        System.out.println(strand.compare(t));
        char[] c = {'a', 'b', 'c'};
//        System.out.println(strand.compare(c));
    }
}
