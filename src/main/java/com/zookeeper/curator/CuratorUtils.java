package com.zookeeper.curator;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.curator.framework.api.GetDataBuilder;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.Map;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/8/20
 * zk基本操作工具类
 *
 */
public class CuratorUtils {

    /**
     * curatorFramework
     */
    private CuratorFramework curatorFramework;

    /**
     * 创建zk链接
     * */
    public CuratorUtils(String address){
        curatorFramework = CuratorFrameworkFactory.newClient(address,new ExponentialBackoffRetry(1000,3));
        curatorFramework.getCuratorListenable().addListener(new NodeEventListener());
        curatorFramework.start();
    }

    /**
     * 创建节点
     * */
    public boolean createNode(String name,String value){

        try {
            Stat stat = getClient().checkExists().forPath(name);
            if (stat == null){
                String result = getClient().create().creatingParentsIfNeeded().forPath(name,value.getBytes(Charsets.UTF_8));
                return name.equals(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 更新节点
     * */
    public boolean updateNode(String name,String value){

        try {
            Stat stat = getClient().checkExists().forPath(name);
            if (stat != null){
                Stat result = getClient().setData().forPath(name,value.getBytes(Charsets.UTF_8));
                return result != null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 删除节点
     * */
    public void deleteNode(String name){

        try {
            getClient().delete().deletingChildrenIfNeeded().forPath(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 找到指定节点下左右子节点的名称和值
     * */
    public Map<String,String> listChildrenDetail(String node){
        Map<String,String> map = Maps.newHashMap();
        GetChildrenBuilder getChildrenBuilder = getClient().getChildren();
        GetDataBuilder getDataBuilder = getClient().getData();
        try {
            List<String> children = getChildrenBuilder.forPath(node);
            for (String child : children) {
                String propPath = ZKPaths.makePath(node,child);
                map.put(child,new String(getDataBuilder.forPath(propPath),Charsets.UTF_8));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;

    }
    /**
     * 列出所有子节点的名称
     * */
    public List<String> listChildren(String name){
        List<String> list = Lists.newArrayList();

        try {
            GetChildrenBuilder getChildrenBuilder = getClient().getChildren();
            list = getChildrenBuilder.forPath(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 增加监听
     *
     * @param isSelf  true 为本身增加监听，false 为子节点增加监听
     * */
    public void addWatch(String node,boolean isSelf) throws Exception {
        if (isSelf){
            getClient().getData().watched().forPath(node);
        }else{
            getClient().getChildren().watched().forPath(node);
        }
    }

    /**
     * 增加监听
     *
     * @param isSelf  true 为本身增加监听，false 为子节点增加监听
     * */
    public void addWatch(String node, boolean isSelf, Watcher watcher) throws Exception {
        if (isSelf){
            getClient().getData().usingWatcher(watcher).forPath(node);
        }else{
            getClient().getChildren().usingWatcher(watcher).forPath(node);
        }
    }

    /**
     * 增加监听
     *
     * @param isSelf  true 为本身增加监听，false 为子节点增加监听
     * */
    public void addWatch(String node, boolean isSelf, CuratorWatcher watcher) throws Exception {
        if (isSelf){
            getClient().getData().usingWatcher(watcher).forPath(node);
        }else{
            getClient().getChildren().usingWatcher(watcher).forPath(node);
        }
    }

    public void destroy(){
        if (curatorFramework != null){
            curatorFramework.close();
        }
    }

    public CuratorFramework getClient(){
        return  curatorFramework;
    }
}
