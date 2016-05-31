package com.zzy.zk.util;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * 操作zookeeper
 * 
 * @author zhengzhiyuan
 * @since May 31, 2016
 */
public class ZkUtil {

    /**
     * 根据host连接zk
     * 
     * @param host
     * @return
     * @throws IOException
     */
    public static ZooKeeper getZkConnection(final String host) throws IOException {
        ZooKeeper zoo = new ZooKeeper(host, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent we) {
                if (we.getState() == KeeperState.SyncConnected) {
                    // connectedSignal.countDown();
                    System.out.println("connected host:" + host);
                }
            }
        });
        return zoo;
    }


}
