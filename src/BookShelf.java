import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookShelf {
    public static void main(String[] args) {
        List<String> books = Arrays.asList(
                "Вий", "Азбука", "Мастер и Маргарита",
                "Война и мир", "Преступление и наказание", "Белая гвардия"
        );

        List<List<String>> shelves = distributeBooks(books);

        for (int i = 0; i < shelves.size(); i++) {
            System.out.println("Полка " + (i + 1) + ": " + shelves.get(i));
        }
    }

    public static List<List<String>> distributeBooks(List<String> books) {

        int numShelves = 5;

        List<String> sortedBooks = new ArrayList<>(books);
        Collections.sort(sortedBooks);

        List<List<String>> shelves = new ArrayList<>();

        int numBooks = sortedBooks.size();
        int booksPerShelf = numBooks / numShelves;
        int remainingBooks = numBooks % numShelves;

        int startIndex = 0;
        int endIndex;

        for (int i = 0; i < numShelves; i++) {
            endIndex = startIndex + booksPerShelf + (remainingBooks > 0 ? 1 : 0);
            shelves.add(sortedBooks.subList(startIndex, endIndex));
            startIndex = endIndex;
            remainingBooks--;
        }
        return shelves;
    }
}
