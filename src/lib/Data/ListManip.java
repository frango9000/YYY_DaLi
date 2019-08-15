package lib.Data;

import static lib.Misc.IO.scanInt;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import lib.Misc.Randomizer;

public class ListManip {

    public static <E> void printList(Collection<E> list) {
        printList(list, 0, list.size() - 1, false, 0);
    }

    public static <E> void printList(Collection<E> list, boolean withIndex) {
        printList(list, 0, list.size() - 1, withIndex, 0);
    }

    public static <E> void printList(Collection<E> list, boolean withIndex, int firstIndex) {
        printList(list, 0, list.size() - 1, withIndex, firstIndex);
    }

    public static <E> void printList(
        Collection<E> list, int start, int end, boolean withIndex, int firstIndex) {
        String index = "";
        int indexNum = 0;
        Iterator<E> it = list.iterator();

        while (it.hasNext()) {
            if (start <= indexNum && end >= indexNum) {
                if (withIndex) {
                    index = (indexNum + firstIndex) + " ";
                }
                System.out.println(index + it.next());
            }
            indexNum++;
        }
    }

    public static <E, F> void printMap(Map<E, F> list) {
        list.forEach((e, f) -> System.out.println(e + " - " + f));
    }

    public static int[][] listToMatrix(ArrayList<int[]> list) {
        int[][] array = new int[list.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        E max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static <E extends Comparable<E>> E min(ArrayList<E> list) {
        E min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(min) < 0) {
                min = list.get(i);
            }
        }
        return min;
    }

    public static <E> void shuffle(AbstractList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            int randIndex = Randomizer.randomInt(list.size() - 1);
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
            if (i == 0) {
                break;
            }
            list.add(i);
        }
        return list;
    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    E e = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, e);
                }
            }
        }
    }

    public static <E extends Number> double sum(Collection<E> list) {
        return list.stream().mapToDouble(E::doubleValue).sum();
    }

    public static <E> void removeDuplicate(ArrayList<E> list) {
        ArrayList<E> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); ) {
            if (list2.contains(list.get(i))) {
                list.remove(i);
            } else {
                list2.add(list.get(i));
                i++;
            }
        }
    }

    public static <E> ArrayList<E> union(Collection<E> list1, Collection<E> list2) {
        ArrayList<E> union = new ArrayList<>(list1.size() + list2.size());
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
