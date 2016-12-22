package com.xr.chain.api.common.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class CacheUtil {
    private static Cache<Object, Object> cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(24, TimeUnit.HOURS).recordStats()
            .build();

    public static Object get(Object key) throws ExecutionException {
        Object var = cache.get(key, new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                String var = "Google.com.sg";
                return var;
            }
        });

        return var;
    }

    public static void put(Object key, Object value) {
        cache.put(key, value);
    }
}
