在 Java 中，`super` 关键字主要用于在子类中引用父类的属性和方法，或者调用父类的构造方法。它帮助子类访问父类的实现，从而实现更灵活的继承和扩展。

### 1. 用途

`super` 关键字的主要用途包括：

- **调用父类的构造方法**。
- **调用父类的成员变量**（当子类和父类有相同名称的成员变量时）。
- **调用父类的方法**（当子类重写了父类的方法时，可以通过 `super` 调用父类的原始方法）。

### 2. 用法

#### （1）调用父类的构造方法

在子类的构造方法中，可以使用 `super` 调用父类的构造方法。`super()` 必须是构造方法中的第一行，否则编译器会报错。如果父类的构造方法需要参数，可以传递参数给 `super()`。

**示例**：

```java
class Animal {
    public Animal(String name) {
        System.out.println("Animal constructor: " + name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name); // 调用父类的构造方法
        System.out.println("Dog constructor");
    }
}

Dog dog = new Dog("Buddy");
// 输出:
// Animal constructor: Buddy
// Dog constructor
```

#### （2）调用父类的成员变量

当子类和父类拥有同名的成员变量时，可以使用 `super` 关键字来区分访问父类的变量。

**示例**：

```java
class Animal {
    public String name = "Animal";
}

class Dog extends Animal {
    public String name = "Dog";

    public void printNames() {
        System.out.println("Parent name: " + super.name); // 调用父类的name
        System.out.println("Child name: " + this.name);   // 调用子类的name
    }
}

Dog dog = new Dog();
dog.printNames();
// 输出:
// Parent name: Animal
// Child name: Dog
```

#### （3）调用父类的方法

在子类中重写父类的方法后，仍然可以通过 `super` 关键字调用父类的原始方法。

**示例**：

```java
class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        super.makeSound(); // 调用父类的makeSound方法
        System.out.println("Dog bark");
    }
}

Dog dog = new Dog();
dog.makeSound();
// 输出:
// Animal sound
// Dog bark
```

### 总结

- **`super()`**：在子类构造方法中调用父类构造方法。
- **`super.变量`**：访问父类的成员变量。
- **`super.方法`**：调用父类的方法（尤其在子类重写了方法的情况下）。