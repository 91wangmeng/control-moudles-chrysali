package com.drore.cloud.control.web.application;

import com.drore.cloud.control.manger.common.cache.service.RedisBuilder;
import com.drore.cloud.control.manger.common.http.utils.HttpRequestUtils;
import com.drore.cloud.control.manger.common.log.annotations.ServerInvokeLog;
import com.drore.cloud.control.manger.common.log.enmu.InvokerType;
import com.drore.cloud.control.manger.common.log.enmu.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 卓锐科技有限公司
 * Created by wmm on 2017/7/20.
 * email：6492178@gmail.com
 * description:
 *
 * @author wmm
 */
@RestController
@RefreshScope
public class TestController {
    private static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    @Value("${a.b}")
    private String test;
    @Value("${spring.redis.host}")
    private String host;
    @Resource
    private RedisBuilder redisBuilder;
    @Resource
    private Environment environment;

    /**
     * Test string.
     *
     * @return the string
     * @throws ExecutionException   the execution exception
     * @throws InterruptedException the interrupted exception
     */
    @RequestMapping("/test")
    @ServerInvokeLog(serverDescription = "管控系统测试接口", logType = LogType.API_LOG_TYPE, invoker = InvokerType.CONTROL_WEB_INVOKEY_TYPE)
    public String test() throws ExecutionException, InterruptedException {
        redisBuilder.set("a", "b");
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("a", "b");
        stringObjectHashMap.put("c", "d");
        stringObjectHashMap.put("e", "f");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> HttpRequestUtils.postJson("测试子线程", "http://localhost:8081/test", stringObjectHashMap));
        return completableFuture.get();
    }
}
