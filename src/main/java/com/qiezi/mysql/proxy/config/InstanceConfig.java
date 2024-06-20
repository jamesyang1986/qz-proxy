package com.qiezi.mysql.proxy.config;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class InstanceConfig {
    private int port;

    private String host;

    private boolean isMaster;

    private String userName;

    private String passwd;

    private InstanceStatus status;
}
