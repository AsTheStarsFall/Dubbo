package com.tianhy.study.sentinelprovider;

import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientAssignConfig;
import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientConfig;
import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientConfigManager;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * {@link}
 *
 * @Desc: 从Nacos配置中心获取限流规则
 * @Author: thy
 * @CreateTime: 2020/1/23 6:17
 **/
public class DemoClusterInitFunc implements InitFunc {

    //token server的地址(流控服务器)
    private final String CLUSTER_SERVER_HOST = "localhost"; //token-server的地址
    private final int CLUSTER_SERVER_PORT = 9999;
    private final int REQUEST_TIME_OUT = 200000; //请求超时时间

    //Nacos配置
    private final String remoteAddress = "localhost";
    private final String groupId = "SENTINEL_GROUP";
    private final String flowPostfix = "-flow-rules";

    private final String APP_NAME = "App-a"; //namespace


    @Override
    public void init() throws Exception {
        //初始化集群信息
        loadClusterConfig();
        //注册流控规则
        registryClusterFlowRuleProperty();

    }

    private void registryClusterFlowRuleProperty() {
        ReadableDataSource<String, List<FlowRule>> rds =
                //地址，组Id，app_name+流控规则前缀
                new NacosDataSource<List<FlowRule>>(remoteAddress, groupId, APP_NAME + flowPostfix,
                        source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                        }));
        FlowRuleManager.register2Property(rds.getProperty());
    }

    private void loadClusterConfig() {
        ClusterClientAssignConfig clusterClientAssignConfig = new ClusterClientAssignConfig();
        clusterClientAssignConfig.setServerHost(CLUSTER_SERVER_HOST);
        clusterClientAssignConfig.setServerPort(CLUSTER_SERVER_PORT);
        ClusterClientConfigManager.applyNewAssignConfig(clusterClientAssignConfig);

        ClusterClientConfig clusterClientConfig = new ClusterClientConfig();
        clusterClientConfig.setRequestTimeout(REQUEST_TIME_OUT);
        ClusterClientConfigManager.applyNewConfig(clusterClientConfig);


    }
}
