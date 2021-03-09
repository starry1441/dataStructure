package work3_7;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -03 -07
 * Time: 19:34
 */

class Student {
    String name;
    int age;
    float score;
    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

public class Work4 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(5);
        list.add(16);
        list.add(81);
        list.add(22);
        Collections.sort(list);
        System.out.println(list);   //[5, 12, 16, 22, 81]
    }

    public static void main1(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("星星",12,88));
        list.add(new Student("狒狒",22,68));
        list.add(new Student("阿星",32,55));
        //fori
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //foreach
        for(Student student : list) {
            System.out.println(student);
        }
        //iterator
        Iterator<Student> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        //sout
        System.out.println(list);
    }
}
