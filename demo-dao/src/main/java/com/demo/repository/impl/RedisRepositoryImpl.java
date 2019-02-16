package com.demo.repository.impl;

import com.demo.repository.IRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service("redisRepositoryImpl")
public class RedisRepositoryImpl<K,V> implements IRedisRepository<K,V> {
    private static final String KEY = "KEY";
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<Object, Object> findAll() {
        return null;
    }

    @Override
    public void add(K k, V v) {
        hashOperations.put(KEY, k, v);
    }

    @Autowired
    public void delete(final K id) {
        hashOperations.delete(KEY, id);
    }

    @Override
    public V find(final K id){
        return (V) hashOperations.get(KEY, id);
    }

    public Map<Object, Object> findAllStudents(){
        return hashOperations.entries(KEY);
    }
}
