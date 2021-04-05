package com.example.demo.infrastructure;

import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.event.ClusterTopologyChangedEvent;
import io.lettuce.core.cluster.models.partitions.RedisClusterNode;
import io.lettuce.core.event.EventBus;
import io.lettuce.core.event.cluster.AdaptiveRefreshTriggeredEvent;
import io.lettuce.core.event.connection.ConnectedEvent;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Data
//@Configuration
//@ConfigurationProperties(prefix = "spring.redis.cluster")
@Slf4j
public class RedisClusterConfig {

//    List<String> nodes;
//
//    @Bean
//    public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(connectionFactory);
//        return redisTemplate;
//    }

    /**
     * Redis Cluster に接続するための {@link LettuceConnectionFactory} オブジェクトを生成する
     *
     * @return {@link LettuceConnectionFactory} オブジェクト
     */
//    @Bean
//    @Primary
//    public RedisConnectionFactory connectionFactory() {
//        ClusterTopologyRefreshOptions clusterTopologyRefreshOptions = ClusterTopologyRefreshOptions.builder()
//                .enablePeriodicRefresh(Duration.ofSeconds(15))
//                .enableAllAdaptiveRefreshTriggers()
//                .refreshTriggersReconnectAttempts(1)
//                .refreshPeriod(Duration.ofSeconds(15))
//                .build();
//        ClusterClientOptions clusterClientOptions = ClusterClientOptions.builder()
//                .validateClusterNodeMembership(false)
//                .topologyRefreshOptions(clusterTopologyRefreshOptions)
//                .build();
//        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
//                .commandTimeout(Duration.ofSeconds(15))
//                .shutdownTimeout(Duration.ZERO)
//                .clientOptions(clusterClientOptions)
//                .build();
//
//        RedisClusterConfiguration serverConfig = new RedisClusterConfiguration(nodes);
//
//        return new LettuceConnectionFactory(serverConfig, clientConfig);
//    }
//
//    @PostConstruct
//    public void postContract() {
//        log.info("postContract called. ");
//        RedisClusterClient client = RedisClusterClient.create(nodes.stream().map(e -> "redis://" + e).map(RedisURI::create).collect(Collectors.toList()));
//        EventBus eventBus = client.getResources().eventBus();
//
//        eventBus.get().subscribe(e -> {
//            log.info("redis event :{}", e.getClass());
//            if (e instanceof ClusterTopologyChangedEvent) {
//                ClusterTopologyChangedEvent clusterTopologyChangedEvent = (ClusterTopologyChangedEvent) e;
//                log.info("before topology:");
//                Consumer<? super RedisClusterNode> func = b -> {
//                    log.info("\t {}, isConnect[{}],Aliases[{}], SlaveOf[{}], NodeId[{}], URI[{}]",
//                            b.getRole().isMaster() ? "master" : "replica",
//                            b.isConnected(), b.getAliases(),
//                            b.getSlaveOf(), b.getNodeId(), b.getUri());
//                };
//                clusterTopologyChangedEvent.before().forEach(func);
//                log.info("after topology:");
//                clusterTopologyChangedEvent.after().forEach(func);
//            }
//
//            if (e instanceof AdaptiveRefreshTriggeredEvent) {
//                AdaptiveRefreshTriggeredEvent adaptiveRefreshTriggeredEvent =
//                        (AdaptiveRefreshTriggeredEvent) e;
//                log.info("AdaptiveRefreshTriggeredEvent:{}", e);
//            }
//
//            if (e instanceof ConnectedEvent) {
//                ConnectedEvent connectedEvent = (ConnectedEvent) e;
//                log.info("ConnectedEvent: localAddress[{}], remoteAddress[{}].", connectedEvent.localAddress(),
//                        connectedEvent.remoteAddress());
//            }
//        });
//    }
}