package com.qiezi.mysql.proxy.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShardingConfig {
    private DBRuleConfig dbRuleConfig;

    private TableRuleConfig tableRuleConfig;
}
