在 Java 中，`extends` 和 `implements` 关键字用于实现继承和接口的功能，但它们有显著的区别。

### 1. 关键区别

| 特性          | `extends`                                    | `implements`                          |
|---------------|----------------------------------------------|---------------------------------------|
| **作用对象**  | 类继承类，或接口继承接口                      | 类实现接口                             |
| **继承数量**  | 一个类只能继承一个父类（单继承）             | 一个类可以实现多个接口（多实现）       |
| **目的**      | 用于复用父类的代码，实现“is-a”关系          | 用于定义行为约定，实现多态性            |
| **用法**      | `class Subclass extends Superclass` 或 `interface SubInterface extends SuperInterface` | `class ClassName implements InterfaceName` |

### 2. `extends` 关键字

- **用于类的继承**：一个类可以通过 `extends` 继承另一个类，从而复用父类的代码和属性。
- **用于接口的继承**：接口也可以通过 `extends` 从其他接口继承方法声明。
- **单继承限制**：一个类只能继承一个父类，这叫做“单继承”。

**示例**：

```java
class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal { // Dog 继承自 Animal
    public void bark() {
        System.out.println("Dog is barking");
    }
}
```

在此示例中，`Dog` 类通过 `extends` 关键字继承 `Animal` 类，获得了 `eat` 方法。

### 3. `implements` 关键字

- **用于类实现接口**：当一个类需要实现接口中定义的行为时，使用 `implements` 关键字。
- **多接口实现**：一个类可以实现多个接口，用逗号分隔，这实现了 Java 的多态性。
- **强制实现方法**：实现接口的类必须实现接口中的所有抽象方法。

**示例**：

```java
interface Animal {
    void makeSound();
}

interface Runnable {
    void run();
}

class Dog implements Animal, Runnable { // Dog 实现了多个接口
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public void run() {
        System.out.println("Dog is running");
    }
}
```

在此示例中，`Dog` 类通过 `implements` 实现了 `Animal` 和 `Runnable` 接口，必须实现接口中的所有方法。

### 总结

- **`extends`**：用于类继承类，或接口继承接口。一个类只能继承一个父类，但接口可以多继承。
- **`implements`**：用于类实现接口。一个类可以实现多个接口，来定义其行为契约。