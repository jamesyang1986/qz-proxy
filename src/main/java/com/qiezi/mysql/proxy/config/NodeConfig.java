package com.qiezi.mysql.proxy.config;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class NodeConfig {

    private InstanceConfig master;

    private List<InstanceConfig> slaves;

    private long start;

    private long end;

    private String suffix;

}
