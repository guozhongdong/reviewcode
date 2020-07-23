package com.java8.joinarray;

import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/7/23
 *
 * java8 api 操作两个数组合并
 */
public class JoinArray2 {

    public static void main(String[] args) {
        String[] s1 = {"a", "b", "c"};
        String[] s2 = {"d", "e", "f"};
        String[] s3 = {"g", "h", "i"};

        String[] result = Stream.of(s1,s2,s3).flatMap(Stream::of).toArray(String[]::new);

        System.out.println(Arrays.toString(result));

        int[] n1 = {1,2,3};
        int[] n2 = {4,5,6};
        int[] n3 = {7,8,9};

        int[] nums = Stream.of(n1,n2,n3).flatMapToInt(IntStream::of).toArray();
        int[] nums1 = Ints.concat(n1,n2,n3);
        int[] nums2= IntStream.concat(Arrays.stream(n1),IntStream.concat(Arrays.stream(n2),Arrays.stream(n3))).toArray();
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
}
