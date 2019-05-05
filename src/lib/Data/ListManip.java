package lib.Data;

import lib.Misc.Randomizer;

import java.util.ArrayList;

import static lib.Misc.IO.scanInt;

public class ListManip {
    public static <E> void printList(ArrayList<E> list) {
        printList(list, 0, list.size() - 1, false, 0);
    }

    public static <E> void printList(ArrayList<E> list, boolean withIndex){
        printList(list,0, list.size()-1, withIndex, 0);
    }

    public static <E> void printList(ArrayList<E> list, boolean withIndex, int firstIndex) {
        printList(list, 0, list.size() - 1, withIndex, firstIndex);
    }

    public static <E> void printList(ArrayList<E> list, int start, int end, boolean withIndex, int firstIndex) {
        String index = "";
        if (!(start > list.size() - 1 || end > list.size() - 1 || start < 0 || end < 0))
            for (int i = start; i < list.size() && i <= end; i++) {
                if (withIndex)
                    index = (i + firstIndex) + " ";
                System.out.println(index + list.get(i).toString());
            }
    }

    public static int[][] listToMatrix(ArrayList<int[]> list) {
        int[][] array = new int[list.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static <E extends Number> double max(ArrayList<E> list) {
        if (list == null || list.size() == 0)
            return 0;
        double max = list.get(0).doubleValue();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).doubleValue() > max)
                max = list.get(i).doubleValue();
        }
        return max;
    }


    public static <E> void shuffle(ArrayList<E> list){
        for (int i = 0; i < list.size(); i++) {
            int randIndex = Randomizer.randomInt(list.size()-1);
            E temp = list.get(i);
            list.set(i, list.get(randIndex));
            list.set(randIndex, temp);
        }
    }

    public static ArrayList<Integer> listFromScanner() {
        ArrayList<Integer> list = new ArrayList<>();
        int i;
        while (true) {
            i = scanInt();
            if (i == 0)
                break;
            list.add(i);
        }
        return list;
    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list){
        for (int i = 0; i < list.size() -1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0 ){
                    E e = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j, e);
                }
            }
        }
    }

    public static <E extends Number> double sum(ArrayList<E> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).doubleValue();
        }
        return sum;
    }

    public static <E> void removeDuplicate(ArrayList<E> list) {
        ArrayList<E> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); ) {
            if (list2.contains(list.get(i)))
                list.remove(i);
            else {
                list2.add(list.get(i));
                i++;
            }
        }
    }

    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> union = new ArrayList<>(list1.size() + list2.size());
        union.addAll(list1);
        union.addAll(list2);
        return union;
    }

    public static ArrayList<Character> toCharList(String str) {
        ArrayList<Character> toCharList = new ArrayList<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            toCharList.add(str.charAt(i));
        }
        return toCharList;
    }
}
