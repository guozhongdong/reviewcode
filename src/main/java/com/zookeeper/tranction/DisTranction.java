package com.zookeeper.tranction;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/8/18
 */
public class DisTranction {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, null);
        String path = zk.create("/transfer/tx", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);

        List ops = Arrays.asList(
                Op.create(path + "/cohort", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL),
                Op.create(path + "/cohort", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL),
                Op.create(path + "/cohort", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL)
        );
        zk.multi(ops);
    }
}
