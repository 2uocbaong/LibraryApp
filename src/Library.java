import java.util.*;

public class Library implements Searchable {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book b) { books.add(b); }

    @Override
    public List<Book> searchByTitle(String keyword) {
        String kw = Searchable.normalizeKeyword(keyword);
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(kw)) result.add(b);
        }
        return result;
    }

    @Override
    public List<Book> searchByAuthor(String keyword) {
        String kw = Searchable.normalizeKeyword(keyword);
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().contains(kw)) result.add(b);
        }
        return result;
    }
}
