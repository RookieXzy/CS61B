public class Array{
    public static void main(String[] args) {
        int[] z = null;
        int[] x, y;

        int a[] = new int[]{1, 2};
        int[] c = {1, 2};

        x = new int[]{1, 2, 3, 4, 5};
        y = x; //此时y指向了x的内存地址 访问了12345的数组
        x = new int[]{2, 4, 6, 8};
        //x 改变了 y仍然指向之前的数组 x指向新的数组
        y = new int[3];
        // y 此时也改变了自己指向的数组 创建了一个空间位3的新数组 原来的数组12345在内存上消失了

        int xl = x.length;
        //数组只有一个方法 就是length

        String s[] = new String[6];
        s[4] = "ketchup";
        s[x[3] - x[1]] = "muffins";

        int[] b = {9, 10, 11};
        System.arraycopy(b, 0, x, 3, 2);
        //从b[0]开始copy两位从x[3]开始放两位
    }
}