/*package lec_test;

public class Sort {
    public static void sort(String[] x){
        //找到最小的数字
        //放到最前面
        //对数组进行排序 (冒泡排序
        int smallest = findSmallest(x);
        swap(x, 0, smallest);
        sort(x, 0);
    }

    private static void sort(String[] x, int start){
        if (start == x.length){
            return;
        }
        int smallestindex = findSmallest(x);
        swap(x, start, smallestindex);
        sort(x, start + 1);
    }
    public static void swap(String[] x, int a, int b){
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    public static int findSmallest(String[] x, int start){
        int smallestindex = start;
        for (int i = start; i < x.length; i++){
            int cmp = x[i].compareTo(x[smallestindex]);
            //如果x[i]小于x[small] 返回值-1
            if (cmp < 0){
                smallestindex = i;
            }
        }
        return smallestindex;
    }
}
/*
在设计一个程序的时候可以先想他的大致结构 写出辅助的函数 方法
可以写一些测试 重构一些代码 让这些代码看起来 或者 运行起来 更轻松
 */