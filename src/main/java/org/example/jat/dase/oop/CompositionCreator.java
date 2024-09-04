package org.example.jat.dase.oop;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
2. Create composition and aggregation example.

Composition.

In composition, the BookPage objects are integral parts of the Book and cannot exist independently.

If the Book is destroyed, its BookPage objects are also destroyed.

Here's a UML class diagram that represents the composition relationship between Book and BookPage:

+---------------------------------+
|         Book                    |
+---------------------------------+
| - title: String                 |
| - author: String                |
| - pages: List<BookPage>         |
+---------------------------------+
| + addPage(page: BookPage): void |
| + getPages(): List<BookPage>    |
+---------------------------------+
              1
              |
              |
              0..*
+----------------------------+
|        BookPage            |
+----------------------------+
| - text: String             |
| - number: int              |
| - chapterName: String      |
+----------------------------+
| + getText(): String        |
| + getNumber(): int         |
| + getChapterName(): String |
+----------------------------+

 */
public class CompositionCreator {

    private static final Logger log = LoggerFactory.getLogger(CompositionCreator.class);

    public static void main(String[] args) {
        Book book = new Book("Effective Java", "Bloch, Joshua");

        book.addPage("text of the first page of Creating and destroying objects", 1, "Creating and destroying objects");
        book.addPage("text of the second page of Creating and destroying objects", 2,
                "Creating and destroying objects");
        book.addPage("text of the third page of Methods common to all objects", 3, "Methods common to all objects");

        log.info("Book: {}", book);
    }

    @Data
    @AllArgsConstructor
    static class BookPage {
        private String text;
        private int number;
        private String chapterName;

        @Override
        public String toString() {
            return "Page " + number + ": " + chapterName + " - " + text;
        }
    }

    @Data
    static class Book {
        private String title;
        private String author;
        private List<BookPage> pages;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.pages = new ArrayList<>();
        }

        public void addPage(String text, int number, String chapterName) {
            pages.add(new BookPage(text, number, chapterName));
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(title + " by " + author + ":\n");
            for (BookPage page : pages) {
                sb.append(page.toString()).append("\n");
            }
            return sb.toString();
        }
    }
}
