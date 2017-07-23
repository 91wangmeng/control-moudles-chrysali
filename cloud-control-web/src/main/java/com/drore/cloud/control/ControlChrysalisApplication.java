package com.drore.cloud.control;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Date;

/**
 * 卓锐科技有限公司
 * Created by wmm on 2017/7/20.
 * email：6492178@gmail.com
 * description:
 *
 * @author wmm
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ControlChrysalisApplication {
    private static Logger LOGGER = LoggerFactory.getLogger(ControlChrysalisApplication.class);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        LOGGER.debug("系统启动时间:\t{}", DateFormatUtils.format(new Date(), DateFormatUtils.ISO_DATE_FORMAT.getPattern()));
        SpringApplication.run(ControlChrysalisApplication.class);
    }
}
