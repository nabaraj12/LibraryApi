
package com.example.Books;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class BooksController {

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    GenreRepository genreRepository;



    @RequestMapping(value = "/genres",method = RequestMethod.GET)
    public List<Genre> getAllGenres()
    {
        return genreRepository.findAll();
    }

    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public List<Book> getAllBooks()
    {
        return booksRepository.findAll();
    }


    @RequestMapping(value = "/book/{genre}",method = RequestMethod.GET)
    public List<Book> getBookByGenre(@PathVariable String genre)
    {
        return booksRepository.findByGenre(genre);
    }

    //For Adding new books to the library
    @RequestMapping(value = "/books",method = RequestMethod.POST)
    public void postBooks(@RequestBody Book book)
    {
        booksRepository.save(book);
    }


    //Updating Books in the library
    @RequestMapping(value = "/books/{id}",method = RequestMethod.PUT)
    public void updateBook(@PathVariable int id,@RequestBody Book newBookRecord)
    {
        Book existingRecord=booksRepository.getReferenceById(id);
        if(!Objects.equals(existingRecord.getAuthor(), newBookRecord.getAuthor()))
        {
            existingRecord.setAuthor(newBookRecord.getAuthor());
        }
        if(!Objects.equals(existingRecord.getPublisher(), newBookRecord.getPublisher()))
        {
            existingRecord.setPublisher(newBookRecord.getPublisher());
        }
        if(!Objects.equals(existingRecord.getGenre(), newBookRecord.getGenre()))
        {
            existingRecord.setGenre(newBookRecord.getGenre());
        }
        if(!Objects.equals(existingRecord.getName(), newBookRecord.getName()))
        {
            existingRecord.setName(newBookRecord.getName());
        }
        booksRepository.save(existingRecord);
    }


}
