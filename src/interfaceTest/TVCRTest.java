package interfaceTest;

// 인터페이스를 이용한 다중상속
public class TVCRTest {

    public static void main(String[] args) {
        TVCR tvcr = new TVCR();

        tvcr.play();
        tvcr.stop();
        tvcr.setCounter(10);
        System.out.println("set counter : " + tvcr.getCounter());
        tvcr.reset();
        System.out.println("reset counter : " + tvcr.getCounter());
    }
}

// IVCR을 구현 받아 다중상속 효과를 낸다.
// VCR 클래스와 동일한 추상메서드를 선언 했으므로 반드시 오버라이딩 해야하고,
// VCR 클래스를 멤버로 가져, VCR 클래스의 기능을 그대로 사용하게 된다.
// Tv 클래스는 상속받고, VCR 클래스는 IVCR인터페이스로 구현하였는데, 기준은 더 중요한 사항을 상속받고,
// 덜 중요한 사항을 멤버로 가지도록 한 것 이다.
class TVCR extends Tv implements IVCR {
    VCR vcr = new VCR();

    @Override
    public void play() { vcr.play(); }

    @Override
    public void stop() { vcr.stop(); }

    @Override
    public void reset() { vcr.reset(); }

    @Override
    public int getCounter() { return vcr.getCounter(); }

    @Override
    public void setCounter(int counter) { vcr.setCounter(counter); }
}

class Tv {
    boolean power;
    int channel;
    int volume;

    void power() { power  = !power; }
    void channelUp() { channel++; }
    void channelDown() { channel--; }
    void volumeUp() { volume++; }
    void volumeDown() { volume--; }
}

class VCR {
    int counter; // vcr의 카운터

    void play() { System.out.println("재생"); }
    void stop() { System.out.println("정지"); }
    void reset() { counter = 0; }
    int getCounter() { return counter; }
    void setCounter(int counter) { this.counter = counter; }
}

// 클래스는 다중상속이 불가하기 때문에 인터페이스로 VCR 클래스에 정의된 메서드와 일치하는 추상메서드를 만든다.
interface IVCR {
    void play();
    void stop();
    void reset();
    int getCounter();
    void setCounter(int counter);
}