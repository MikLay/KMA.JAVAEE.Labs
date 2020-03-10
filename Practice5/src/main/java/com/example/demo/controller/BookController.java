package com.example.demo.controller;

import com.example.demo.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    private List<Book> books = new ArrayList<>();


    @RequestMapping(value = "/books-list", method = RequestMethod.GET)
    public String bookControllerGetAll(Model model) {
        model.addAttribute("books", books);
        return "index";
    }


    @RequestMapping(value = "/book-add", method = RequestMethod.GET)
    public String bookFormControllerGet(Model model) {
        model.addAttribute("bookModel", new Book());
        return "book-add";
    }

    @RequestMapping(value = "/book-add", method = RequestMethod.POST)
    public String bookFormControllerPost(@ModelAttribute Book bookModel, Model model) {
        model.addAttribute("bookModel", bookModel);
        books.add(new Book(bookModel.getName(), bookModel.getIsbn(), bookModel.getAuthor()));
        return "redirect:/books-list";
    }

}
