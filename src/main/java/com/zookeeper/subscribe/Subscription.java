package com.zookeeper.subscribe;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/8/18
 * 测试发布订阅功能
 */
public class Subscription {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        // 创建一个与服务器的连接
        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, null);

        zk.getData("/config3", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.toString());
            }
        }, null);
        zk.setData("/config3", "draven".getBytes(), 0);


    }
}
