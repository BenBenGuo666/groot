package groot.springboot.demo.amazonaws.media;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.services.mediaconvert.MediaConvertClient;
import software.amazon.awssdk.services.mediaconvert.model.DescribeEndpointsRequest;
import software.amazon.awssdk.services.mediaconvert.model.DescribeEndpointsResponse;

import java.net.URI;

/**
 * @author: GuoBen~
 * @date: 2023/9/11 13:50
 * @description:
 */
@Slf4j
public class MediaConvertHelper {
    private static MediaConvertProperties mediaConvertProperties;

    public static void main(String[] args) {
        System.out.println(getEndpoint(getMediaConvertClient(getMediaConvertProperties().getEndpoint())));
    }

    public static MediaConvertClient getJobMediaConvertClient(MediaConvertClient mediaConvertClient) {
        return getMediaConvertClient(getEndpoint(mediaConvertClient));
    }

    public static MediaConvertClient getMediaConvertClient() {
        URI uri = URI.create(getMediaConvertProperties().getEndpoint());
        StaticCredentialsProvider staticCredentialsProvider
                = StaticCredentialsProvider.create(getAwsBasicCredentials());
        return MediaConvertClient.builder()
                .credentialsProvider(staticCredentialsProvider)
                .endpointOverride(uri)
                .region(getMediaConvertProperties().getRegion())
                .build();
    }

    public static MediaConvertClient getMediaConvertClient(String endpointURL) {
        URI uri = URI.create(endpointURL);
        StaticCredentialsProvider staticCredentialsProvider
                = StaticCredentialsProvider.create(getAwsBasicCredentials());
        return MediaConvertClient.builder()
                .credentialsProvider(staticCredentialsProvider)
                .endpointOverride(uri)
                .region(getMediaConvertProperties().getRegion())
                .build();
    }

    public static String getEndpoint(MediaConvertClient mc) {
        int maxResults = 1;
        DescribeEndpointsRequest describeEndpointsRequest =
                DescribeEndpointsRequest.builder().maxResults(maxResults).build();
        DescribeEndpointsResponse res = mc.describeEndpoints(describeEndpointsRequest);
        if (CollectionUtil.isEmpty(res.endpoints())) {
            return null;
        }
        int resultsIndex = 0;
        return res.endpoints().get(resultsIndex).url();
    }

    public static AwsBasicCredentials getAwsBasicCredentials() {
        return AwsBasicCredentials.create(
                getMediaConvertProperties().getAccessKeyId(),
                getMediaConvertProperties().getAccessKeySecret());
    }


    public static MediaConvertProperties getMediaConvertProperties() {
        if (null == mediaConvertProperties) {
            mediaConvertProperties = new MediaConvertProperties();
        }
        return mediaConvertProperties;
    }

}
