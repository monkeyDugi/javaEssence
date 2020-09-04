package enums;

enum Direction1 {

    EAST(1, ">"),
    SOUTH(2, "V"),
    WEST(3, "<"),
    NORTH(4, "^");

    private static final Direction1[] DIR_ARR = Direction1.values();
    private final int value;
    private final String symbol;

    // enum은 EAST, SOUTH... 등 모두 객체이기 때문에 생성자가 당연히 필요하다.
    // value, symbol이 없었다면, 기본 생성자를 사용하게 되어 만들어지게 된다.
    private Direction1(int value, String symbol) { // 기본이 private
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }
    public String getSymbol() {
        return symbol;
    }

    public static Direction1 of(int dir) {
        if (dir < 1 || dir > 4) {
            throw  new IllegalArgumentException("Invalid value : " + dir);
        }
        return DIR_ARR[dir - 1];
    }

    // 방향을 회전 시키는 메서드, num의 값 만큼 90씩 시계 방향으로 회전
    public Direction1 rotate(int num) {
        num = num % 4;

        // num이 음수일 때는 시계 반대 방향으로 회전
        if (num < 0) {
            num += 4;
        }

        return DIR_ARR[(value - 1 + num) % 4];
    }

    public String toString() {
        return name() + getSymbol();
    }
}

public class EnumEx2 {

    public static void main(String[] args) {
        for (Direction1 d : Direction1.values()) {
            System.out.println(d.name() + " = " + d.getValue());
        }

        Direction1 d1 = Direction1.EAST;
        Direction1 d2 = Direction1.of(1);

        System.out.println("d1 = " + d1.name() + ", " + d1.getValue());
        System.out.println("d1 = " + d2.name() + ", " + d2.getValue());
        System.out.println(Direction1.EAST.rotate(1));
        System.out.println(Direction1.EAST.rotate(2));
        System.out.println(Direction1.EAST.rotate(-1));
        System.out.println(Direction1.EAST.rotate(-2));
    }
}
