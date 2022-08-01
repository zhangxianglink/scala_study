package book.chapter4.six;

/**
 * @author xiangzhang
 * @since 2022-07-29 10:33
 */
public class StaticTest {
    private static String name = "wink";

    private String a;
    private String b;

    public StaticTest(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public void updateName(String name){
        StaticTest.name = name;
    }

    public static void main(String[] args) {
        System.out.println(StaticTest.name);
        final StaticTest staticTest2 = new StaticTest("ccc", "ddd");
        staticTest2.updateName("will");
        System.out.println(StaticTest.name);
    }
}
