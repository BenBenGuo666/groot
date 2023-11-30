package groot.springboot.demo.amazonaws.media;

import groot.springboot.demo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.mediaconvert.MediaConvertClient;
import software.amazon.awssdk.services.mediaconvert.model.*;

import java.util.List;

/**
 * @author: GuoBen~
 * @date: 2023/9/11 15:40
 * @description:
 */
@Slf4j
public class AmaMediaConvertApi {
    public static void main(String[] args) {
        String fileInput = "s3://dynfiles/明天会更好 (童声版) - 李如意.flac";
        String jobId = createMediaJob(fileInput);
        System.out.println(jobId);
        Job job = getSpecificJob(jobId);
        System.out.println("The ARN of the job is " + job.arn());
        System.out.println(JsonUtils.toGson(job));
        System.out.println(job.status().name());
        System.out.println(job.status().toString());
        listCompleteJobs();
    }

    /***
     * 创建 MediaConvert 转码任务
     * @param filePath
     * @return
     */
    public static String createMediaJob(String filePath) {
        JobSettings jobSettings = JobSettings.builder()
                .inputs(Input.builder()
                        .fileInput(filePath).build()).build();
        CreateJobRequest createJobRequest = CreateJobRequest.builder()
                .role(MediaConvertHelper.getMediaConvertProperties().getMcRoleARN())
                .jobTemplate(MediaConvertHelper.getMediaConvertProperties().getJobTemplate())
                .settings(jobSettings)
                .build();
        MediaConvertClient mediaConvertClient = MediaConvertHelper.getMediaConvertClient();
        MediaConvertClient jobMediaConvertClient = MediaConvertHelper.getJobMediaConvertClient(mediaConvertClient);
        CreateJobResponse createJobResponse = jobMediaConvertClient.createJob(createJobRequest);
        mediaConvertClient.close();
        jobMediaConvertClient.close();
        System.out.println(createJobResponse.job().status());
        return createJobResponse.job().id();
    }

    /**
     * 获取指定的 job 任务
     *
     * @param jobId
     */
    public static Job getSpecificJob(String jobId) {
        GetJobRequest jobRequest = GetJobRequest.builder()
                .id(jobId)
                .build();
        MediaConvertClient mediaConvertClient = MediaConvertHelper.getMediaConvertClient();
        MediaConvertClient jobMediaConvertClient = MediaConvertHelper.getJobMediaConvertClient(mediaConvertClient);
        Job job = jobMediaConvertClient.getJob(jobRequest).job();
        mediaConvertClient.close();
        jobMediaConvertClient.close();
        return job;
    }

    /**
     * 获取 job 任务列表
     *
     * @param
     */
    public static void listCompleteJobs() {
        MediaConvertClient mediaConvertClient = MediaConvertHelper.getMediaConvertClient();
        MediaConvertClient jobMediaConvertClient = MediaConvertHelper.getJobMediaConvertClient(mediaConvertClient);
        ListJobsRequest jobsRequest = ListJobsRequest.builder()
                .maxResults(20)
                .build();
        ListJobsResponse jobsResponse = jobMediaConvertClient.listJobs(jobsRequest);
        mediaConvertClient.close();
        jobMediaConvertClient.close();
        List<Job> jobs = jobsResponse.jobs();
        for (Job job : jobs) {
            System.out.printf("The JOB ARN is : %s, status : %s", job.arn(), job.status());
            System.out.println();
        }
    }

}
