package com.tianhy.study.sentinelprovider;

import com.alibaba.csp.sentinel.cluster.ClusterStateManager;
import com.alibaba.csp.sentinel.slots.block.ClusterRuleConstant;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.ClusterFlowConfig;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Collections;

@SpringBootApplication
public class SentinelProviderApplication {

    public static void main(String[] args) throws IOException {
//        initFlowRule();

        //设置当前节点为集群客户端
        ClusterStateManager.applyState(ClusterStateManager.CLUSTER_CLIENT);
        SpringApplication.run(SentinelProviderApplication.class, args);
        System.in.read();
    }

    //初始化流控规则
/*
    private static void initFlowRule() {
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("com.tianhy.study.ProviderService:sayHello(java.lang.String)");
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //20QPS
        flowRule.setCount(10);
        //控制行为
//        flowRule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
        //设置限制来源
//        flowRule.setLimitApp("sentinel-web");
//        FlowRuleManager.loadRules(Collections.singletonList(flowRule));
        flowRule.setClusterMode(true);
        ClusterFlowConfig clusterFlowConfig = new ClusterFlowConfig();
        clusterFlowConfig.setFlowId(11111L);
        //阈值模式，默认（0）单机均摊，1为全局均摊
        clusterFlowConfig.setThresholdType(ClusterRuleConstant.FLOW_THRESHOLD_AVG_LOCAL);
        clusterFlowConfig.setStrategy(ClusterRuleConstant.FLOW_CLUSTER_STRATEGY_NORMAL);
        //当客户端连接/通信失败，是否退化到本地限流模式
        clusterFlowConfig.setFallbackToLocalWhenFail(true);
        flowRule.setClusterConfig(clusterFlowConfig);
        System.out.println(JSON.toJSONString(Collections.singleton(flowRule)));
    }
*/
}
