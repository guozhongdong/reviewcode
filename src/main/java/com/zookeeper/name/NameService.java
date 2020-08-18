package com.zookeeper.name;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/8/18
 * 测试命名服务
 */
public class NameService {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        ZooKeeper zk = new ZooKeeper("localhost:2181",30000,null);
        //String str1 = zk.create("/metrics7", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        //String str2 =  zk.create("/metrics8", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
         String lockNumber = zk.create("/resource/lock", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

        List children = zk.getChildren("/", null);
        //.out.println(str1);
        //System.out.println(str2);
        System.out.println(lockNumber);
        System.out.println(children);
    }
}
