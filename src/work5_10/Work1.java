package work5_10;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -10
 * Time: 14:27
 */

class Student{
    //私有属性name
    private String name = "xing";
    //公有属性age
    public int age = 21;
    //不带参数的构造方法
    public Student(){
        System.out.println("Student()");
    }
    private Student(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student(String,name)");
    }
    private void eat(){
        System.out.println("eating");
    }
    public void sleep(){
        System.out.println("sleeping");
    }
    private void function(String str) {
        System.out.println(str);
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Work1 {

    public static void main(String[] args) throws ClassNotFoundException {
        //1.使用 Class.forName("类的全路径名"); 静态方法
        Class<?> c1 = Class.forName("work5_10.Student");

        //2.使用 .class 方法
        Class<?> c2 = Student.class;

        //3.使用类对象的 getClass() 方法
        Student s = new Student();
        Class<?> c3 = s.getClass();

        System.out.println(c1);

    }

}
