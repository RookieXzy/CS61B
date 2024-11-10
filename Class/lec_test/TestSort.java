/*package lec_test;
import org.junit.Test;
import org.junit.Assert.*;

public class TestSort {
    @org.junit.Test
    //test is okay
    public void testsort(){
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;
        String[] expect = {"egg", "an", "have", "i"};

        int actual = Sort.findSmallest(input, 0);
        org.junit.Assert.assertEquals(expected, actual);

        /*
        if (input != expect){
            System.out.println("is wrong");
        }
        input 和 expect 指向不同的字符串组 即使元素一样也不会判断相同
        这样写会很麻烦
        for(int i = 0; i < input.length; i++){
            if (!input[i].equals(expect[i])){
                System.out.println("在" + i + "处错了,应该是" + expect[i] + "但输出" + input[i]);
                return ;
            }
        }
         */
