/*
 * Copyright 2023 Conductor authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.netflix.conductor.contribs.queue.amqp.util;

/**
 * @author Ritu Parathody
 */
public enum AMQPConfigurations {

    // queue exchange settings
    PARAM_EXCHANGE_TYPE("exchangeType"),
    PARAM_QUEUE_NAME("bindQueueName"),
    PARAM_ROUTING_KEY("routingKey"),
    PARAM_DELIVERY_MODE("deliveryMode"),
    PARAM_DURABLE("durable"),
    PARAM_EXCLUSIVE("exclusive"),
    PARAM_AUTO_DELETE("autoDelete"),
    PARAM_MAX_PRIORITY("maxPriority");

    String propertyName;

    AMQPConfigurations(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public String toString() {
        return propertyName;
    }
}
