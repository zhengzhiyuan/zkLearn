package com.zzy.zk.util;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

/**
 * 测试ZkUtil
 * 
 * @author zhengzhiyuan
 * @since May 31, 2016
 */
public class ZkUtilTest {

    public static String HOST = "192.168.2.184:2181,192.168.2.78:2181";

    @Test
    public void testCreate() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = null;
        String path = "/test";
        String data = "zzy test";
        try {
            zk = ZkUtil.getZkConnection(HOST);
            Stat stat = zk.exists(path, true);
            if (null == stat) {
                String result = zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                System.out.println("created path : " + result);
            } else {
                System.out.println("Node '" + path + "' exists and the node version is " + stat.getVersion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != zk) {
                zk.close();
            }
        }
    }

    public void testGet() throws InterruptedException {
        ZooKeeper zk = null;
        String path = "/test";
        String data = "zzy test";
        try {
            zk = ZkUtil.getZkConnection(HOST);
            Stat stat = zk.exists(path, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != zk) {
                zk.close();
            }
        }
    }
}
