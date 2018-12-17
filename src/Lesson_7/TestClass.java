package Lesson_7;

public class TestClass {

    @BeforeSuite
    public static void method1(){
        System.out.println("method1");
    }

    @Test(priority = 6)
    public static void method2(){
        System.out.println("method2");
    }

    @Test(priority = 3)
    public static void method3(){
        System.out.println("method3");
    }

    @AfterSuite
    public static void method4(){
        System.out.println("method4");
    }
}
