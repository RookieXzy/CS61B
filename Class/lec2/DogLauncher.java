package lec2;
public class DogLauncher{

    public static void main(String[] args) {
        /*
        Dog d = new Dog(100);
        d.weightInPounds = 20;
        d.makeNoise();
        */
       Dog smallDog;
       //定义了一个Dog类型的狗 名字是smallDog
       new Dog(20);
       //只声明了Dog类型 没有赋值给任何变量 会被摧毁
       smallDog = new Dog(5);
       //给Dog类型的变量赋值
        Dog haha = new Dog(20);
        Dog xixi = new Dog(30);
        Dog larger = Dog.maxDog(haha, xixi);
        larger.makeNoise();
    }
}