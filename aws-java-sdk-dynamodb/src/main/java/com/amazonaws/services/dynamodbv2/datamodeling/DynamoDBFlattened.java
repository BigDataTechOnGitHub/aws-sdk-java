/*
 * Copyright 2016-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for flattening a complex type.
 *
 * A minimal example using getter annotations,
 * <pre class="brush: java">
 * &#064;DynamoDBTable(tableName=&quot;TestTable&quot;)
 * public class TestClass {
 *     private String key;
 *     private DateRange effectiveRange;
 *     private DateRange extensionRange;
 *
 *     &#064;DynamoDBHashKey
 *     public String getKey() { return key; }
 *     public void setKey(String key) { this.key = key; }
 *
 *     &#064;DynamoDBFlattened(attributes={
 *         &#064;DynamoDBAttribute(mappedBy=&quot;start&quot;, attributeName=&quot;effectiveStartDate&quot;),
 *         &#064;DynamoDBAttribute(mappedBy=&quot;end&quot;, attributeName=&quot;effectiveEndDate&quot;)})
 *     public DateRange getEffectiveRange() { return effectiveRange; }
 *     public void setEffectiveRange(DateRange effectiveRange) { this.effectiveRange = effectiveRange; }
 *
 *     &#064;DynamoDBFlattened(attributes={
 *         &#064;DynamoDBAttribute(mappedBy=&quot;start&quot;, attributeName=&quot;extensionStartDate&quot;),
 *         &#064;DynamoDBAttribute(mappedBy=&quot;end&quot;, attributeName=&quot;extensionEndDate&quot;)})
 *     public DateRange getExtensionRange() { return extensionRange; }
 *     public void setExtensionRange(DateRange extensionRange) { this.extensionRange = extensionRange; }
 * }
 * </pre>
 *
 * With the following complex type to marshall,
 * <pre class="brush: java">
 * public class DateRange {
 *     private Date start;
 *     private Date end;
 *
 *     public Date getStart() { return start; }
 *     public void setStart(Date start) { this.start = start; }
 *
 *     public Date getEnd() { return end; }
 *     public void setEnd(Date end) { this.end = end; }
 * }
 * </pre>
 *
 * Attributes defined within the complex type may also be annotated.
 */
@DynamoDB
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface DynamoDBFlattened {

    /**
     * Indicates the attributes that should be flattened.
     */
    DynamoDBAttribute[] attributes() default {};

}
