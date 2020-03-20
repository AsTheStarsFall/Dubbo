package com.tianhy.study.sentineldemo;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/1/22 3:37
 **/
public class SentinelSample {

    //定义资源
    public static final String LIMIT_RESOURCE = "sayHello";

    //定义流控的规则
    public static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        flowRule.setResource(LIMIT_RESOURCE);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //每秒20个请求，20qps
        flowRule.setCount(20);
        rules.add(flowRule);
        //规则管理器加载规则
        FlowRuleManager.loadRules(rules);
    }

    public static void main(String[] args) {
        //初始化规则
        initFlowRules();
        //通过while循环 模拟资源的频繁访问
        while (true) {
            try (Entry entry = SphU.entry(LIMIT_RESOURCE)) {
                //被保护的逻辑
                System.out.println("处理被保护的逻辑");
            } catch (BlockException e) {
                System.out.println("处理被流控的逻辑");
            }
        }


    }
}
