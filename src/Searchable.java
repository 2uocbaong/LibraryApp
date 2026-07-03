import java.util.List;

public interface Searchable {
    List<Book> searchByTitle(String keyword);
    List<Book> searchByAuthor(String keyword);

    static String normalizeKeyword(String keyword) {
        if (keyword == null) return "";
        return keyword.trim().toLowerCase();
    }
}
