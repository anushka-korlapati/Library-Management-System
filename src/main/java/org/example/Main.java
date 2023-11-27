    package org.example;
    import java.util.Scanner;
    import java.util.ArrayList;
    import java.util.Date;
    import java.text.SimpleDateFormat;
    class Member{
        private String name;
        private int age;
        private String phone_no;

        private int mem_id;

        public int fine_amt = 0;

        private ArrayList<Book> mem_booksList;

        public Member(){
            //constructor
            mem_booksList = new ArrayList<>();
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setPhoneNo(String phone_no){
            this.phone_no = phone_no;
        }

        public void setMem_id(int mem_id){
            this.mem_id = mem_id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getPhoneNo() {
            return phone_no;
        }

        public int getMem_id() {
            return mem_id;
        }

        public void issueBook(Book book){
            mem_booksList.add(book);
        }

        public void returnBook(Book book){
            mem_booksList.remove(book);
        }

        public ArrayList<Book> getMem_bookslist() {
            return mem_booksList;
        }

        public void inputMemDetails() {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter member name: ");
            setName(scanner.nextLine());

            System.out.print("Enter member age: ");
            setAge(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Enter member phone number: ");
            setPhoneNo(scanner.nextLine());

        }
    }

    class Book{

        private String title;
        private String author;
        private int copies;

        public int duration=0;

        private int book_id;

        public Date issueDate;
        public Date returnDate;

        public int fine_amt = 0;

        public int getFine_amt() {
            return fine_amt;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setCopies(int copies) {
            this.copies = copies;
        }

        public void setBook_id(int book_id) {
            this.book_id = book_id;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor(){
            return author;
        }

        public int getCopies() {
            return copies;
        }

        public int getBook_id() {
            return book_id;
        }

    }

    public class Main {
        public static void main(String[] args)   {

            int m_id=1;
            int b_id=1;
            int MAX_ISSUED_BOOKS = 2;


            ArrayList<Member> membersList = new ArrayList<>();
            ArrayList<Book> booksList = new ArrayList<>();

            System.out.println("Library Portal Initialized");
            System.out.println("---------------------------");
            Scanner User = new Scanner(System.in);

            while (true) {
                System.out.println("1.Enter as a librarian\n2.Enter as a member\n3.Exit");
                System.out.println("---------------------------");
                int choice = User.nextInt();

                if (choice == 1) {
                    // Librarian options
                    while (true) {

                        System.out.println("---------------------------");

                        System.out.println("1.Register a member\n" +
                                "2.Remove a member\n" +
                                "3.Add a book\n" +
                                "4.Remove a book\n" +
                                "5.View all members along with their books and fines to be paid\n" +
                                "6.View all books\n" +
                                "7.Back");

                        System.out.println("---------------------------");
                        int lib_choice = User.nextInt();

                        if (lib_choice == 1) {

                            System.out.println("---------------------------");
                            Member member = new Member();
                            member.inputMemDetails();
                            member.setMem_id(m_id);
                            membersList.add(member);
                            System.out.println("---------------------------");
                            System.out.println("\nMember Successfully Registered with <Member ID=" + member.getMem_id() + ">!");
                            m_id++;


                        } else if (lib_choice == 2) {
                            // Remove a member

                            Scanner scanner = new Scanner(System.in);
                            System.out.println("---------------------------");

                            System.out.println("Enter Member-ID of member to remove:");
                            int delete_m_id = scanner.nextInt();
                            scanner.nextLine();

                            boolean deleted = false;

                            for (int i = 0; i < membersList.size(); i++) {
                                Member member = membersList.get(i);
                                if (member.getMem_id() == delete_m_id) {
                                    membersList.remove(i);
                                    System.out.println("Member deleted successfully!");
                                    deleted = true;
                                    break;
                                }
                            }
                            if (!deleted) {
                                System.out.println("Member does not exist");
                            }
                        } else if (lib_choice == 3) {
                            System.out.println("---------------------------");

                            Scanner scanner = new Scanner(System.in);

                            System.out.print("Enter Book Title: ");
                            String title = scanner.nextLine();

                            System.out.print("Enter Author Name: ");
                            String author = scanner.nextLine();

                            System.out.print("Enter no. of copies: ");
                            int copies = scanner.nextInt();
                            scanner.nextLine();

                            for (int i = 0; i < copies; i++) {

                                Book book = new Book();
                                book.setTitle(title);
                                book.setAuthor(author);
                                book.setCopies(1);
                                book.setBook_id(b_id);
                                booksList.add(book);
                                b_id++;
                            }

                            System.out.println("Book(s) Added Successfully!");

                        } else if (lib_choice == 4) {


                            Scanner scanner = new Scanner(System.in);

                            System.out.println("Enter Book-ID of book to remove: ");
                            int delete_b_id = scanner.nextInt();
                            scanner.nextLine();

                            boolean bookFound = false;

                            for (int i = 0; i < booksList.size(); i++) {
                                Book book = booksList.get(i);
                                if (book.getBook_id() == delete_b_id) {
                                    booksList.remove(i);
                                    System.out.println("Book deleted successfully!");
                                    bookFound = true;
                                    break;
                                }
                            }

                            if (!bookFound) {
                                System.out.println("Book does not exist");
                            }

                        } else if (lib_choice == 5) {


                            for (Member i : membersList) {

                                System.out.println("---------------------------");

                                System.out.println("Member ID: "+i.getMem_id());
                                System.out.println("Member name: "+i.getName());
                                System.out.println("Member age: "+i.getAge());
                                System.out.println("Member phone no: "+i.getPhoneNo());
                                System.out.println("Member fines: "+i.fine_amt);

                                System.out.println("---------------------------");
                            }
                        } else if (lib_choice == 6) {
                            // View all books

                            for (Book i : booksList) {

                                System.out.println("---------------------------");

                                System.out.println("Book ID: "+ i.getBook_id());
                                System.out.println("Book Title: "+ i.getTitle());
                                System.out.println("Book Author: "+ i.getAuthor());

                                System.out.println("---------------------------");
                            }

                        } else if (lib_choice == 7) {
                            break;
                        } else {
                            System.out.println("Invalid choice");
                        }
                    }
                } else if (choice == 2) {

                    int totalFines = 0;

                    Book selected_book = null;

                    //Member options
                    boolean memberOptions = true;
                    Member selected_member = null;

                    Scanner scanner = new Scanner(System.in);

                    System.out.println("Enter Member Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Member Phone no: ");
                    String phone_no = scanner.nextLine();

                    boolean member_exists = false;

                    for(int i=0; i< membersList.size();i++){

                        Member member = membersList.get(i);
                        if(member.getName().equals(name) && member.getPhoneNo().equals(phone_no)){
                            selected_member = member;
                            member_exists = true;
                            System.out.println("Welcome "+selected_member.getName());
                            System.out.println("Member ID: "+selected_member.getMem_id());

                        }
                    }

                    if(!member_exists){
                        System.out.println("Member does not exist");
                    }

                    if(selected_member!= null) {

                        while (memberOptions) {

                            System.out.println("1.List Available Books\n" +
                                    "2.List My Books\n" +
                                    "3.Issue book\n" +
                                    "4.Return book\n" +
                                    "5.Pay Fine\n" +
                                    "6.Back\n"
                            );

                            Scanner mem_options = new Scanner(System.in);
                            int mem_choice = mem_options.nextInt();
                            mem_options.nextLine();

                            if (mem_choice == 1) {

                                for (Book i : booksList) {

                                    System.out.println("---------------------------");

                                    System.out.println("Book ID: " + i.getBook_id());
                                    System.out.println("Book Title: " + i.getTitle());
                                    System.out.println("Book Author: " + i.getAuthor());

                                    System.out.println("---------------------------");
                                }


                            } else if (mem_choice == 2) {

                                if (selected_member.getMem_bookslist().isEmpty()) {
                                    System.out.println("No books issued by this member.");
                                } else {
                                    System.out.println("Books issued by " + selected_member.getName() + ":");
                                    for (Book book : selected_member.getMem_bookslist()) {
                                        System.out.println("Book ID: " + book.getBook_id());
                                        System.out.println("Title: " + book.getTitle());
                                        System.out.println("Author: " + book.getAuthor());
                                        System.out.println("---------------------------");
                                    }
                                }


                            } else if (mem_choice == 3) {



                                if (selected_member.getMem_bookslist().size() >= MAX_ISSUED_BOOKS) {
                                    System.out.println("You have already issued the maximum allowed number of books (" + MAX_ISSUED_BOOKS + ").");
                                } else {

                                    Scanner scanner1 = new Scanner(System.in);
                                    System.out.println("Enter Book-ID of book being issued: ");
                                    int book_id = scanner1.nextInt();
                                    scanner1.nextLine();

                                    System.out.println("Enter Book Title of book being issued: ");
                                    String book_title = scanner1.nextLine();

                                    boolean bookIssued = false;

                                    for (int i = 0; i < booksList.size(); i++) {

                                        Book book = booksList.get(i);
                                        if (book.getBook_id() == book_id && book.getTitle().equals(book_title)) {
                                            selected_book = book;

                                            if (selected_member.getMem_bookslist().contains(selected_book)) {

                                                bookIssued = true;
                                                break;

                                            } else {

                                                selected_member.issueBook(selected_book);
                                                selected_book.issueDate = new Date();
                                                System.out.println("Book issued successfully!");


                                                booksList.remove(i);

                                                bookIssued = true;
                                                break;
                                            }

                                        }
                                    }

                                    if (!bookIssued) {
                                        System.out.println("Book not available");
                                    }
                                }

                            } else if (mem_choice == 4) {


                                Scanner scanner1 = new Scanner(System.in);
                                System.out.println("Enter Book-ID of book being returned: ");
                                int book_id = scanner1.nextInt();
                                scanner1.nextLine();

                                boolean book_d = false;


                                for (int i = 0; i < selected_member.getMem_bookslist().size(); i++) {
                                    Book book = selected_member.getMem_bookslist().get(i);
                                    if (book.getBook_id() == book_id) {
                                        selected_book = book;
                                        selected_member.returnBook(selected_book);
                                        selected_book.returnDate = new Date();
                                        System.out.println("Book successfully returned!");
                                        book_d = true;


                                        booksList.add(selected_book);


                                        long elapsedTime = selected_book.returnDate.getTime() - selected_book.issueDate.getTime();
                                        long seconds = elapsedTime / 1000;
                                        selected_book.duration = (int) seconds;
                                        System.out.println("Book was borrowed for: " + selected_book.duration + " days");

                                        if (selected_book.duration > 10) {
                                            selected_book.fine_amt = (selected_book.duration - 10) * 3;
                                            System.out.println("Fine for this book: Rs " + selected_book.fine_amt);
                                        } else {
                                            selected_book.fine_amt = 0;
                                        }

                                        totalFines += selected_book.fine_amt;

                                        break;
                                    }
                                }

                                selected_member.fine_amt = totalFines;
                                //System.out.println("Total Fines for Member: Rs " + totalFines);

                            } else if (mem_choice == 5) {

                                System.out.println("Fines to be paid: Rs " + totalFines);
                                selected_member.fine_amt = totalFines;

                                if(totalFines>0) {
                                    Scanner scan = new Scanner(System.in);
                                    System.out.println("Do you want to pay your fines: (yes/no)");
                                    String pay = scan.nextLine();
                                    if (pay.equals("yes")) {

                                        System.out.println("Your fines have been cleared");
                                        selected_member.fine_amt = 0;
                                        totalFines = 0;

                                    } else {

                                        System.out.println("Pending fines: " + selected_member.fine_amt);
                                    }
                                }else{
                                    System.out.println("You have no fines");
                                }

                            } else if (mem_choice == 6) {
                                //back
                                memberOptions = false;
                            } else {
                                System.out.println("Invalid choice");
                            }

                        }

                    }

                } else if (choice == 3) {

                    System.out.println("Thanks For Visiting!");
                    break;

                } else {
                    System.out.println("Invalid choice");
                }
            }
        }
    }