package sample;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.video.BackgroundSubtractorMOG2;
import org.opencv.video.Video;


public class ImageProcessing {

    BackgroundSubtractorMOG2 mog2 = Video.createBackgroundSubtractorMOG2(30,100,false);



    public Mat backroundSubtraction (Mat input, double blurValue, double threshValue) {

        int dialateSize = 10;

        Mat output = new Mat();
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * dialateSize +1 , 2* dialateSize +1));

        mog2.apply(input,output,-1);

        Imgproc.blur(output,output,new Size (blurValue,blurValue));
        Imgproc.threshold(output,output,threshValue,255,0);
        Imgproc.dilate(output,output,element, new Point(-1,-1),1,1, new Scalar(0,0,0));



        return output;
    }


}


