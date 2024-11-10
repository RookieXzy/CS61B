package lec3;

public class walrus {
    public static double average(double a, double b){
        return (a + b) / 2;
    }
    public static void main(String[] args){
        double x = 5.2;
        double y = 10.5;
        double avg = average(x, y);
        //double x只是传递了一个副本到double a上 修改double a并不会影响他的值
    }
}



/*
基本数据类型：存储的是值本身，赋值会拷贝值，修改副本不会影响原变量。
引用数据类型 reference type：存储的是对象的引用，赋值只是复制引用地址，多个引用指向同一对象，
修改任意引用的属性都会影响对象。


所有引用数据类型（例如自定义类对象、数组、集合类等）都是通过引用传递的。
也就是说，所有引用类型的变量存储的是对象在内存中的地址（引用），而不是对象本身的实际内容。
因此，不论是自定义的类、数组，还是集合类型（如 ArrayList、HashMap 等），
它们的赋值、传参等操作都是通过引用进行的。
 */