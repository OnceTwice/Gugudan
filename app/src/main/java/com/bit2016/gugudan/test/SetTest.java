package com.bit2016.gugudan.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cho on 2016-12-04.
 */

public class SetTest {
    public static void main(String[] args) {
        Set<Multiplication> set = new HashSet();

        while(set.size() != 9) {
            int left = randomize(1, 9);
            int right = randomize(1, 9);
            set.add(new Multiplication(left, right));
        }

        int indexRandom = randomize(0, 8);
        int index = 0;
        for(Multiplication mul : set) {
            // System.out.println(mul);        // sout

            if(index == indexRandom) {
                System.out.println("===제출================>" + mul);
            } else {
                System.out.println(mul);
            }
            index++;
        }
    }

    private static int randomize(int from, int to) {
        return (int)(Math.random() * to) + from;
    }

    private static class Multiplication {
        private int left;
        private int right;

        public Multiplication(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Multiplication{" +
                    "left=" + left +
                    ", right=" + right +
                    ", product=" + left * right +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Multiplication that = (Multiplication) o;

            return right*left == that.right*that.left;
        }

        @Override
        public int hashCode() {
            return 31*(left*right);
        }
    }
}
