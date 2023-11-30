//snippet-sourcedescription:[GetJob.java demonstrates how to get information about a specific AWS Elemental MediaConvert job.]
//snippet-keyword:[AWS SDK for Java v2]
//snippet-service:[AWS Elemental MediaConvert]

/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

package groot.springboot.demo.amazonaws.media;

// snippet-start:[mediaconvert.java.get_job.import]

import groot.springboot.demo.utils.JsonUtils;
import software.amazon.awssdk.services.mediaconvert.MediaConvertClient;
import software.amazon.awssdk.services.mediaconvert.model.GetJobRequest;
import software.amazon.awssdk.services.mediaconvert.model.GetJobResponse;

/**
 * Before running this Java V2 code example, set up your development environment, including your credentials.
 * <p>
 * For more information, see the following documentation topic:
 * <p>
 * https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html
 */
public class GetJob {

    public static void main(String[] args) {

        String jobId = "1694171100933-x3z00b";
        MediaConvertClient mediaConvertClient = MediaConvertHelper.getMediaConvertClient(
                MediaConvertHelper.getMediaConvertProperties().getEndpoint()
        );
        getSpecificJob(mediaConvertClient, jobId);
        mediaConvertClient.close();
    }

    public static void getSpecificJob(MediaConvertClient mc, String jobId) {
        String endpointURL = MediaConvertHelper.getEndpoint(mc);
        MediaConvertClient emc = MediaConvertHelper.getMediaConvertClient(endpointURL);
        GetJobRequest jobRequest = GetJobRequest.builder()
                .id(jobId)
                .build();
        GetJobResponse response = emc.getJob(jobRequest);
        System.out.println("The ARN of the job is " + response.job().arn());
        System.out.println(JsonUtils.toGson(response.job()));
        System.out.println(response.job().status().name());
        System.out.println(response.job().status().toString());

    }
}
