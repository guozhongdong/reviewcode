package com.thread.chapter4.chapter4_4.executors;

/**
 * @author gzd
 * @date create in 2019/1/8 21:28
 **/
public interface ThreadPool <Job extends Runnable>{

    void execute(Job job);

    void shutdown();
    /**
     * 增加工作者线程
     */
    void addWorkers(int num);
    /**
     * 减少工作者线程
     * */
    void removeWorker(int num);

    int getJobSize();
}
