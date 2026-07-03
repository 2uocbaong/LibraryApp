import java.util.List;

public interface Notifiable {
    void sendNotification(String message);
    List<String> getNotificationHistory();

    default void sendOverdueNotification() {
        sendNotification("[NHAC NHO] Ban co sach qua han. Vui long tra sach som.");
    }
}
