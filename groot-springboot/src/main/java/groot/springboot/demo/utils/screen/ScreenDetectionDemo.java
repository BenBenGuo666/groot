package groot.springboot.demo.utils.screen;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

/**
 * @author: GuoBen~
 * @date: 2023/7/17 19:08
 * @description:
 */
public class ScreenDetectionDemo {

    public static void main(String[] args) {
        System.setProperty("java.library.path", "/path/to/opencv/library");
        // 加载 OpenCV 库
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        // 加载待检测的图像
        String imagePath = "/Users/guobenben/Pictures/icon/cat_eyes.jpeg";
        Mat image = Imgcodecs.imread(imagePath);

        // 检测屏幕撕裂
        boolean hasScreenTearing = ScreenDetector.detectScreenTearing(image);
        if (hasScreenTearing) {
            System.out.println("屏幕发生撕裂！");
        } else {
            System.out.println("屏幕未发生撕裂。");
        }

        // 检测黑屏
        boolean isBlackScreen = ScreenDetector.detectBlackScreen(image);
        if (isBlackScreen) {
            System.out.println("屏幕处于黑屏状态！");
        } else {
            System.out.println("屏幕未处于黑屏状态。");
        }

        // 展示图像并等待关闭窗口
        HighGui.imshow("原始图像", image);
        HighGui.waitKey();

        // 释放资源
        HighGui.destroyAllWindows();
    }

}
