package in.gosoftware.apimis.misapimaven.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;

@Configuration
public class VehicleCacheConfig {
	@Bean
	public Config CacheConfig() {
		return new Config().setInstanceName("hazel-cacheimpl")
				.addMapConfig(new MapConfig()
						.setName("vehicle-cache")
						.setTimeToLiveSeconds(3000)
						.setMaxSizeConfig(new MaxSizeConfig(200,MaxSizePolicy.FREE_HEAP_SIZE))
						.setEvictionPolicy(EvictionPolicy.LRU));
		
	}

}
