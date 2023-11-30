package groot.springboot.demo.utils.screen;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.util.Collections;

/**
 * @author: GuoBen~
 * @date: 2023/7/17 18:16
 * @description:
 */
public class ScreenDetector {

    private static final int HISTOGRAM_BINS = 256;
    // 调整阈值
    private static final double SIMILARITY_THRESHOLD = 0.98;

    // 实现花屏检测的逻辑，返回true或false
    public static boolean detectScreenTearing(Mat image) {
        Mat grayImage = convertToGray(image);
        Mat hist = calculateNormalizedHistogram(grayImage);
        double similarity = compareHistograms(hist, hist);
        return similarity < SIMILARITY_THRESHOLD;
    }


    // 实现黑屏检测的逻辑，返回true或false
    public static boolean detectBlackScreen(Mat image) {
        Mat grayImage = convertToGray(image);
        // 调整阈值
        Mat thresholded = applyThreshold(grayImage, 10);
        double blackPixelsRatio = calculateBlackPixelsRatio(thresholded);
        // 调整阈值
        return blackPixelsRatio > 0.95;
    }

    public static boolean detectFlickering(Mat currentImage, Mat previousImage) {
        Mat currentGrayImage = convertToGray(currentImage);
        Mat previousGrayImage = convertToGray(previousImage);
        Mat diff = calculateAbsoluteDifference(currentGrayImage, previousGrayImage);
        double flickeringRatio = calculateFlickeringRatio(diff);
        // 调整阈值
        return flickeringRatio > 0.05;
    }

    // 实现闪屏检测的逻辑，返回true或false
    private static Mat convertToGray(Mat image) {
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);
        return grayImage;
    }

    private static Mat calculateNormalizedHistogram(Mat image) {
        Mat hist = new Mat();
        Imgproc.calcHist(Collections.singletonList(image), new MatOfInt(0), new Mat(), hist, new MatOfInt(HISTOGRAM_BINS), new MatOfFloat(0, HISTOGRAM_BINS));
        Core.normalize(hist, hist, 0, 1, Core.NORM_MINMAX);
        return hist;
    }

    private static double compareHistograms(Mat hist1, Mat hist2) {
        return Imgproc.compareHist(hist1, hist2, Imgproc.CV_COMP_CORREL);
    }

    private static Mat applyThreshold(Mat grayImage, int thresholdValue) {
        Mat thresholded = new Mat();
        Imgproc.threshold(grayImage, thresholded, thresholdValue, 255, Imgproc.THRESH_BINARY);
        return thresholded;
    }

    private static double calculateBlackPixelsRatio(Mat image) {
        Mat blackPixels = new Mat();
        Core.findNonZero(image, blackPixels);
        double totalPixels = image.size().area();
        return blackPixels.rows() / totalPixels;
    }

    private static Mat calculateAbsoluteDifference(Mat image1, Mat image2) {
        Mat diff = new Mat();
        Core.absdiff(image1, image2, diff);
        return diff;
    }

    private static double calculateFlickeringRatio(Mat diff) {
        Scalar meanDiff = Core.mean(diff);
        return meanDiff.val[0] / 255.0;
    }

}
