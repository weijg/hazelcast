/*
 * Copyright (c) 2008-2010, Hazel Ltd. All Rights Reserved.
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
 *
 */

package com.hazelcast.jmx;

import com.hazelcast.core.ICountDownLatch;
import com.hazelcast.nio.Address;

/**
 * MBean for ICountDownLatch
 */
@JMXDescription("A distributed CountDownLatch")
public class CountDownLatchMBean extends AbstractMBean<ICountDownLatch> {

    public CountDownLatchMBean(ICountDownLatch managedObject, ManagementService managementService) {
        super(managedObject, managementService);
    }

    @Override
    public ObjectNameSpec getNameSpec() {
        return getParentName().getNested("CountDownLatch", getName());
    }

    @JMXAttribute("Name")
    @JMXDescription("Instance name of the count down latch")
    public String getName() {
        return getManagedObject().getName();
    }

    @JMXAttribute("CurrentCount")
    @JMXDescription("getCount() result")
    public long getCurrentCount() {
        return getCount();
    }

    @JMXAttribute("CurrentOwner")
    @JMXDescription("getOwnerAddress() result")
    public Address getCurrentOwner() {
        return getManagedObject().getOwnerAddress();
    }

    @JMXOperation("countDown")
    @JMXDescription("perform a countdown operation")
    public void countDown(){
        getManagedObject().countDown();
    }

    @JMXOperation("getCount")
    @JMXDescription("return current count value")
    public long getCount() {
        return getManagedObject().getCount();
    }

    @JMXOperation("getOwnerAddress")
    @JMXDescription("return current count value")
    public Address getOwnerAddress() {
        return getManagedObject().getOwnerAddress();
    }
}