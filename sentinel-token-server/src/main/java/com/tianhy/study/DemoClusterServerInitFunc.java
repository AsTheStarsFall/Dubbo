package com.tianhy.study;

import com.alibaba.csp.sentinel.cluster.flow.rule.ClusterFlowRuleManager;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @Description:
 * @Author: thy
 * @Date: 2020/1/23 13:57
 */
public class DemoClusterServerInitFunc implements InitFunc {

    //Nacos配置中心地址
    private final String remoteAddress = "localhost";
    private final String groupId = "SENTINEL_GROUP";
    private final String flowPostfix = "-flow-rules";

    @Override
    public void init() throws Exception {
        // Register cluster flow rule property supplier which creates data source by namespace.
        ClusterFlowRuleManager.setPropertySupplier(namespace -> {
            ReadableDataSource<String, List<FlowRule>> ds = new NacosDataSource<>(remoteAddress, groupId,
                    namespace + flowPostfix,
                    source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                    }));
            return ds.getProperty();
        });
    }
}
