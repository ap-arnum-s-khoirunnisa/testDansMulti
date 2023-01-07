package com.dansmulti.test.test2dan3;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Arnum Sari Khoirunnisa
 * @date 07/01/23
 */
@Component
@Data
@ConfigurationProperties(prefix = "dans.service.url")
public class DansMultiUrl {
    private String list;
    private String detail;

}
