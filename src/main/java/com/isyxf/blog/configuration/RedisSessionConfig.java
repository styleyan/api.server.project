package com.isyxf.blog.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author xiaofei.yan
 * @Create 2019-09-16 17:47
 * @Descript 自定义redisSession配置
 */

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300)
public class RedisSessionConfig {
}
