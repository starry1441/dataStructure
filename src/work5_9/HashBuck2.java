package work5_9;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -09
 * Time: 17:22
 */

class Person {
    public Integer id;

    public Person(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class HashBuck2<K,V> {
    static class Node<K,V> {
        public K key;
        public V val;
        public Node<K,V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K,V>[] array;
    public int usedSize;

    public HashBuck2() {
        this.array = new Node[8];
    }

    public void push(K key, V val) {
        int hash = key.hashCode();
        int index = hash % array.length;

        Node<K,V> node = new Node<>(key,val);
        Node<K,V> cur = array[index];
        Node<K,V> pre = cur;
        while (cur != null) {
            if(cur.key.equals(key)) {
                cur.val = val;
                return;
            }
            pre = cur;
            cur = cur.next;
        }
//        node.next = array[index];
//        array[index] = node;

        //尾插
        if(pre == null) {
            array[index] = node;
        }else {
            pre.next = node;
        }
        this.usedSize++;

        //负载因子调整
        if (loadFactor() >= 0.75) {
            resize();
        }
    }

    /**
     * 求负载因子
     * @return
     */
    public double loadFactor() {
        return this.usedSize*1.0 / this.array.length;
    }

    /**
     * 超过了负载因子，我们需要进行扩容
     */
    public void resize() {
        Node<K,V>[] newArray = new Node[2*array.length];
        //遍历原来的数组，把原来数组里面的每个元素都进行重新哈希
        for (int i = 0; i < array.length; i++) {
            Node<K,V> cur = array[i];
            while (cur != null) {
                int index = cur.hashCode() % newArray.length;
                Node<K,V> curNext = cur.next;
//                cur.next = newArray[index];
//                newArray[index] = cur;
//                cur = curNext;
                //尾插
                Node<K,V> ind = newArray[index];
                if(ind == null) {
                    newArray[index] = cur;
                }else {
                    Node<K,V> pre = ind;
                    while (ind != null) {
                        pre = ind;
                        ind = ind.next;
                    }
                    pre.next = cur;
                }
                cur.next = null;
                cur = curNext;
            }
        }
        //原来数组当中的数据 全部哈希到了 新的数组当中
        array = newArray;
    }

    public V get(K key) {
        int index = key.hashCode() % array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if(cur.key.equals(key)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        HashBuck2<Person,String> hashBuck2 = new HashBuck2<>();
        Person person1 = new Person(1);
        Person person2 = new Person(20);
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
    }

}
