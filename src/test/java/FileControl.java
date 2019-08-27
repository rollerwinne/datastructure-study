import it.sauronsoftware.jave.EncoderException;
import org.junit.Test;

import java.io.File;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

public class FileControl {
    @Test
    public void sumFileTime() throws EncoderException {
        System.out.println("begin");
        File path = new File("/Users/mmc/Desktop/数据结构与算法/视频");
        Encoder encoder = new Encoder();
        if (path.isDirectory()) {
            File[] files = path.listFiles();
            for (File file : files) {
                System.out.println(file.getName());
                MultimediaInfo m = encoder.getInfo(file);
                long seconds = m.getDuration() / 1000;
                String timestr = seconds / 60 + ":" + seconds % 60;
                System.out.println(timestr + " :::" + file.getName());
            }
//            for (File file:files) {
//                System.out.println(file.getName());
//                MultimediaInfo m = encoder.getInfo(file);
//                String fileformat = m.getFormat();
//                System.out.println(fileformat+" :::"+file.getName());
//            }
        } else throw new RuntimeException("目录不存在");
    }
}
