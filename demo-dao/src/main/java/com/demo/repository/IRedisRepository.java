package com.demo.repository;

import java.util.Map;

public interface IRedisRepository <K,V>{
    Map<Object, Object> findAll();
    void add(K k, V v);
    void delete(K id);
    V find(K id);
}