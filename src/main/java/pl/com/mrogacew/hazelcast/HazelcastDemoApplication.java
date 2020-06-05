package pl.com.mrogacew.hazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;

@SpringBootApplication
@EnableCaching
public class HazelcastDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HazelcastDemoApplication.class, args);
    }

    @Bean
    public CacheManager cacheManager(HazelcastInstance hz) {
        return new HazelcastCacheManager(hz);
    }

}
