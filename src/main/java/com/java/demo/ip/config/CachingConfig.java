package com.java.demo.ip.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.java.demo.ip.utils.Constant;

/**
 * 
 * @author AdrianRojas
 *
 *Class de configuración para almacenar información en caché
 */

@Configuration
@EnableCaching
public class CachingConfig {
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager(Constant.CACHE_ALL_COUNTRIES);
	}
}
