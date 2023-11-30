package groot.springboot.demo.amazonaws.media;

import lombok.Data;
import software.amazon.awssdk.regions.Region;

/**
 * @author: GuoBen~
 * @date: 2023/9/11 13:51
 * @description:
 */
@Data
public class MediaConvertProperties {


    private String accessKeyId = "AKIA2KMX5XEKVDQIE3V4";
    private String accessKeySecret = "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";

    private String mcRoleARN = "arn:aws-cn:iam::709525092629:role/MediaConvert_Default_Role";
    private Region region = Region.CN_NORTHWEST_1;
    private String endpoint = "https://subscribe.mediaconvert.cn-northwest-1.amazonaws.com.cn";
    private String jobTemplate = "Mp4Template";
}
