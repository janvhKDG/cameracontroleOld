package be.kdg.demo.Messengers.MessageQueue;

public interface MessageQueue {
    void initialize();
    void shutdown();
    void sendMessage(String message);
}
