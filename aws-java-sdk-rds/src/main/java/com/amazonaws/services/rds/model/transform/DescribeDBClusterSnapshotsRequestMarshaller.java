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
package com.amazonaws.services.rds.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.rds.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;

/**
 * DescribeDBClusterSnapshotsRequest Marshaller
 */

public class DescribeDBClusterSnapshotsRequestMarshaller
        implements
        Marshaller<Request<DescribeDBClusterSnapshotsRequest>, DescribeDBClusterSnapshotsRequest> {

    public Request<DescribeDBClusterSnapshotsRequest> marshall(
            DescribeDBClusterSnapshotsRequest describeDBClusterSnapshotsRequest) {

        if (describeDBClusterSnapshotsRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        Request<DescribeDBClusterSnapshotsRequest> request = new DefaultRequest<DescribeDBClusterSnapshotsRequest>(
                describeDBClusterSnapshotsRequest, "AmazonRDS");
        request.addParameter("Action", "DescribeDBClusterSnapshots");
        request.addParameter("Version", "2014-10-31");
        request.setHttpMethod(HttpMethodName.POST);

        if (describeDBClusterSnapshotsRequest.getDBClusterIdentifier() != null) {
            request.addParameter("DBClusterIdentifier", StringUtils
                    .fromString(describeDBClusterSnapshotsRequest
                            .getDBClusterIdentifier()));
        }

        if (describeDBClusterSnapshotsRequest.getDBClusterSnapshotIdentifier() != null) {
            request.addParameter("DBClusterSnapshotIdentifier", StringUtils
                    .fromString(describeDBClusterSnapshotsRequest
                            .getDBClusterSnapshotIdentifier()));
        }

        if (describeDBClusterSnapshotsRequest.getSnapshotType() != null) {
            request.addParameter("SnapshotType", StringUtils
                    .fromString(describeDBClusterSnapshotsRequest
                            .getSnapshotType()));
        }

        com.amazonaws.internal.SdkInternalList<Filter> filtersList = (com.amazonaws.internal.SdkInternalList<Filter>) describeDBClusterSnapshotsRequest
                .getFilters();
        if (!filtersList.isEmpty() || !filtersList.isAutoConstruct()) {
            int filtersListIndex = 1;

            for (Filter filtersListValue : filtersList) {

                if (filtersListValue.getName() != null) {
                    request.addParameter("Filters.Filter." + filtersListIndex
                            + ".Name",
                            StringUtils.fromString(filtersListValue.getName()));
                }

                com.amazonaws.internal.SdkInternalList<String> valuesList = (com.amazonaws.internal.SdkInternalList<String>) filtersListValue
                        .getValues();
                if (!valuesList.isEmpty() || !valuesList.isAutoConstruct()) {
                    int valuesListIndex = 1;

                    for (String valuesListValue : valuesList) {
                        if (valuesListValue != null) {
                            request.addParameter("Filters.Filter."
                                    + filtersListIndex + ".Values.Value."
                                    + valuesListIndex,
                                    StringUtils.fromString(valuesListValue));
                        }
                        valuesListIndex++;
                    }
                }
                filtersListIndex++;
            }
        }

        if (describeDBClusterSnapshotsRequest.getMaxRecords() != null) {
            request.addParameter("MaxRecords", StringUtils
                    .fromInteger(describeDBClusterSnapshotsRequest
                            .getMaxRecords()));
        }

        if (describeDBClusterSnapshotsRequest.getMarker() != null) {
            request.addParameter("Marker", StringUtils
                    .fromString(describeDBClusterSnapshotsRequest.getMarker()));
        }

        if (describeDBClusterSnapshotsRequest.getIncludeShared() != null) {
            request.addParameter("IncludeShared", StringUtils
                    .fromBoolean(describeDBClusterSnapshotsRequest
                            .getIncludeShared()));
        }

        if (describeDBClusterSnapshotsRequest.getIncludePublic() != null) {
            request.addParameter("IncludePublic", StringUtils
                    .fromBoolean(describeDBClusterSnapshotsRequest
                            .getIncludePublic()));
        }

        return request;
    }

}
