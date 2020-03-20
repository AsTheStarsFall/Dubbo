package com.tianhy.study;

import com.alibaba.csp.sentinel.cluster.server.ClusterTokenServer;
import com.alibaba.csp.sentinel.cluster.server.SentinelDefaultTokenServer;
import com.alibaba.csp.sentinel.cluster.server.config.ClusterServerConfigManager;
import com.alibaba.csp.sentinel.cluster.server.config.ServerTransportConfig;

import java.util.Collections;

/**
 * @Description: alone token server
 * @Author: thy
 * @Date: 2020/1/23 13:45
 */
public class ClusterServer {

    public static void main(String[] args) throws Exception {
        ClusterTokenServer clusterTokenServer = new SentinelDefaultTokenServer();
        //集群配置管理
        ClusterServerConfigManager.loadGlobalTransportConfig(new ServerTransportConfig()
                .setIdleSeconds(600).setPort(9999));
        ClusterServerConfigManager.loadServerNamespaceSet(Collections.singleton("App-a"));

        clusterTokenServer.start();

    }
}
