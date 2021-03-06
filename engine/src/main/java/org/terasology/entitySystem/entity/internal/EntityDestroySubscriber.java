/*
 * Copyright 2013 MovingBlocks
 *
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
 */
package org.terasology.entitySystem.entity.internal;

import org.terasology.entitySystem.entity.EntityRef;

/**
 * See {@link EngineEntityManager#subscribeForDestruction(EntityDestroySubscriber)}.
 *
 * @author Immortius
 * @author Florian
 */
public interface EntityDestroySubscriber {

    /**
     * At the point this method gets called the entity has still it's components, it should however not be modified
     * anymore.
     *
     * @param entity that is about to be destroyed.
     */
    void onEntityDestroyed(EntityRef entity);

}
