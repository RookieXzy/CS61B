package lec2;
public class Dog{

    public int weightInPounds;

    public static String binomen = "canis familiars";
    
    public Dog(int w){
        this.weightInPounds = w;
    } 

    public void makeNoise(){
        if (weightInPounds < 10){
            System.out.println("yipyip!");
        }else if(weightInPounds < 30){
            System.out.println("bark!");
        }else{
            System.out.println("aroooooo!");
        }
    }

    public static Dog maxDog(Dog d1, Dog d2){
        if (d1.weightInPounds > d2.weightInPounds){
            return d1;
        }else{
            return d2;
        }
    }

    public Dog maxDog(Dog d1){
        if (weightInPounds > d1.weightInPounds){
            return this;
        }else{
            return d1;
        }
    }
    

}
/*
由于 makeNoise() 方法依赖于实例变量 weightInPounds 的值，
它必须是一个实例方法，以便在调用时能够访问该实例的状态。
静态方法不具备这种能力，因此不适合用来处理与实例状态相关的逻辑。
*/
// 实例方法可以根据不同对象的状态表现出不同的行为
// 静态方法是属于类本身的，而不是类的某个具体实例。
//静态方法对于class里的所有人都通用 而非静态可以针对某个人
/*
    public static void noisy(Dog d1){
        if (d1.weightInPounds < 10){
            System.out.println("yipyip!");
        }else if(d1.weightInPounds < 30){
            System.out.println("bark!");
        }else{
            System.out.println("aroooooo!");
        }
    }
涉及到自己的就是非静态方法


 */