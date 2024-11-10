package lec5;

public class  DLList<store>{
    //在小尖角括号中的提示符号实际上是储存数据类型用的
    // DLList :doubly linked list
        private IntNode first;
        private int size;
        private IntNode sentinel;

        public class IntNode {
            public store item;
            public IntNode next;
            public IntNode prev;

            public IntNode(store i, IntNode n, IntNode p){
                item = i;
                next = n;
                prev = p;
            }
        }

        public DLList(store x){
            sentinel = new IntNode(null, null, null);
            sentinel.next = new IntNode(x, null, null);
            size = 1;
        }

    /* 创建一个空列表 */
    public DLList(){
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /* 在链表中添加元素 */
    public void addfirst(store x){
        IntNode newNode = new IntNode(x, sentinel.next, sentinel);
        sentinel.next.prev = newNode; //将第一个节点的prev指向新节点
        sentinel.next= newNode; //next 指向新节点
        
        // first = new IntNode(x, first);
        size ++;
    }

    /* 获得链表中的第一个元素 */
    public store getfirst(){
        if(size == 0){
            return null;
        }
        return sentinel.next.item;
    }

    /* 在链表的最后一位添加元素 */
    public void addlast(store x){
        IntNode newNode = new IntNode(x, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        //size ++;
        //IntNode p = sentinel;

        ///* p一直遍历到结尾 */
        //while (p.next != null){
            //p = p.next;
        //}
        ///*
        //通过 p 修改节点的属性会影响 first，因为它们指向相同的对象。
        //改变 p 的引用本身不会影响 first，first 仍然指向链表的头部。
         //*/

        //p.next = new IntNode(x, null);
    }
    public static void main(String[] args) {
        DLList<String> L = new DLList<>();
        /*
            引用类型与基本数据类型的区别：
            引用类型（如 String, Integer, Double）是 Java 的类对象，可以与泛型一起使用。
            基本数据类型（如 int, char, float）是非对象类型，不能直接作为泛型参数。
            小写的是数据类型 大写的是一个类
        */
        L.addlast("hello");
        System.out.println(L.getfirst());
    }
}

    
