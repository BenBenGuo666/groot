//snippet-sourcedescription:[CreateJob.java demonstrates how to create AWS Elemental MediaConvert jobs.]
//snippet-keyword:[AWS SDK for Java v2]
//snippet-service:[AWS Elemental MediaConvert]

/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/
// snippet-start:[mediaconvert.java.createjob.complete]
package groot.springboot.demo.amazonaws.media;

import lombok.SneakyThrows;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.mediaconvert.MediaConvertClient;
import software.amazon.awssdk.services.mediaconvert.model.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Create a MediaConvert job. Must supply MediaConvert access role Amazon Resource Name (ARN), and a
 * valid video input file via Amazon S3 URL.
 * <p>
 * Also, set up your development environment, including your credentials.
 * <p>
 * For information, see this documentation topic:
 * <p>
 * https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html
 */
public class CreateJob {

    static String fileOutputPath = "s3://dynfiles/MediaConverOutputDemo";
    static String accessKeyId = "AKIA2KMX5XEKVDQIE3V4";
    static String accessKeySecret = "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";

    static String mcRoleARN = "arn:aws-cn:iam::709525092629:role/MediaConvert_Default_Role";
    //        String fileInput = "/Users/guobenben/Downloads/明天会更好 (童声版) - 李如意.flac";
    static String fileInput = "s3://dynfiles/明天会更好 (童声版) - 李如意.flac";
    static Region region = Region.CN_NORTHWEST_1;

    static String endpoint = "https://subscribe.mediaconvert.cn-northwest-1.amazonaws.com.cn";

    @SneakyThrows
    public static void main(String[] args) {
        URI uri = new URI(endpoint);
        MediaConvertClient mc = MediaConvertClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKeyId, accessKeySecret)))
                .endpointOverride(uri)
                .region(region)
                .build();
        String id = createMediaJob(mc, mcRoleARN, fileInput);
        System.out.println("MediaConvert job created. Job Id = " + id);
        mc.close();
    }

    public static String createMediaJob(MediaConvertClient mc, String mcRoleARN, String fileInput) {
        String s3path = fileOutputPath;
        String mp4Output = s3path + "/";
        String endpointURL = MediaConvertHelper.getEndpoint(mc);
        System.out.println("MediaConvert service URL: " + endpointURL);
        System.out.println("MediaConvert role arn: " + mcRoleARN);
        System.out.println("MediaConvert input file: " + fileInput);
        System.out.println("MediaConvert output path: " + s3path);

        MediaConvertClient emc = MediaConvertHelper.getMediaConvertClient(endpointURL);

        OutputGroup fileMp4 = OutputGroup.builder().name("File Group").customName("mp4")
                .outputGroupSettings(OutputGroupSettings.builder().type(OutputGroupType.FILE_GROUP_SETTINGS)
                        .fileGroupSettings(FileGroupSettings.builder().destination(mp4Output).build()).build())
                .outputs(Output.builder().extension("mp4")
                        .containerSettings(ContainerSettings.builder().container(ContainerType.MP4).build())
                        .audioDescriptions(AudioDescription.builder()
                                .audioTypeControl(AudioTypeControl.FOLLOW_INPUT)
                                .languageCodeControl(AudioLanguageCodeControl.FOLLOW_INPUT)
                                .codecSettings(AudioCodecSettings.builder().codec(AudioCodec.AAC)
                                        .aacSettings(AacSettings.builder().codecProfile(AacCodecProfile.LC)
                                                .rateControlMode(AacRateControlMode.CBR)
                                                .codingMode(AacCodingMode.CODING_MODE_2_0).sampleRate(44100)
                                                .bitrate(160000).rawFormat(AacRawFormat.NONE)
                                                .specification(AacSpecification.MPEG4)
                                                .audioDescriptionBroadcasterMix(
                                                        AacAudioDescriptionBroadcasterMix.NORMAL)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build())
                .build();

        Map<String, AudioSelector> audioSelectors = new HashMap<>();
        audioSelectors.put("Audio Selector 1",
                AudioSelector.builder().defaultSelection(AudioDefaultSelection.DEFAULT).offset(0).build());

        JobSettings jobSettings = JobSettings.builder()
                .inputs(Input.builder()
                        /*       .audioSelectors(audioSelectors)
                               .videoSelector(
                                       VideoSelector.builder().colorSpace(ColorSpace.FOLLOW).rotate(InputRotate.DEGREE_0).build())
                               .filterEnable(InputFilterEnable.AUTO).filterStrength(0).deblockFilter(InputDeblockFilter.DISABLED)
                               .denoiseFilter(InputDenoiseFilter.DISABLED).psiControl(InputPsiControl.USE_PSI)
                               .timecodeSource(InputTimecodeSource.EMBEDDED)*/
                        .fileInput(fileInput).build())
                .outputGroups(fileMp4).build();

        CreateJobRequest createJobRequest = CreateJobRequest.builder()
                .role(mcRoleARN)
                .jobTemplate("Mp4Template")
                .settings(jobSettings)
                .build();

        CreateJobResponse createJobResponse = emc.createJob(createJobRequest);
        return createJobResponse.job().id();

    }

    private final static Output createOutput(String customName,
                                             String nameModifier,
                                             String segmentModifier,
                                             int qvbrMaxBitrate,
                                             int qvbrQualityLevel,
                                             int originWidth,
                                             int originHeight,
                                             int targetWidth) {

        int targetHeight = Math.round(originHeight * targetWidth / originWidth)
                - (Math.round(originHeight * targetWidth / originWidth) % 4);
        Output output = null;
        try {
            output = Output.builder().nameModifier(nameModifier).outputSettings(OutputSettings.builder()
                            .hlsSettings(HlsSettings.builder().segmentModifier(segmentModifier).audioGroupId("program_audio")
                                    .iFrameOnlyManifest(HlsIFrameOnlyManifest.EXCLUDE).build())
                            .build())
                    .containerSettings(ContainerSettings.builder().container(ContainerType.M3_U8)
                            .m3u8Settings(M3u8Settings.builder().audioFramesPerPes(4)
                                    .pcrControl(M3u8PcrControl.PCR_EVERY_PES_PACKET).pmtPid(480).privateMetadataPid(503)
                                    .programNumber(1).patInterval(0).pmtInterval(0).scte35Source(M3u8Scte35Source.NONE)
                                    .scte35Pid(500).nielsenId3(M3u8NielsenId3.NONE).timedMetadata(TimedMetadata.NONE)
                                    .timedMetadataPid(502).videoPid(481)
                                    .audioPids(482, 483, 484, 485, 486, 487, 488, 489, 490, 491, 492).build())
                            .build())
                    .videoDescription(
                            VideoDescription.builder().width(targetWidth).height(targetHeight)
                                    .scalingBehavior(ScalingBehavior.DEFAULT).sharpness(50).antiAlias(AntiAlias.ENABLED)
                                    .timecodeInsertion(VideoTimecodeInsertion.DISABLED)
                                    .colorMetadata(ColorMetadata.INSERT).respondToAfd(RespondToAfd.NONE)
                                    .afdSignaling(AfdSignaling.NONE).dropFrameTimecode(DropFrameTimecode.ENABLED)
                                    .codecSettings(VideoCodecSettings.builder().build())
                                    /*    .codecSettings(VideoCodecSettings.builder().codec(VideoCodec.H_264)
                                                .h264Settings(H264Settings.builder()
                                                        .rateControlMode(H264RateControlMode.QVBR)
                                                        .parControl(H264ParControl.INITIALIZE_FROM_SOURCE)
                                                        .qualityTuningLevel(H264QualityTuningLevel.SINGLE_PASS)
                                                        .qvbrSettings(H264QvbrSettings.builder()
                                                                .qvbrQualityLevel(qvbrQualityLevel).build())
                                                        .codecLevel(H264CodecLevel.AUTO)
                                                        .codecProfile((targetHeight > 720 && targetWidth > 1280)
                                                                ? H264CodecProfile.HIGH
                                                                : H264CodecProfile.MAIN)
                                                        .maxBitrate(qvbrMaxBitrate)
                                                        .framerateControl(H264FramerateControl.INITIALIZE_FROM_SOURCE)
                                                        .gopSize(2.0).gopSizeUnits(H264GopSizeUnits.SECONDS)
                                                        .numberBFramesBetweenReferenceFrames(2).gopClosedCadence(1)
                                                        .gopBReference(H264GopBReference.DISABLED)
                                                        .slowPal(H264SlowPal.DISABLED).syntax(H264Syntax.DEFAULT)
                                                        .numberReferenceFrames(3).dynamicSubGop(H264DynamicSubGop.STATIC)
                                                        .fieldEncoding(H264FieldEncoding.PAFF)
                                                        .sceneChangeDetect(H264SceneChangeDetect.ENABLED).minIInterval(0)
                                                        .telecine(H264Telecine.NONE)
                                                        .framerateConversionAlgorithm(
                                                                H264FramerateConversionAlgorithm.DUPLICATE_DROP)
                                                        .entropyEncoding(H264EntropyEncoding.CABAC).slices(1)
                                                        .unregisteredSeiTimecode(H264UnregisteredSeiTimecode.DISABLED)
                                                        .repeatPps(H264RepeatPps.DISABLED)
                                                        .adaptiveQuantization(H264AdaptiveQuantization.HIGH)
                                                        .spatialAdaptiveQuantization(
                                                                H264SpatialAdaptiveQuantization.ENABLED)
                                                        .temporalAdaptiveQuantization(
                                                                H264TemporalAdaptiveQuantization.ENABLED)
                                                        .flickerAdaptiveQuantization(
                                                                H264FlickerAdaptiveQuantization.DISABLED)
                                                        .softness(0).interlaceMode(H264InterlaceMode.PROGRESSIVE).build())
                                                .build()
                                        )*/
                                    .build()
                    )
                    .audioDescriptions(AudioDescription.builder().audioTypeControl(AudioTypeControl.FOLLOW_INPUT)
                            .languageCodeControl(AudioLanguageCodeControl.FOLLOW_INPUT)
//                                    .codecSettings(AudioCodecSettings.builder().codec(AudioCodec.AAC).build())
                            .codecSettings(AudioCodecSettings.builder().codec(AudioCodec.AAC).aacSettings(AacSettings
                                            .builder().codecProfile(AacCodecProfile.LC).rateControlMode(AacRateControlMode.CBR)
                                            .codingMode(AacCodingMode.CODING_MODE_2_0).sampleRate(44100).bitrate(96000)
                                            .rawFormat(AacRawFormat.NONE).specification(AacSpecification.MPEG4)
                                            .audioDescriptionBroadcasterMix(AacAudioDescriptionBroadcasterMix.NORMAL).build())
                                    .build()
                            )
                            .build())
                    .build();
        } catch (MediaConvertException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return output;
    }
}
