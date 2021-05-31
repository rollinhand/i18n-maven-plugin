package com.benasmussen.maven.plugin.i18n.lang;

/*
 * #%L
 * Maven Plugin i18n
 * %%
 * Copyright (C) 2014 Ben Asmussen <opensource@ben-asmussen.com>
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * This class is a decorator of {@link Properties}.
 * <p>
 * It uses {@link LinkedHashMap} instead of {@link Hashtable} to preserve
 * properties order when loading from streams.
 * </p>
 */
public class OrderedProperties extends Properties
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Map<String, String> entries = new LinkedHashMap<>();

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Enumeration keys()
    {
        return Collections.enumeration(entries.keySet());
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Enumeration elements()
    {
        return Collections.enumeration(entries.values());
    }

    @Override
    public boolean contains(Object value)
    {
        return entries.containsValue(value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public synchronized void putAll(Map<? extends Object, ? extends Object> map)
    {
        entries.putAll((Map<? extends String, ? extends String>) map);
    }

    @Override
    public int size()
    {
        return entries.size();
    }

    @Override
    public boolean isEmpty()
    {
        return entries.isEmpty();
    }

    @Override
    public boolean containsKey(Object key)
    {
        return entries.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value)
    {
        return entries.containsValue(value);
    }

    @Override
    public String get(Object key)
    {
        return entries.get(key);
    }

    @Override
    public synchronized String put(Object key, Object value)
    {
        return entries.put((String) key, (String) value);
    }

    @Override
    public synchronized Object remove(Object key)
    {
        return entries.remove(key);
    }

    @Override
    public synchronized void clear()
    {
        entries.clear();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Set keySet()
    {
        return entries.keySet();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Collection values()
    {
        return entries.values();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Set entrySet()
    {
        return entries.entrySet();
    }

    @Override
    public synchronized boolean equals(Object o)
    {
        return entries.equals(o);
    }

    @Override
    public synchronized int hashCode()
    {
        return entries.hashCode();
    }
    
}
