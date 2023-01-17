class Author

class PublishingHouse

open class Book(val name: String, val author: Author, val yearOfIssue: Int, val isbn: String)
{
    var bookGenre : String = ""
    var bookCost : Double = 0.0
    var pageCount : Int = 0
    var currentPage : Int = 0

    constructor(name: String, author: Author, yearOfIssue: Int, isbn: String, bookGenre : String) : this(name, author, yearOfIssue, isbn)
    {
        this.bookGenre = bookGenre
    }

    constructor(name: String, author: Author, yearOfIssue: Int, isbn: String, bookCost : Double) : this(name, author, yearOfIssue, isbn)
    {
        this.bookCost = bookCost
    }

    constructor(name: String, author: Author, yearOfIssue: Int, isbn: String, pageCount : Int) : this(name, author, yearOfIssue, isbn)
    {
        this.pageCount = pageCount
    }

    constructor(name: String, author: Author, yearOfIssue: Int, isbn: String, bookGenre : String, bookCost : Double, pageCount : Int) : this(name, author, yearOfIssue, isbn)
    {
        this.bookGenre = bookGenre
        this.pageCount = pageCount
        this.pageCount = pageCount
    }

    fun read()
    {
        println("The book ${this.name} is being read")
    }

    fun buy()
    {
        println("The book ${this.name} is purchased!")
    }

    fun makeBookmark(currentPage : Int)
    {
        this.currentPage = currentPage
        println("The bookmark for the book ${this.name} is made on the page $currentPage")
    }

    open fun printBook()
    {
        println(this.name + ", " + this.author + ", " + this.yearOfIssue + ", " + this.isbn)
    }
}


class PrintedBook(name: String, author: Author, yearOfIssue: Int, isbn: String, publishingHouse: PublishingHouse) : Book(name, author, yearOfIssue, isbn)
{
    var publishingHouse: PublishingHouse = publishingHouse

    override fun printBook()
    {
        println(this.name + ", " + this.author + ", " + this.yearOfIssue + ", " + this.isbn + ", " + this.publishingHouse)
    }

    fun republishBook()
    {
        println("The book ${this.name} is republished!")
    }
}


open class DigitalBook(name: String, author: Author, yearOfIssue: Int, isbn: String, bookFormatType : String) : Book(name, author, yearOfIssue, isbn)
{
    var bookFormatType : String = ""
    private var bookText : String = ""

    fun textSearch(str : String)
    {
        println("Message: this is a function that looks for a string in the book")
    }

    fun convertToAnotherFormat(bookFormatType : String)
    {
        this.bookFormatType = bookFormatType
    }

    fun delete()
    {
        println("The book ${this.name} is deleted!")
    }

}


fun main() {
    val book1 = Book("One Flew Over the Cuckoo's Nest", Author(), 2018, "978-5-04-105349-9")
    val book2 = Book("The Master and Margarita", Author(), 2020, "978-5-9925-1453-7", "Novel")
    val book3 = PrintedBook("American Gods", Author(), 2019, "978-5-17-147050-0", PublishingHouse())
    val book4 = DigitalBook("Fiesta", Author(), 2016, "5-94643-085-8", "fb2")
    val book5 = DigitalBook("Crime and Punishment", Author(), 2014, "978-1-84022-430-6", "pdf")

    book3.read()
    book2.buy()
    book5.makeBookmark(50)
    book3.republishBook()
    book4.textSearch("Hello")
    book4.delete()
    println()

    val bookArray = listOf(book1, book2, book3, book4, book5)
    for(book in bookArray) {
        book.printBook()
    }
    println()

    
    println("Input book name:")
    var bookName = readln()

    println("Input year of the issue:")
    val year = readln()!!
    var bookYear : Int
    try {
        bookYear = year.toInt()
    }
    catch (e: NumberFormatException)
    {
        bookYear = 2023
    }

    println("Input book ISBN:")
    var bookISBN : String = readln()
    println("Input book genre:")
    var bookGenre : String = readln()

    val book6 = Book(bookName, Author(), bookYear, bookISBN, bookGenre)
    println("You created a book with the following parameters:")
    println("Name: ${book6.name}")
    println("Year: ${book6.yearOfIssue}")
    println("ISBN: ${book6.isbn}")
    println("Genre: ${book6.bookGenre}")
}
