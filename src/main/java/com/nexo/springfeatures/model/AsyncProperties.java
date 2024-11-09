package com.nexo.springfeatures.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@Component
@ConfigurationProperties(prefix = "spring.async")
public class AsyncProperties {
    private int coreSize;
    private int maxSize;
    private int keepAlive;
    private int queueCapacity;
    private String threadNamePrefix;
}
