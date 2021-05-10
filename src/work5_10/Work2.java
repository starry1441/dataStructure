package work5_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -10
 * Time: 15:25
 */
public class Work2 {

    //通过反射创建对象
    public static void reflectNewInstance() {
        try {
            //1. 通过getClass获取Class对象
            Class<?> c1 = Class.forName("work5_10.Student");
            //2. 创建类的实例
            Student student = (Student) c1.newInstance();
            //3. 调用Student中的toString方法
            System.out.println(student);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // 反射获得公有的构造方法
    public static void reflectPrivateConstructor() {
        try {
            //1. 通过getClass获取Class对象
            Class<?> c1 = Class.forName("work5_10.Student");
            //2. 获取到不带有参数的构造方法
            //getConstructor()：公有的的构造方法
            Constructor<?> constructor = c1.getConstructor();
            //3. 通过构造方法创建类的实例
            Student student = (Student) constructor.newInstance();
            //4. 调用Student中的toString方法
            System.out.println(student);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // 反射获取私有的构造方法
    public static void reflectPrivateConstructor2() {
        try {
            //1. 通过getClass获取Class对象
            Class<?> c1 = Class.forName("work5_10.Student");
            //2. 获取到带有参数的构造方法
            //getDeclaredConstructor()：获取到所有的构造方法
            Constructor<?> constructor =
                    c1.getDeclaredConstructor(String.class,int.class);
            //3. 私有方法必须设置为true后可修改访问权限
            constructor.setAccessible(true);
            //4. 通过构造方法创建类的实例
            Student student = (Student) constructor.newInstance("狒狒",21);
            //5. 调用Student中的toString方法
            System.out.println(student);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // 反射获取属性
    public static void reflectPrivateField() {
        try {
            //1. 通过getClass获取Class对象
            Class<?> c1 = Class.forName("work5_10.Student");
            //2. 获取到全部的属性（包括私有的）
            //getField()：获取到公有的属性
            Field field = c1.getDeclaredField("name");
            //3. 私有属性必须设置为true后可修改访问权限
            field.setAccessible(true);
            //4. 通过构造方法创建类的实例
            Student student = (Student) c1.newInstance();
            //5. 更改student中的属性name
            field.set(student,"lala");
            //6. 调用Student中的toString方法
            System.out.println(student);
        } catch (ClassNotFoundException | NoSuchFieldException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //反射获取类中方法
    public static void reflectMethod() {
        try {
            //1. 通过getClass获取Class对象
            Class<?> c1 = Class.forName("work5_10.Student");
            //2. 获取到全部的方法（包括私有的）
            //getMethod()：获取到公有的方法
            Method method = c1.getDeclaredMethod("function", String.class);
            //3. 私有方法必须设置为true后可修改访问权限
            method.setAccessible(true);
            //4. 通过构造方法创建类的实例
            Student student = (Student) c1.newInstance();
            //5. 调用student对象中添加function方法
            method.invoke(student,"我是给私有的function函数传的参数");
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reflectNewInstance();
        reflectPrivateConstructor();
        reflectPrivateConstructor2();
        reflectPrivateField();
        reflectMethod();
    }

}
