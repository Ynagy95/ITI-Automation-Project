package proj.shopping.media;

import com.automation.remarks.video.RecorderFactory;
import com.automation.remarks.video.recorder.IVideoRecorder;
import com.automation.remarks.video.recorder.VideoRecorder;
import proj.shopping.utils.logs.LogsManager;
import proj.shopping.utils.datareader.PropertyReader;
import proj.shopping.utils.TimeStamp;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;
import ws.schild.jave.encode.VideoAttributes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenRecordManager {

    // Base folder for all recordings
    public static final Path RECORDINGS_PATH = Paths.get(System.getProperty("user.dir"), "test-output", "recordings");

    // Each test run gets its own timestamped subfolder
    private static final String RUN_TIMESTAMP = TimeStamp.getTimestamp();
    private static final Path RUN_FOLDER = RECORDINGS_PATH.resolve(RUN_TIMESTAMP);

    private static final ThreadLocal<IVideoRecorder> recorder = new ThreadLocal<>();

    static {
        try {
            Files.createDirectories(RUN_FOLDER);
            LogsManager.info("Recording folder created: " + RUN_FOLDER);
        } catch (Exception e) {
            LogsManager.error("Failed to create recordings folder: " + e.getMessage());
        }
    }

    /**
     * Starts screen recording.
     */
    public static void startRecording() {
        if (PropertyReader.getProperty("recordTests").equalsIgnoreCase("true")) {
            try {
                if (PropertyReader.getProperty("executionType").equalsIgnoreCase("local")) {

                    // Configure recorder and set the output folder
                    System.setProperty("video.folder", RUN_FOLDER.toString());

                    recorder.set(RecorderFactory.getRecorder(VideoRecorder.conf().recorderType()));
                    recorder.get().start();

                    LogsManager.info("🎥 Recording started in folder: " + RUN_FOLDER);
                }

            } catch (Exception e) {
                LogsManager.error("Failed to start recording: " + e.getMessage());
            }
        }
    }

    /**
     * Stops recording and converts to MP4.
     */
    public static void stopRecording(String testMethodName) {
        try {
            if (recorder.get() != null) {
                // Stop the recording
                String videoFilePath = String.valueOf(recorder.get().stopAndSave(testMethodName));
                File videoFile = new File(videoFilePath);

                LogsManager.info("🎬 Raw video file saved at: " + videoFile.getAbsolutePath());

                // Convert to MP4
                File mp4File = encodeRecording(videoFile);
                LogsManager.info("✅ Recording converted to MP4: " + mp4File.getAbsolutePath());
            }
        } catch (Exception e) {
            LogsManager.error("Failed to stop recording: " + e.getMessage());
        } finally {
            recorder.remove();
        }
    }

    /**
     * Converts .avi to .mp4 and deletes the original.
     */
    private static File encodeRecording(File sourceFile) {
        File targetFile = new File(sourceFile.getParent(), sourceFile.getName().replace(".avi", ".mp4"));
        try {
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("aac");

            VideoAttributes video = new VideoAttributes();
            video.setCodec("libx264");

            EncodingAttributes encodingAttributes = new EncodingAttributes();
            encodingAttributes.setOutputFormat("mp4");
            encodingAttributes.setAudioAttributes(audio);
            encodingAttributes.setVideoAttributes(video);

            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(sourceFile), targetFile, encodingAttributes);

            if (targetFile.exists()) {
                if (sourceFile.delete()) {
                    LogsManager.info("Deleted original .avi file: " + sourceFile.getName());
                }
            }
        } catch (EncoderException e) {
            LogsManager.error("Failed to convert video to MP4: " + e.getMessage());
        }
        return targetFile;
    }
}
