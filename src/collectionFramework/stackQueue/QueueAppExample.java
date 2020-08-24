package collectionFramework.stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Queue의 활용
public class QueueAppExample {

    static Queue queue = new LinkedList();
    static final int MAX_SIZE = 5; // 큐에 5개까지만 저장되도록 한다.

    public static void main(String[] args) {

        System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

        while (true) {
            System.out.println(">>");

            try {
                // 화면으로 부터 라인단위로 입력 받는다.
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine().trim();

                if ("".equals(input)) continue;

                // 대소문자 구분 없이
                if (input.equalsIgnoreCase("q")) {
                    System.exit(0);
                } else if (input.equalsIgnoreCase("help")) {
                    System.out.println(" help - 도움말을 보여줍니다. ");
                    System.out.println(" q 또는 Q - 프로그램을 종료합니다. ");
                    System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE +"개 보여 줍니다.");
                } else if (input.equalsIgnoreCase("history")) {
                    save(input); // 입력받은 명령어를 저장하고,

                    // LinkedList의 내용을 보여준다.
                    // Queue는 기능이 별로없어 LinkedList로 형변환 하여 사용
                   LinkedList list = (LinkedList)queue;

                   for (int i = 0; i < list.size(); i++) {
                       System.out.println((i+1) +"." + list.get(i));
                   }
                } else {
                    save(input);
                }
            } catch (Exception e) {
                System.out.println("입력오류 입니다.");
            }
        }
    } // main()

    public static void save(String input) {
        // queue에 저장
        if (!"".equals(input)) queue.offer(input);

        // queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
        if (queue.size() > MAX_SIZE) queue.remove(); // size()는 Collection 인터페이스에 정의
    }
}
