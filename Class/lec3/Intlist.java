package lec3;

public class Intlist {
    public int first;
    public Intlist rest;

    public Intlist(int f, Intlist r){
        first = f;
        rest = r;
    }

    //return an int value of length of Intlist by using recursion
    public int size(){
        if (rest == null){ //终止条件
            return 1;
        }   //递归步骤
        return 1 + rest.size();
    }
    /*
    终止条件（Base Case）：当满足一定条件时，直接返回结果，结束递归调用，避免无限循环。
    递归步骤（Recursive Step）：函数会调用自身，通常是通过改变参数使问题逐步简化，最终达到终止条件。
     */

    public int iteractivesize(){
        int total = 0;
        Intlist p = this;
        while (p != null){
            total++;
            p = p.rest;
        }
        return total;
    }

    public int get(int i){
        if (i == 0){
            return first;
        }
        return rest.get(i - 1);
    }

    public static void main(String[] args){
        Intlist L = new Intlist(15, null);
        L = new Intlist(10, L);
        L = new Intlist(5, L);
    }
}
