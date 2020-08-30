package collectionFramework.treeSet;

/**
 * 문자열의 정렬 순서는 문자의 코드 값이 기준이 되므로, 오름차순 정렬의 경우 코드 값의 크기가 작은 순서에서 큰 순서,
 * 즉ㄱ 공백 -> 숫자 -> 대문자 -> 소문자 순으로 정렬되고,
 * 내림차순은 반대가 된다. 알아두자.
 */
public class AsciiPrint {

    public static void main(String[] args) {
        char ch = ' ';
        for (int i = 0; i < 95; i++) {
            System.out.print(ch++);
        }
    }
}
