package abstractTest;

// 異붿긽 �겢�옒�뒪 �궗�슜踰뺤뿉 ���빐�꽌 �븣�븘蹂닿린
public class AbstractMake {

    public static void main(String[] args) {
        // 異붿긽�솕 �쟾
//        Marine marine = new Marine();
        // 異붿긽�솕 �븯吏� �븡怨� 諛붾줈 援ы쁽�쑝濡� �궗�슜�븯硫� Maring, Tank, DropShip 紐⑤몢 媛곴컖
        // move�� stop�쓣 留뚮뱾�뼱二쇱뼱�빞 �븯怨�, 源뚮㉨寃� �맆 寃쎌슦媛� 諛쒖깮�븷 �닔 �엳�떎�뒗 �떒�젏�씠 �엳�떎.
//        marine.move(1, 2);
//        marine.stop();

        // 異붿긽�솕 �썑
        Unit[] group = new Unit[3];
        group[0] = new Marine();
        group[1] = new Tank();
        group[2] = new DropShip();

        for (int i = 0; i < group.length; i++) {
            // 紐⑤뱺 �쑀�떅�쓽 �옄�몴瑜� 100, 200�쑝濡� �꽕�젙
            group[i].move(100, 200);
            group[i].stop();//dddddddddd
        }
    }
}

// 異붿긽�솕 �겢�옒�뒪濡� 怨듯넻湲곕뒫 異붿텧
// 紐⑤뱺 �쑀�떅�� �씠�룞�빐�빞�븯�뒗 醫뚰몴媛� �떎瑜닿린 �븣臾몄뿉 異붿긽�솕
// 硫덉텛�뒗 寃껋� 紐⑤몢 媛숈쑝誘�濡� 援ъ껜�솕
abstract class Unit {
    int x, y;

    abstract void move(int x, int y); // �븘�닔 湲곕뒫�쑝濡� 異붿긽 硫붿꽌�뱶 援ы쁽
    void stop() { System.out.println("stop"); } // 異붿긽 硫붿꽌�뱶�뒗 �븘�땲吏�留� 怨듯넻 湲곕뒫�씠誘�濡� 異붿긽 �겢�옒�뒪�뿉 援ы쁽
}

// 以묐났 肄붾뱶 諛쒖깮�쑝濡� 異붿긽 �겢�옒�뒪濡� 怨듯넻�쑝濡� 類� �닔 �엳�떎.
// int x, y
// move()
// stop()
//class Marine { // 異붿긽�솕 �쟾
    class Marine extends Unit { // 異붿긽�솕 �썑

    // 異붿긽�솕 �쟾
    //
//    int x, y; // �쁽�옱�쐞移�
//    void move(int x, int y) { System.out.println("Marine move"); }
//    void stop () { System.out.println("stop"); }

    // 異붿긽�솕 �썑
    // 異붿긽�솕瑜� �뿬 諛섎뱶�떆 援ы쁽�븯�룄濡�
    @Override
    void move(int x, int y) { System.out.println("Marine move"); }

    void steamPack() { System.out.println("Marine steamPack"); }
}

//class Tank {
    class Tank extends Unit {

//    int x, y; // �쁽�옱�쐞移�
//    void move(int x, int y) { System.out.println("Tank move"); }
//    void stop () { System.out.println("stop"); }

    // 異붿긽�솕 �썑
    @Override
    void move(int x, int y) { System.out.println("Tank move"); }

    void chaneMode() { System.out.println("Tank changeMode"); }
}

//class DropShip {
    class DropShip extends Unit {

//    int x, y; // �쁽�옱�쐞移�
//    void move(int x, int y) { System.out.println("DropShip move"); }
//    void stop () { System.out.println("stop"); }

    // 異붿긽�솕 �썑
    @Override
    void move(int x, int y) { System.out.println("DropShip move"); }

    void load() { System.out.println("DropShip load"); }
    void unload() { System.out.println("DropShip unload"); }
}


