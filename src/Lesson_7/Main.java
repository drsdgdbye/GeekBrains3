package Lesson_7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        start(TestClass.class);
    }

    public static void start(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        ArrayList<Method> list = new ArrayList<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                int priority = m.getAnnotation(Test.class).priority();
                if (priority < 1 || priority > 10) {
                    throw new RuntimeException("приоритет от 1 до 10");
                }
                list.add(m);
            }
        }
        list.sort((o1, o2) -> o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority());
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (list.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException("beforesuite должен быть в единственном экземпляре");
                }
                list.add(0, m);
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (list.get(list.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException("AfterSuite должен быть в единственном экземпляре");
                }
                list.add(list.size() - 1, m);
            }
        }
        for (Method m : methods) {
            try {
                m.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
