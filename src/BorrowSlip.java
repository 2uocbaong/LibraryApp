public class BorrowSlip implements Returnable {
    private String slipId;
    private String readerId;
    private String bookId;
    private String dueDate;
    private String returnDate; // null neu chua tra

    public BorrowSlip(String slipId, String readerId, String bookId, String dueDate) {
        this.slipId = slipId;
        this.readerId = readerId;
        this.bookId = bookId;
        this.dueDate = dueDate;
    }

    @Override
    public void confirmReturn(String date) {
        this.returnDate = date;
        System.out.println("Slip " + slipId + " confirmed return on " + date);
    }

    @Override public String getReturnDate() { return returnDate; }
    @Override public boolean isReturned() { return returnDate != null; }

    public String getSlipId() { return slipId; }
    public String getReaderId() { return readerId; }
    public String getBookId() { return bookId; }
    public String getDueDate() { return dueDate; }
}
