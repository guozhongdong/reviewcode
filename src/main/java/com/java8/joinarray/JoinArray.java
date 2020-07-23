package com.java8.joinarray;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author guozhongdong
 * @Description: 使用api实现 合并两个数组
 * @date 2020/7/23
 */
public class JoinArray {

    public static void main(String[] args) {
        String[] s1 = {"a","b","c"};
        String[] s2 = {"d","e","f"};

        String[] result = ArrayUtils.addAll(s1,s2);
        System.out.println(Arrays.toString(result));

        String[] s3 = {"a1","b1","c1"};
        String[] s4 = {"d1","e1","f1"};

        String[] result1 = joinArray(s3,s4);
        System.out.println(Arrays.toString(result1));

        int[] n1 = {1,2,3};
        int[] n2 = {4,5,6};
        int[] result2 = joinArray(n1,n2);
        System.out.println(Arrays.toString(result2));
    }

    //自定义api
    static <T> T[] joinArray(T[] ...arrays){
        int length = 0;
        for (T[] array : arrays) {
            length += array.length;
        }

        final T[] result = (T[]) Array.newInstance(arrays[0].getClass().getComponentType(),length);
        // 利用本地方法，进行copy
        int offset = 0;
        for (T[] array : arrays) {
            System.arraycopy(array,0,result,offset,array.length);
            offset += array.length;
        }

        return result;
    }

    static int[] joinArray(int[]... arrays) {
        int length = 0;
        for (int[] array : arrays) {
            length += array.length;
        }

        final int[] result = new int[length];

        int offset = 0;
        for (int[] array : arrays) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }

        return result;
    }
 }
