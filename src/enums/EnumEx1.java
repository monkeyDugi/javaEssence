package enums;

enum Direction {

    EAST,
    SOUTH,
    WEST,
    NORTH
}
public class EnumEx1 {

    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        System.out.println("d1 == d2 ? " + (d1 == d2));
        System.out.println("d1 == d3 ? " + (d1 == d3));
        System.out.println("d1.equals(d3) ? " + (d1.equals(d3)));
//        System.out.println("d2 > d3 ? " + (d1 > d3)); // 에러 : >, < 사용 불가
        // 왼쪽이 크면 양수, 오른쪽이 크면 음수 반환(compareTo)
        System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
        System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));

        switch (d1) {
            case EAST: // Direction.EAST와 같음
                System.out.println("The direction is EAST.");
                break;
            case SOUTH:
                System.out.println("The direction is SOUTH.");
                break;
            case WEST:
                System.out.println("The direction is WEST");
                break;
            case NORTH:
                System.out.println("The direction is NORTH");
                break;
            default:
                System.out.println("Invalid direction.");
                break;
        }

        // enum의 모든 값 반환
        Direction[] dArr = Direction.values();

        for (Direction d : dArr) {
            System.out.println(d.name() + " = " + d.ordinal());
        }
    }
}
