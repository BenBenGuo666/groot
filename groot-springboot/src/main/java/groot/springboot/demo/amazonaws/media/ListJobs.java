//snippet-sourcedescription:[ListJobs.java demonstrates how to get information about all completed AWS Elemental MediaConvert jobs.]
//snippet-keyword:[AWS SDK for Java v2]
//snippet-service:[AWS Elemental MediaConvert]

/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

package groot.springboot.demo.amazonaws.media;


import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.mediaconvert.MediaConvertClient;
import software.amazon.awssdk.services.mediaconvert.model.*;

import java.net.URI;
import java.util.List;


/**
 * Before running this Java V2 code example, set up your development environment, including your credentials.
 * <p>
 * For more information, see the following documentation topic:
 * <p>
 * https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html
 */
@Slf4j
public class ListJobs {

    public static void main(String[] args) {

        MediaConvertClient mediaConvertClient = MediaConvertHelper.getMediaConvertClient(
                MediaConvertHelper.getMediaConvertProperties().getEndpoint()
        );
        listCompleteJobs(mediaConvertClient);
        mediaConvertClient.close();
    }

    public static void listCompleteJobs(MediaConvertClient mc) {
        String endpointURL = MediaConvertHelper.getEndpoint(mc);
        MediaConvertClient emc = MediaConvertHelper.getMediaConvertClient(endpointURL);
        ListJobsRequest jobsRequest = ListJobsRequest.builder()
                .maxResults(10)
                .build();

        ListJobsResponse jobsResponse = emc.listJobs(jobsRequest);
        List<Job> jobs = jobsResponse.jobs();
        for (Job job : jobs) {
//            log.info("The JOB ARN is : {}, status : {}", job.arn(), job.status());
            System.out.printf("The JOB ARN is : %s, status : %s", job.arn(), job.status());
            System.out.println();
        }
    }
}
