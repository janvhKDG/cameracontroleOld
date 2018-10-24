package be.kdg.demo.Generators;

public class FreqBlock {
    private int seconds;
    private int messageCountPerSecond;

    public FreqBlock(int seconds, int messageCountPerSecond) {
        this.seconds = seconds;
        this.messageCountPerSecond = messageCountPerSecond;
    }
}
