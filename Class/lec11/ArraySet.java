package lec11;

import java.util.*;
public class ArraySet<T> {
    private T[] items;
    private int size;
    //构造函数
    public ArraySet() {
        size = 0;
        items = (T[]) new Object[100];
    }

    // 如果在列表中有x变量 就返回True 否则返回false
    public boolean contains(T x){
        for (int i = 0; i < size; i++){
            if(x.equals(items[i])){
                return true;
            }
        }
        return false;
    }// 不能写 x == items[i] 因为如果传入了字符串变量 即便字符串内容相同 但内存地址不同 一直都是false

    // ArraySet数组不能有重复的元素 所以 要先检查
    public void add(T x){
        if (contains(x)){
            return ;
        }
        items[size] = x;
        size++;
    }

    //返回size
    public int size(){
        return size;
    }

    public static void main(String[] args){
        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
    }
}
