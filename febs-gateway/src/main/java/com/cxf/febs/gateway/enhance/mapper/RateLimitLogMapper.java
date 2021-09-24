package com.cxf.febs.gateway.enhance.mapper;

import com.cxf.febs.gateway.enhance.entity.RateLimitLog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * @author sixpence
 * @version 1.0 2021/9/23
 */
@Repository
public interface RateLimitLogMapper extends ReactiveMongoRepository<RateLimitLog, String> {
    /**
     * 删除限流日志
     *
     * @param ids 限流日志id
     * @return 被删除的限流日志
     */
    Flux<RateLimitLog> deleteByIdIn(Collection<String> ids);
}
