package interfaceTest;

// 인터페이스의 다형성에 대해서 알아보기
public class ParserTest {

    public static void main(String[] args) {
        // 문서 타입이 계속 추가 되어도 변경없이 아래와 같이 문서 타입만 넘겨주면 된다.
        // 즉, main메서드가 사용자라고 치면, 사용자 측은 변경없이 ParserManager(서버)측만
        // 변경해주면 되므로 혼란이 없다.
        Parserable parser = ParserManager.getParse("XML");
        parser.parse("document.xml");

        parser = ParserManager.getParse("HTML");
        parser.parse("document2.html");

        parser = ParserManager.getParse("JSON");
        parser.parse("document3.json");

        // 인터페이스가 없다면??
        // 아래와 같이 사용해야 한다.
        // 즉, 위와 다르게 메서드가 달라지기 때문에 헷갈릴 수 있다.
        // ParserManager에서 오버로드 해서 사용한다고 해도, ParserManager에서 불편한건 같고,
        // 여기서도 리턴 타입이 다르므로 변함없다.
//        XMLParser xmlParser = ParserManager.getXmlParse("XML");
//        HTMLParser htmlParser = ParserManager.getHtmlParse("HTML");
//        JSONParser jsonParser = ParserManager.getJsonParse("JSON");
    }
}

// 구문을 분석할 인터페이스(다형성을 위함)
interface Parserable {
    // 구문 분석작업 수행
    public abstract void parse(String fileName);
}

class ParserManager {

    // 리턴 타입이 Paserable 인터페이스이다.
    // 문서타입이 추가 되어도 하나의 메서드로 그대로 사용이 가능하다.
    // 리턴 타입이 인터페이스로 동일하기 때문에 가능하다.
    public static Parserable getParse(String type) {
        if (type.equals("XML")) { return new XMLParser(); }
        else if (type.equals("HTML")) { return new HTMLParser(); }
        return new JSONParser();
    }

    // 인터페이스가 없다면??
    // 아래와 같이 다른 해당 타입으로 리턴을 해주어야 한다.
    // 즉, 메서드가 계속 추가되어야 하며, 오버로딩 해서 사용한다고 해도, 메서드가 추가 되는건 변함이 없다.
//    public static XMLParser getXmlParse(String type) { 생략 };
//    public static HTMLParser getHtmlParse(String type) { 생략 };
//    public static JSONParser getJsonParse(String type) { 생략 };
}

// XML 파서
class XMLParser implements Parserable {
    public void parse(String fileName) {
        // 구문 분석작업 수행하는 코드 작성
        System.out.println(fileName + "- XML parsing completed");
    }
}

// HTML 파서
class HTMLParser implements Parserable {
    public void parse(String fileName) {
        // 구문 분석작업 수행하는 코드 작성
        System.out.println(fileName + "- HTML parsing completed");
    }
}

// JSON 파서
class JSONParser implements Parserable {
    public void parse(String fileName) {
        // 구문 분석작업 수행하는 코드 작성
        System.out.println(fileName + "- JSON parsing completed");
    }
}