package com.zookeeper.curator;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;


/**
 * @author guozhongdong
 * @Description:
 * @date 2020/8/20
 * 监听器
 */
@Slf4j
public class NodeEventListener implements CuratorListener {

    @Override
    public void eventReceived(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
      log.info("输出事件="+curatorEvent.toString());
      final WatchedEvent watchedEvent = curatorEvent.getWatchedEvent();
      if (watchedEvent != null){
          log.info("监听状态："+watchedEvent.getState()+",监听类型："+watchedEvent.getType());
          //判断连接是否存在
          if (watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected){
              switch (watchedEvent.getType()) {
                  case NodeChildrenChanged:
                      log.info("子节点修改");
                      break;
                  case NodeDataChanged:
                      log.info("子节点数据修改");
                      break;
                  default:
                      break;
              }
          }
      }
    }
}
