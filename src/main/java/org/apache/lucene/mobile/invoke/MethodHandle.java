package org.apache.lucene.mobile.invoke;

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

public abstract class MethodHandle {
  public abstract Object invokeExact();

  public abstract MethodHandle asType(MethodType newType);

  static public class NoArgsConstructor extends MethodHandle {
    Class<?> clazz;

    NoArgsConstructor(Class<?> clazz) {
      this.clazz = clazz;
    }

    @Override
    public Object invokeExact() {
      try {
        return clazz.newInstance();
      } catch (InstantiationException | IllegalAccessException e) {
        // Note: May not be the wisest choice.
        return null;
      }
    }

    @Override
    public MethodHandle asType(MethodType newType) {
      return this;
    }
  }
}
