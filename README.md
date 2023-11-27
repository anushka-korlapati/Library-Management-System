<h1>Library Management System</h1>

<h4><p>This program implements a simple Library Management System with two user roles: <br>Librarian and Member.<br> 
</h4></p>

<h2>Features</h2>

<b>Librarian :</b>

1. Register members with their details (name, age, phone number).<br>
2. Remove members by Member ID.<br>
3. Add books to the library with title, author, and copies.<br>
4. Remove books from the library by Book ID.<br>
5. View a list of all members along with their information and fines.<br>
6. View a list of all available books.<br>

<b>Member :</b>

1. Members can log in with their name and phone number.
2. List available books in the library.
3. List books issued by the member.
4. Issue books (up to a maximum limit).
5. Return books, calculate fines if overdue, and pay fines.
6. View and clear fines.</p>

<h2>Usage</h2>

1. Run the program.
2. Choose to enter as a Librarian or Member.

<b>As a Librarian:</b><br>

1. Register members with their details.
2. Remove members by Member ID.
3. Add books to the library.
4. Remove books from the library.
5. View member information and available books.

<b>As a Member:</b>
1. Log in with your name and phone number.
2. List available books.
3. List your issued books. 
4. Issue books (up to the maximum limit).
5. Return books, calculate fines if overdue, and pay fines.
6. View and clear fines.

<h2>Classes:</h2>
<b>Member Class:</b>

- Represents a library member with attributes like name, age, phone number, and issued books.
- Key Attributes:
  - name: Member's name.
  - age: Member's age.
  - phone_no: Member's phone number.
  - mem_id: Member's unique ID.
  - fine_amt: Total fines for the member.
  - mem_booksList: ArrayList to store books issued by the member.
- Methods: 
  - inputMemDetails(): Takes input for member details.
  - issueBook(): Adds a book to the member's issued books list.
  - returnBook(): Removes a book from the member's issued books list.
  - Getter and setter methods for attributes.

<b>Book Class:</b>

- Represents a book in the library with attributes like title, author, number of copies, book ID, issue date, return date, and fine amount.
- Key Attributes:
  - title: Book's title.
  - author: Book's author.
  - copies: Number of available copies.
  - book_id: Book's unique ID.
  - duration: Duration (in seconds) the book was borrowed.
  - fine_amt: Fine amount for the book.
  - issueDate and returnDate: Dates when the book was issued and returned.
- Methods:
  - Getter and setter methods for attributes.

<b>Main Class:</b>

- The main program handling user interactions.
- Main Method: Entry point for user interactions.

<b>Main Class Methods:</b>
<br>
<br>Librarian Options :

- Actions for librarians: Register members, remove members, add books, remove books, view lists.

Member Options (Inside Main Method):

- Actions for members: List available books, list issued books, issue/return books, pay fines.


<h2>Additional Details</h2>

Please ensure that you enter the output as Integer or String based on the prompt accordingly as it could generate an error. 