
package lec9;
/** SList with additional operation printLostItems() which prints all items
  * that have ever been deleted. */
public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deletedItems;

    public VengefulSLList() {
        super();
        deletedItems = new SLList<Item>();
    }
/*
在使用子类的构造函数时 会自动调用父类的构造函数 相当于在函数中运行了super()
如果不调用super(x) 子类的构造函数不会向父类的构造函数传入任何参数
下面的写法是错误的
 */
    public VengefulSLList(Item x) {
        deletedItems = new SLList<Item>();
    }

    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    /** Prints deleted items. */
    public void printLostItems() {
        deletedItems.print();
    }

    public static void main(String[] args) {

		VengefulSLList<Integer> vs1 = new VengefulSLList<Integer>(0);
		vs1.addLast(1);
		vs1.addLast(5);
		vs1.addLast(10);
		vs1.addLast(13);
		// vs1 is now: [1, 5, 10, 13] 


		vs1.removeLast();
		vs1.removeLast();
		// After deletion, vs1 is: [1, 5]

		// Should print out the numbers of the fallen, namely 10 and 13.
		System.out.print("The fallen are: ");
		vs1.printLostItems();
	}
} 