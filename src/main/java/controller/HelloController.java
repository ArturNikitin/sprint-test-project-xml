package controller;

import dao.BookDao;
import dto.BookDto;
import entity.Author;
import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.BookService;
import service.BookServiceInt;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ResponseBody
@RequestMapping("/hello")
public class HelloController {

    public HelloController(BookServiceInt bookService) {
        this.bookService = bookService;
    }

    private BookServiceInt bookService;

    @GetMapping("/{authorId}")
    public List<BookDto> getAllBooksByAuthor(@PathVariable Long authorId) {
        return Stream.of(new BookDto(1L, "book", 2002)).collect(Collectors.toList());
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
         return bookService.getAllBooks().stream().map(x -> new BookDto(x.getId(), x.getTitle(), x.getYear())).collect(Collectors.toList());



        /*Book book = new Book(1L, "Hello", 1593);

        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setYear(book.getYear());
        return Stream.of(bookDto).collect(Collectors.toList());*/
    }
}
