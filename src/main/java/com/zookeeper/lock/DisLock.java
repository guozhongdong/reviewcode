package com.zookeeper.lock;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/8/18
 */
public class DisLock {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, null);
        final String resource = "/resource";

        //设置自己的节点锁
        final String lockNumber = zk
                .create("/resource/lock-", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        // 获取当前锁节点下的所有子节点，
        List<String> locks = zk.getChildren(resource, false, null);
        Collections.sort(locks);
        // 判断最小的节点序号跟当前是不是一个序号，如果是说明就获取了锁，操作结束后，删除子节点
        if (locks.get(0).equals(lockNumber.replace("/resource/", ""))) {
            System.out.println("Acquire Lock");
            zk.delete(lockNumber, 0);
        } else {
            //如果不相等，就去监听这个父节点，当别人修改了之后，在判断与自己的节点是否相等。
            zk.getChildren(resource, new Watcher() {

                @Override
                public void process(WatchedEvent watchedEvent) {
                    try {
                        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, null);
                        List locks = zk.getChildren(resource, null, null);
                        Collections.sort(locks);

                        if (locks.get(0).equals(lockNumber.replace("/resource/", ""))) {
                            System.out.println("Acquire Lock");
                            zk.delete(lockNumber, 0);
                        }

                    } catch (Exception e) {}
                }
            }, null);
        }
    }
}
