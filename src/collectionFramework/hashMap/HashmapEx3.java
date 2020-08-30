package collectionFramework.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 이차원 배열과 비슷하게 값에 HashMap을 다시 넣은 것
 */
public class HashmapEx3 {

    static HashMap phoneBook = new HashMap();

    public static void main(String[] args) {
        addPhoneNo("친구", "이자바", "010-111-1111");
        addPhoneNo("친구", "김자바", "010-222-2222");
        addPhoneNo("친구", "김자바", "010-333-3333");
        addPhoneNo("회사", "김대리", "010-444-4444");
        addPhoneNo("회사", "김대리", "010-555-5555");
        addPhoneNo("회사", "박대리", "010-666-6666");
        addPhoneNo("회사", "이과장", "010-777-7777");
        addPhoneNo("세탁", "010-888-8888");

        printList();
    }

    // 그룹 추가
    // 그룹 명을 키로, HashMap 객체를 값으로
    static void addGroup(String groupName) {
        if (!phoneBook.containsKey(groupName)) {
            phoneBook.put(groupName, new HashMap());
        }
    }

    // 그룹에 전화번호 추가
    // 그룹에 키를 번호로, 값을 이름으로
    static void addPhoneNo(String groupName, String name, String tel) {
        addGroup(groupName);
        HashMap group = (HashMap) phoneBook.get(groupName);
        group.put(tel, name);
    }

    static void addPhoneNo(String name, String tel) {
        addPhoneNo("기타", name, tel);
    }

    // 전화번호부 전체를 출력하는 메서드
    static void printList() {
        Set set = phoneBook.entrySet(); // 키와 값을 반환
        Iterator it = set.iterator();

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();

            Set subSet = ((HashMap)e.getValue()).entrySet();
            Iterator subIt = subSet.iterator();

            System.out.println(" * " + e.getKey() + "[" + subSet.size() + "]");

            while (subIt.hasNext()) {
                Map.Entry subE = (Map.Entry) subIt.next();
                String telNo = (String) subE.getKey();
                String name = (String) subE.getValue();
                System.out.println(name + " " + telNo);
            }
            System.out.println();
        }
    }
}
