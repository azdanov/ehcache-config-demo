package org.js.azdanov.ehcacheconfigdemo.configuration;

import lombok.extern.slf4j.Slf4j;

import javax.cache.event.CacheEntryCreatedListener;
import javax.cache.event.CacheEntryEvent;

@Slf4j
public class CacheListener implements CacheEntryCreatedListener<Integer, Integer> {

    @Override
    public void onCreated(final Iterable<CacheEntryEvent<? extends Integer, ? extends Integer>> cacheEntryEvents) {
        for (CacheEntryEvent<? extends Integer, ? extends Integer> entryEvent : cacheEntryEvents) {
            log.info("Cached key: {}, with value: {}", entryEvent.getKey(), entryEvent.getValue());
        }
    }
}
