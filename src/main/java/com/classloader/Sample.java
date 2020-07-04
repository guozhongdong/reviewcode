package com.classloader;

/**
 * @author gzd
 * @date 2019/9/18 下午4:39
 */
public class Sample {
    private Sample sample;

    public void setSample(Object instance){
        sample = (Sample) instance;
    }
}
