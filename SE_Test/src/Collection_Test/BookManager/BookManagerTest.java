package Collection_Test.BookManager;

import Regular_Test._02Test.Person;

import java.util.*;

public class BookManagerTest {
    static Author author1 = new Author("余华",34,'男');
    static Author author2 = new Author("吴承恩",34,'男');
    static Author author3 = new Author("司马迁",34,'男');
    static Book book1 = new Book("活着",author1,78);
    static Book book2 = new Book("西游记",author2,68);
    static Book book3 = new Book("史记",author3,89);
    public static List<Book> books = Arrays.asList(book1,book2,book3);
    public static List<Author> authors = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("--------图书管理器---------");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1、添加图书 2、添加作者 3、删除图书、4、图书排序 0、退出");
            System.out.print("请输入操作：");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addBook();
                    System.out.println("-----------------------------------");
                    break;
                case 2:
                    addAuthor();
                    System.out.println("-----------------------------------");
                    break;
                case 3:
                    deletBook();
                    System.out.println("-----------------------------------");
                    break;
                case 4:
                    Book.sortBook(books);
                    for (Book book : books) {
                        System.out.println(book.toString());
                    }
                    System.out.println("-----------------------------------");
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private static void deletBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1、书名删除 2、作者名删除");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                ListIterator<Book> iterator = books.listIterator();
                while (iterator.hasNext()) {
                    Book book = iterator.next();
                    System.out.println(book.toString());
                }
                System.out.print("请输入书名：");
                String bookName = sc.next();
                Book.deletByBookName(books, bookName);
                if(books.isEmpty()){
                    break;
                }
                while (iterator.hasNext()) {
                    Book book = iterator.next();
                    System.out.println(book);
                }
                break;
            case 2:
                ListIterator<Book> iterator1 = books.listIterator();
                while (iterator1.hasNext()) {
                    Book book = iterator1.next();
                    System.out.println(book.toString());
                }
                System.out.print("请输入作者名：");
                String authorName = sc.next();
                Book.deleteByAuthor(books, authorName);
                if(books.isEmpty()){
                    break;
                }
                while (iterator1.hasNext()) {
                    Book book = iterator1.next();
                    System.out.println(book);
                }
                break;
            default:
                break;
        }
    }

    private static void addAuthor() {
        boolean flag = false;
        while (!flag) {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入作者姓名：");
            String authorName = sc.next();
            System.out.print("请输入作者年龄：");
            int authorAge = sc.nextInt();
            System.out.print("请输入作者性别：");
            char authorGender = sc.next().charAt(0);
            Author author = new Author(authorName, authorAge, authorGender);
            try {
                if (authors.contains(author)) {
                    throw new RuntimeException("已存在该作者，请重新输入！");
                }
            } catch (Exception e) {

            }

            if (!authors.contains(author)) {
                authors.add(author);
                break;
            }
        }
    }

    private static void addBook() {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入书名：");
        String bookName = sc.next();
        try {
            if (authors.isEmpty()) {
                throw new RuntimeException("请先添加作者信息！！！");
            }
        } catch (Exception e) {
            addAuthor();
        }
        ListIterator<Author> iterator = authors.listIterator();
        int index = 1;
        while (iterator.hasNext()) {
            Author author = iterator.next();
            System.out.print(index + "、" + author.getName() + "\t");
            index++;
        }
        System.out.println();
        System.out.print("请选择作者：");
        int choice = sc.nextInt();
        Author author = authors.get(choice - 1);
        System.out.print("请输入售价：");
        double price = sc.nextDouble();
        Book book = new Book(bookName, author, price);
        ListIterator<Book> iterator1 = books.listIterator();
        if(books.isEmpty()){
            books.add(book);
        }else {
            while (iterator1.hasNext()) {
                Book book1 = iterator1.next();
                if (book.getBookName().equals(book1.getBookName())) {
                    System.out.println("已存在该书籍");
                } else {
                    iterator1.add(book);
                }
            }
        }
    }
}
