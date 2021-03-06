/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not
 * use this file except in compliance with the License. A copy of the License is
 * located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.gamelift.model.transform;

import java.util.Map;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.gamelift.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.protocol.json.*;

/**
 * BuildMarshaller
 */
public class BuildJsonMarshaller {

    /**
     * Marshall the given parameter object, and output to a SdkJsonGenerator
     */
    public void marshall(Build build, StructuredJsonGenerator jsonGenerator) {

        if (build == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        try {
            jsonGenerator.writeStartObject();

            if (build.getBuildId() != null) {
                jsonGenerator.writeFieldName("BuildId").writeValue(
                        build.getBuildId());
            }
            if (build.getName() != null) {
                jsonGenerator.writeFieldName("Name")
                        .writeValue(build.getName());
            }
            if (build.getVersion() != null) {
                jsonGenerator.writeFieldName("Version").writeValue(
                        build.getVersion());
            }
            if (build.getStatus() != null) {
                jsonGenerator.writeFieldName("Status").writeValue(
                        build.getStatus());
            }
            if (build.getSizeOnDisk() != null) {
                jsonGenerator.writeFieldName("SizeOnDisk").writeValue(
                        build.getSizeOnDisk());
            }
            if (build.getOperatingSystem() != null) {
                jsonGenerator.writeFieldName("OperatingSystem").writeValue(
                        build.getOperatingSystem());
            }
            if (build.getCreationTime() != null) {
                jsonGenerator.writeFieldName("CreationTime").writeValue(
                        build.getCreationTime());
            }

            jsonGenerator.writeEndObject();
        } catch (Throwable t) {
            throw new AmazonClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }
    }

    private static BuildJsonMarshaller instance;

    public static BuildJsonMarshaller getInstance() {
        if (instance == null)
            instance = new BuildJsonMarshaller();
        return instance;
    }

}
