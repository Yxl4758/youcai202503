package Collection_Test.BookManager;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class Book{
    private String bookName;
    private Author author;
    private double price;

    public Book(){}

    public Book(String bookName, Author author, double price) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    /**
     * 获取
     * @return bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 设置
     * @param bookName
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * 获取
     * @return author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名：" + bookName +", 作者：" + author.getName() + ", 售价：" + price;
    }

    // - 删除一本图书(通过书名删除)
    public static void deletByBookName(List<Book> list, String bookName) {
        ListIterator<Book> listIterator = list.listIterator();
        while(listIterator.hasNext()){
            Book book = listIterator.next();
            if(book.getBookName().equals(bookName)){
                listIterator.remove();
            }else {
                System.out.println("不存在该书籍");
            }
        }
        ListIterator<Book> listIterator1 = list.listIterator();
        while(listIterator1.hasNext()){
            Book book = listIterator1.next();
            System.out.println(book.toString());
        }
    }
    // - 删除所有的指定作者的书(通过作者姓名删除)
    public static void deleteByAuthor(List<Book> list, String authorName) {
        ListIterator<Book> listIterator = list.listIterator();
        while(listIterator.hasNext()){
            Book book = listIterator.next();
            if(book.getAuthor().getName().equals(authorName)){
                listIterator.remove();
            }else {
                System.out.println("不存在该作者");
            }
        }
        ListIterator<Book> listIterator1 = list.listIterator();
        while(listIterator1.hasNext()){
            Book book = listIterator1.next();
            System.out.println(book.toString());
        }
    }
    //  将所有的图书按照图书售价降序排序。若售价相同，按照作者年龄升序
    public static void sortBook(List<Book> books) {
        if (books.size() <= 1) {
            for (Book book : books) {
                System.out.println(book.toString());
            }
        } else {
            Collections.sort(books, new Comparator<Book>() {

                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getPrice() == o2.getPrice() ? (o1.getAuthor().getAge() - o2.getAuthor().getAge()) : ((int) (o2.getPrice() - o1.getPrice()));
                }
            });
        }
    }
}
