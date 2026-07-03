import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("########## BAI 1: Borrowable ##########");
        testBai1();

        System.out.println();
        System.out.println("########## BAI 2: Returnable & Searchable ##########");
        testBai2();

        System.out.println();
        System.out.println("########## BAI 3 - Phan A: Fineable ##########");
        testFineable();

        System.out.println();
        System.out.println("########## BAI 3 - Phan B & C: Notifiable + Da hinh ##########");
        testBai3PhanBC();
    }

    // ---------- Bai 1 ----------
    static void testBai1() {
        Borrowable book1 = new Book("B001", "Clean Code", "Robert Martin");
        Borrowable book2 = new Book("B002", "Design Patterns", "GoF");

        book1.borrowBy("R001", "2024-09-01");
        System.out.println("Available: " + book2.isAvailable()); // true

        // Dung static method cua interface
        System.out.println(Borrowable.isValidBorrowDuration(10)); // true
        System.out.println(Borrowable.isValidBorrowDuration(20)); // false

        // Dung default method
        System.out.println(book1.calculateFine(3)); // 15000.0

        book1.returnBook("2024-09-15");
    }

    // ---------- Bai 2 ----------
    static void testBai2() {
        // Returnable + BorrowSlip
        BorrowSlip slip = new BorrowSlip("S001", "R001", "B001", "2024-09-10");
        System.out.println("Da tra chua? " + slip.isReturned());          // false
        System.out.println("Qua han chua? " + slip.isLate("2024-09-10")); // true (neu hom nay sau 2024-09-10)
        slip.confirmReturn("2024-09-20");
        System.out.println("Da tra chua? " + slip.isReturned());          // true

        // Searchable + Library
        Library library = new Library();
        library.addBook(new Book("B001", "Clean Code", "Robert Martin"));
        library.addBook(new Book("B002", "Clean Architecture", "Robert Martin"));
        library.addBook(new Book("B003", "Design Patterns", "GoF"));

        List<Book> byTitle = library.searchByTitle("clean");
        System.out.println("Tim theo title 'clean': " + byTitle.size() + " ket qua");
        for (Book b : byTitle) System.out.println("  - " + b.getTitle());

        List<Book> byAuthor = library.searchByAuthor("Robert Martin");
        System.out.println("Tim theo author 'Robert Martin': " + byAuthor.size() + " ket qua");
    }

    // ---------- Bai 3 - Phan A ----------
    static void testFineable() {
        Fine fine = new Fine("F001", "R001");
        double tienPhat = fine.calculateTotalFine(5); // default method: 5 ngay * 5000
        System.out.println("Tien phat 5 ngay tre: " + tienPhat);

        fine.addFine(tienPhat);
        System.out.println("Tong tien phat hien tai: " + fine.getTotalFine());
        System.out.println("Da thanh toan chua? " + fine.hasPaidFine());

        fine.payFine();
        System.out.println("Da thanh toan chua? " + fine.hasPaidFine());

        System.out.println("So tien 500000 hop le? " + Fineable.isValidFineAmount(500000)); // false, > MAX_FINE
        System.out.println("So tien 100000 hop le? " + Fineable.isValidFineAmount(100000)); // true
    }

    // ---------- Bai 3 - Phan B + C ----------
    static void testBai3PhanBC() {
        LibraryManager mgr = new LibraryManager();

        List<Borrowable> items = new ArrayList<>();
        Book b1 = new Book("B001", "Clean Code", "Robert Martin");
        Book b2 = new Book("B002", "Design Patterns", "GoF");
        b1.borrowBy("R001", "2024-09-01");
        items.add(b1);
        items.add(b2);

        mgr.processAllBorrowable(items);

        List<Notifiable> readers = new ArrayList<>();
        Reader r1 = new Reader("R001", "Nguyen Van A");
        Reader r2 = new Reader("R002", "Tran Thi B");
        readers.add(r1);
        readers.add(r2);

        mgr.notifyAll(readers, "Thu vien se dong cua ngay 20/9.");

        // default method sendOverdueNotification()
        r1.sendOverdueNotification();
        System.out.println("Lich su thong bao cua " + r1.getName() + ": " + r1.getNotificationHistory().size() + " tin");
    }
}
