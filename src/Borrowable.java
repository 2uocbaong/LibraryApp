public interface Borrowable {

    // Hang so
    int MAX_BORROW_DAYS = 14;      // So ngay muon toi da
    double FINE_PER_DAY = 5000.0;  // Phat 5,000 VND/ngay tre

    // Abstract methods
    void borrowBy(String readerId, String date); // Muon boi doc gia
    void returnBook(String date);                 // Tra sach
    boolean isAvailable();                        // Con trong khong?
    String getBorrowerId();                       // Ai dang muon?

    // Default method
    default double calculateFine(int daysOverdue) {
        if (daysOverdue <= 0) return 0.0;
        return daysOverdue * FINE_PER_DAY;
    }

    // Static method
    static boolean isValidBorrowDuration(int days) {
        return days > 0 && days <= MAX_BORROW_DAYS;
    }
}
