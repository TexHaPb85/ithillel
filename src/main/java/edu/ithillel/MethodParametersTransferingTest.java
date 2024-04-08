package edu.ithillel;

import java.util.ArrayList;
import java.util.List;

public class MethodParametersTransferingTest {
    public static void main(String[] args) {
        String s = "1234567890";
        char searchTo = '7';
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == searchTo) {
                System.out.println("index of search to " + i);
            }
        }
    }

    public static int indexOf(String s, char searchTo, int index) {
        if(s.charAt(0) == searchTo) {
            return index;
        }
        return indexOf(s.substring(1), searchTo, index+1);
    }

}