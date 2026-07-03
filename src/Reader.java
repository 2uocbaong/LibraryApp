import java.util.*;

public class Reader implements Notifiable {
    private String readerId;
    private String name;
    private List<String> notifications = new ArrayList<>();

    public Reader(String readerId, String name) {
        this.readerId = readerId;
        this.name = name;
    }

    @Override
    public void sendNotification(String message) {
        notifications.add(message);
        System.out.println("[" + name + "] " + message);
    }

    @Override
    public List<String> getNotificationHistory() {
        return Collections.unmodifiableList(notifications);
    }

    public String getReaderId() { return readerId; }
    public String getName() { return name; }
}
