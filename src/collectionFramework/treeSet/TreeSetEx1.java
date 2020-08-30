package collectionFramework.treeSet;

import java.util.TreeSet;

/**
 * 대문자 -> 소문자 사전 순 정렬
 */
public class TreeSetEx1 {

    public static void main(String[] args) {
        TreeSet set = new TreeSet();

        String from = "b";
        String to   = "d";

        set.add("abc");      set.add("alien");    set.add("bat");
        set.add("car");      set.add("Car");      set.add("disc");
        set.add("dance");    set.add("DZZZZ");    set.add("dzzzz");
        set.add("elephant"); set.add("elevator"); set.add("fan");
        set.add("flower");

        System.out.println(set);
        // to 이전까지 검색
        // to + "zzz" : dzzz    이전까지!! 하나끼 모든 d로 시작하는게 dzzz를 제외하고 나옴
        System.out.println("range search : from " + from + " to " + to);
        System.out.println("result1 : " + set.subSet(from, to));
        System.out.println("result2 : " + set.subSet(from, to + "zzz"));
    }
}
