package lec7;

import javax.swing.plaf.basic.BasicComboBoxUI;

/** Array based list.
 *  @author Josh Hug
 */

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5


public class AList<Item> {
    private Item[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if (size == items.length){
            resizing(size + 1);
        }
        items[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
       return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** 删除item数组的最后一个元素 */
   public Item removeLast(){
        Item x = items[size - 1];
        //在int[]数组类型中默认元素值是0
       //在Object[]对象类型数组中默认元素是null;
        items[size - 1] = null;
        size -= 1;
        return x;
   }

   /** 当数组满的时候 将数组大小调整为加1 */
   public void resizing(int capacity){
       Item[] a = (Item[]) new Object[capacity];
       System.arraycopy(items, 0, a, 0, size);
       items = a;
   }


}