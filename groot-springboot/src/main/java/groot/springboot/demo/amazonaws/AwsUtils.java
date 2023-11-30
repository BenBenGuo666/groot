package groot.springboot.demo.amazonaws;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import groot.springboot.demo.utils.DateUtils;
import groot.springboot.demo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;

/**
 * @author: GuoBen~
 * @date: 2023/5/6 09:46
 * @description:
 */
@Slf4j
public class AwsUtils {

  /*  public static String getAuthenticationToken(AwsCredentialsProvider awsAuth, Region awsRegion, String clusterName) {
        try {
            SdkHttpFullRequest requestToSign = SdkHttpFullRequest
                    .builder()
                    .method(SdkHttpMethod.GET)
                    .uri(StsUtil.getStsRegionalEndpointUri(awsRegion))
                    .appendHeader("x-k8s-aws-id", clusterName)
                    .appendRawQueryParameter("Action", "GetCallerIdentity")
                    .appendRawQueryParameter("Version", "2011-06-15")
                    .build();

            ZonedDateTime expirationDate = DateUtil.addSeconds(DateUtil.now(), 60);
            Aws4PresignerParams presignerParams = Aws4PresignerParams.builder()
                    .awsCredentials(awsAuth.resolveCredentials())
                    .signingRegion(awsRegion)
                    .signingName("sts")
                    .signingClockOverride(Clock.systemUTC())
                    .expirationTime(expirationDate.toInstant())
                    .build();

            SdkHttpFullRequest signedRequest = Aws4Signer.create().presign(requestToSign, presignerParams);

            String encodedUrl = Base64.getUrlEncoder().withoutPadding().encodeToString(signedRequest.getUri().toString().getBytes(CharSet.UTF_8.getCharset()));
            return ("k8s-aws-v1." + encodedUrl);
        } catch (Exception e) {
            String errorMessage = "A problem occurred generating an Eks authentication token for cluster: " + clusterName;
            logger.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }*/

    public static void main(String[] args) {
       /* String path = "https://sts.amazonaws.com/\n" +
                "?Version=2011-06-15\n" +
                "&Action=GetSessionToken\n" +
                "&DurationSeconds=1800\n" +
                "&AUTHPARAMS";
        BaseAws4Signer b;
        AbstractAws4Signer a;
        */
//        StsClient stsClient = new DefaultStsClient();
        String endpoint = "https://sts.cn-north-1.amazonaws.com.cn";
        String path = "https://sts.amazonaws.com/";
        String Action = "&Action=GetSessionToken";
        String Version = "&Version=2011-06-15";
        String DurationSeconds = "&DurationSeconds=3600";
        String SerialNumber = "&SerialNumber=";
        String TokenCode = "&TokenCode=";
        String AUTHPARAMS = "&";
        //
        Regions clientRegion = Regions.CN_NORTH_1;
        String bucketName = "dynaudio";
        String federatedUser = "*** Federated user name ***";
        String resourceARN = "arn:aws:s3:::" + bucketName;
        String accessKeyId = "AKIA2KMX5XEKVDQIE3V4";
        String accessKeySecret = "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";

        try {
     /*       AWSSecurityTokenService stsClient = AWSSecurityTokenServiceClientBuilder
                    .standard()
                    .withCredentials(new ProfileCredentialsProvider())
                    .withRegion(clientRegion)
                    .build();*/

            GetSessionTokenRequest getSessionTokenRequest = new GetSessionTokenRequest();
            getSessionTokenRequest.setDurationSeconds(129600);
            getSessionTokenRequest.withRequestCredentialsProvider(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKeyId, accessKeySecret)));
            // Define the policy and add it to the request.
/*            Policy policy = new Policy();
            policy.withStatements(new Statement(Effect.Allow)
                    .withActions(S3Actions.ListObjects)
                    .withResources(new Resource(resourceARN)));*/
            AwsClientBuilder.EndpointConfiguration endpointConfiguration =
                    new AwsClientBuilder.EndpointConfiguration("https://sts.cn-north-1.amazonaws.com.cn", null);
            AWSSecurityTokenService stsClient = AWSSecurityTokenServiceClientBuilder.standard()
                    .withCredentials(
                            new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKeyId, accessKeySecret)))
//                    .withRegion(clientRegion)
                    .withEndpointConfiguration(endpointConfiguration).build();

            // Get the temporary security credentials.
            GetSessionTokenResult getSessionTokenResult = stsClient.getSessionToken(getSessionTokenRequest);
            Credentials sessionCredentials = getSessionTokenResult.getCredentials();
            System.out.println("sessionCredentials::" + sessionCredentials);
            System.out.println("sessionCredentials::" + DateUtils.format(sessionCredentials.getExpiration()));
            // Package the session credentials as a BasicSessionCredentials
            // object for an Amazon S3 client object to use.

            BasicSessionCredentials basicSessionCredentials = new BasicSessionCredentials(
                    sessionCredentials.getAccessKeyId(),
                    sessionCredentials.getSecretAccessKey(),
                    sessionCredentials.getSessionToken());
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(basicSessionCredentials))
                    .withEndpointConfiguration(
                            new AwsClientBuilder.EndpointConfiguration(
                                    "https://s3.cn-northwest-1.amazonaws.com.cn",
                                    null))
                    .build();
            /*Map<String, Object> result = null;
            result.put("storeType", "s3");
            result.put("accessKeyId", sessionCredentials.getAccessKeyId());
            result.put("sessionToken", sessionCredentials.getSessionToken());
            result.put("secretKey", sessionCredentials.getSecretAccessKey());
            result.put("expire", sessionCredentials.getExpiration());
            result.put("dir", dir);
            result.put("bucketName", ossInfo.bucketName);
            result.put("region", ossInfo.region);
            result.put("host", "https://" + ossInfo.endpoint + "/" + ossInfo.bucketName);*/

            // To verify that the client works, send a listObjects request using
            // the temporary security credentials.
            /*URL url = new URL("https://sts.cn-north-1.amazonaws.com.cn/" + bucketName);
            PresignedUrlUploadRequest presignedUrlUploadRequest = new PresignedUrlUploadRequest(url);
            presignedUrlUploadRequest.withFile(new File("/Users/guobenben/Downloads/上汽奥迪A7L装备表-特别版.pdf"));
            presignedUrlUploadRequest.withHttpMethodName(HttpMethodName.POST);*/
            /*UploadPartRequest uploadPartRequest = new UploadPartRequest();
            uploadPartRequest.withBucketName(bucketName);
            uploadPartRequest.withKey("");
            uploadPartRequest.withUploadId("1");
            uploadPartRequest.withFile(new File("/Users/guobenben/Downloads/上汽奥迪A7L装备表-特别版.pdf"));
            UploadPartResult uploadPartResult = s3Client.uploadPart(uploadPartRequest);
            System.out.println("No. of Objects = " + uploadPartResult);*/

            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, "demo",
                    new File("/Users/guobenben/Downloads/demo.txt"));
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("plain/text");
            metadata.addUserMetadata("title", "someTitle");
            putObjectRequest.setMetadata(metadata);
            PutObjectResult putObjectResult = s3Client.putObject(putObjectRequest);
            System.out.println("No. of Objects = " + putObjectResult);
            System.out.println(JsonUtils.toGson(putObjectResult));

            /*HttpRequest httpRequest = HttpRequest.get("https://s3-control.amazonaws.com.cn/v20180820/accesspoint/Dynaudio");
            httpRequest.header("x-amz-account-id","709525092629");
            httpRequest.header("Host","s3-control.amazonaws.com.cn");
            System.out.println(httpRequest);
            HttpResponse httpResponse = httpRequest.execute();
            System.out.println(httpResponse);*/
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
        System.out.println(12 * 60 * 60);
    }


    // Return a byte array.
    private static byte[] getObjectFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {
            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return bytesArray;
    }

}
