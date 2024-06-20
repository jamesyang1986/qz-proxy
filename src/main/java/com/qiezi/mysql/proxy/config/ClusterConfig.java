package com.qiezi.mysql.proxy.config;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClusterConfig {

    private List<NodeConfig> nodes;
}
