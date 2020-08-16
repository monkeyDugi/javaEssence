package abstracttt.abstractClassAndAbstractMethod;

// 추상 클래스와 추상 메서드란 무엇인가?
public class AbstractClassAndAbstractMethod {

    public static void main(String[] args) {
        Player p = new AudioPlayer();
        AudioPlayer audioPlayer = new AudioPlayer();

        // 오버라이딩을 하여 지정을 해주지 않으면, 객체 생성이 불가하다.
        // 미완성이기 때문
        Player p1 = new Player() {
            @Override
            void play() {
                System.out.println("new Player로 객체 생성(play())");
            }

            @Override
            void stop() {
                System.out.println("new Player로 객체 생성(play())");
            }
        };

        // 완전한 구현 클래스가 아니기 때문에 객체 생성이 불가 하지만 생성하면서 구현을 해줌
        Player p2 = new MusicPlayer() {
            @Override
            void stop() {
                System.out.println("stop을 오버라이딩 하지 않아 객체생성 불가하여 객체 생성하며 오버라이딩");
            }
        };

        // 상속 받았으므로 구현부인 AudioPlayer의 구현 메서드를 바라본다.
        p.play();
        p.stop();

        System.out.println();

        // 자신의 클래스에 구현 되었으므로 p와 동일
        audioPlayer.play();
        audioPlayer.stop();

        System.out.println();

        p1.play();
        p1.stop();

        System.out.println();

        p2.play();
        p2.stop();
    }
}

// 추상 클래스
// 미완성 설계도로써, 멤버와는 무관하고, 추상(미완성)메서드가 존재하는 것 이다.
// 미완성 이므로 자손클래스에 의해서만 인스턴스 생성이 가능하다.
// 추상 메서드를 포함하고 있다는 것 을 제외하면 일반 클래스오 다른 것이 전혀 없다.
// 즉, 일반 클래스와 같이 로직을 가질 수 있다.
abstract class Player {

    abstract void play(); // 추상 메서드
    abstract void stop();        // 추상 메서드
}

// 추상 메서드를 구현하여 사용가능
class AudioPlayer extends Player {
    @Override
    void play() {
        System.out.println("Player 클래스의 play() 구현");
    }

    @Override
    void stop() {
        System.out.println("Player 클래스의 stop() 구현");
    }
}

// 추상 클래스를 상속받고, 추상 메서드를 구현 하지 않는다면, 완벽한 구현 클래스가 아니끼 때문에 추상 클래스가 된다.
// 추상 클래스로 선언 해주지 않으면, 에러
// 즉 객체생성이 불가하다.
abstract class MusicPlayer extends Player {
    @Override
    void play() {
        System.out.println("Player 클래스의 play() 구현");
    }
}