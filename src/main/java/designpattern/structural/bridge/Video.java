package designpattern.structural.bridge;

public abstract class Video {

    VideoProcessor processor;

    Video(VideoProcessor processor){
        this.processor=processor;
    }

    public abstract void play();
}
