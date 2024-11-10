public class Car {
    String model;
    int gas;

    public Car(String m){
        this.model = m;
        this.gas = 5;
    }
    public void drive(){
        if (this.gas < 4){
            System.out.println(this.model + "no go vroom");
        }
        System.out.println(this.model + "go Vroom");
    }
    public int getNumGas(){
        return this.gas;
    }
    public void driveIntoDitch(int gaslost){
        this.gas = this.gas - gaslost;
    }

    public static void main(String[] args){
        Car c1;
        Car c2;
// java中需要先定义变量的类型再使用 当使用一个新定义的类型的时候需要 在前面加上一个new
        c1 = new Car("civi");
        c2 = new Car("toyota");

        c1.drive();
        c1.driveIntoDitch(2);
        c1.drive();

        System.out.println(c2.getNumGas());
    }
}

/*
In python :
class Car():
    def __init__(self, m):
        self.model = m
        self.gas = 5

    def drive(self):
        if self.gas < 4:
            print(self.model + "no go vroom")
        print(self.model + "go vroom")
    def
 */
