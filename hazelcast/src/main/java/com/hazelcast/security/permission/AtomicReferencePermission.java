/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
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

package com.hazelcast.security.permission;

public class AtomicReferencePermission extends InstancePermission {

    private final static int READ = 0x4;
    private final static int MODIFY = 0x8;

    private final static int ALL = READ | MODIFY | CREATE | DESTROY;

    public AtomicReferencePermission(String name, String... actions) {
        super(name, actions);
    }

    protected int initMask(String[] actions) {
        int mask = NONE;
        for (int i = 0; i < actions.length; i++) {
            if (ActionConstants.ACTION_ALL.equals(actions[i])) {
                return ALL;
            }

            if (ActionConstants.ACTION_CREATE.equals(actions[i])) {
                mask |= CREATE;
            } else if (ActionConstants.ACTION_READ.equals(actions[i])) {
                mask |= READ;
            } else if (ActionConstants.ACTION_MODIFY.equals(actions[i])) {
                mask |= MODIFY;
            } else if (ActionConstants.ACTION_DESTROY.equals(actions[i])) {
                mask |= DESTROY;
            }
        }
        return mask;
    }
}
