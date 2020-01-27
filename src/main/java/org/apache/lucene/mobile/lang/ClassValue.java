package org.apache.lucene.mobile.lang;

/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.HashMap;
import java.util.Map;

public abstract class ClassValue<T> {
  boolean defaultCached = false;
  T defaultCachedMember = null;
  Map<Class<?>, T> cache = new HashMap<>();

  protected ClassValue() {
  }

  protected abstract T computeValue(Class<?> type);

  public T get(Class<?> type) {
    // Note: this does not care about synchronization.
    if (cache.containsKey(type)) {
      return cache.get(type);
    }

    T value = computeValue(type);
    cache.put(type, value);
    return value;
  }

  public void remove(Class<?> type) {
    // Note: this does not care about synchronization.
    cache.remove(type);
  }
}
