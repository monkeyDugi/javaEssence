package annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 해당 어노테이션이 붙으면 구 버전이므로 사용하지 않을 것을 권장
@Deprecated
// 유효하지 않은 애너테이션은 무시한다.
// 무시하고 싶은 경고 명을 적으면 된다.
// 여기서는 뭐 없고, ex) @SuppressWarnings("unchecked")
@SuppressWarnings("1111")
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "200101", hhmss = "235959"))
public class AnnotationEx {

    public static void main(String[] args) {
        // AnnotationEx의 class 객체를 얻는다.
        Class<AnnotationEx> cls = AnnotationEx.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testType() = " + anno.testType());
        System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss() = " + anno.testDate().hhmss());

        for (String str : anno.testTools()) {
            System.out.println("testTools = " + str);
        }
        System.out.println();

        // AnnotationEx에 적용된 모든 애너테이션을 가져온다.
        Annotation[] annoArr = cls.getAnnotations();

        for (Annotation a : annoArr) {
            System.out.println(a);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME) // 실행 시에 사용 가능하도록 지정
@interface TestInfo {
    int count()            default 1;
    String testedBy();
    String[] testTools()   default "JUnit";
    TestType testType()    default TestType.FIRST;
    DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME) // 실행 시에 사용 가능하도록 지정
@interface DateTime {
    String yymmdd();
    String hhmss();
}

enum TestType {
    FIRST, FINAL
}
