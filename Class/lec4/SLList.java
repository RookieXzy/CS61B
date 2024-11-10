package lec4;

public class SLList {
     //public IntNode first ;
  private IntNode first;
    private int size;
    private IntNode sentinel;
    /*
    Intnode first 这种类型变量时不需要用户在使用的时候考虑的
    所以需要使用private 在用户试图访问这个变量的时候提出警告
     */
    public SLList(int x){
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /* 创建一个空列表 */
    /*
    当使用addlast函数时 因为first是null不能从null中寻找下一个null
    所以我们需要一个哨兵变量 (sentinel) 通过sentinel.next去访问 链表中的第一个变量
    如果在addlast多加特殊情况的考虑 会让这个方法变得冗余
    尽量不要在函数中写太多的特殊情况 这会影响数据结构 尤其是对于大项目来说 方法越多特殊情况越多
    会导致项目很难修改bug 很难开发新东西
     */
    public SLList(){
        sentinel = new IntNode(0, null);
        size = 0;
    }

    /* 在链表中添加元素 */
    public void addfirst(int x){
        sentinel.next= new IntNode(x, sentinel.next);
        // first = new IntNode(x, first);
        size ++;
    }

    /* 获得链表中的第一个元素 */
    public int getfirst(){
        return sentinel.next.item;
    }

    /* 在链表的最后一位添加元素 */
    public void addlast(int x){
        size ++;
        IntNode p = sentinel;

        /* p一直遍历到结尾 */
        while (p.next != null){
            p = p.next;
        }
        /*
        通过 p 修改节点的属性会影响 first，因为它们指向相同的对象。
        改变 p 的引用本身不会影响 first，first 仍然指向链表的头部。
         */

        p.next = new IntNode(x, null);
    }

    /* 返回链表的长度 */
//    public int size(){
//        return size;
//        return size(first);
//    }

    /* 返回链表的长度 通过引入一个IntNode参数实现
    private int size(IntNode p){
        if (p.next == null){
            return 1;
        }
        return 1 + size(p.next);
    }
    这种方法太慢了 需要花费函数运行的时间
    我们取代的是时刻跟踪链表的元素值 使用size随时修改最终返回
    */

/*
不能直接通过p.next访问 size这些方法因为 size这些方法是SLList类的 而p.next是IntNode类型
first也只是SLList类中的一个参数
 */
}

/*
这样把IntNode封装起来是为了让用户更好使用
如果创建一个新的链表就可以SLList(int)
如果不封装起来 就是 IntNode(int, null)
添加元素也会很麻烦
 */