package Codetest.Controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import Codetest.Model.BookBean;
import Codetest.Repository.BookRepository;





@Controller


public class BookController {
	

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	
	@GetMapping("/add")
	public ModelAndView InsertBook() {
		
		return new ModelAndView("add_book","book",new BookBean());
	}
	
	@GetMapping("/getall")
	public String displayBooks(ModelMap map) {
		bookRepository = new BookRepository();
		List<BookBean> books = bookRepository.getAll();
		map.addAttribute("books" , books);
		return "showbook";
	}
	
	@PostMapping("/add")
	public String addBook(@ModelAttribute("book") BookBean book, BindingResult bResult, ModelMap map) throws Exception {
		if(bResult.hasErrors()) {
			
			map.addAttribute("book",book);
			
			List<BookBean> books = bookRepository.getAll();
			
			map.addAttribute("books",books);
			return "add_book";
		}
		
		int rs = bookRepository.insertBook(book);
		if(rs == 0) {
			map.addAttribute("book",book);
			return "add_book";
		}else {
			return "redirect:/getbookall";
		}
		

	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView showEdit(@PathVariable int id){
		BookBean book = bookRepository.getById(id);
		
		return new ModelAndView("edit_book","book",book);
	}
	
	@PostMapping("/edit")
	public String editBook(@ModelAttribute("book") BookBean book, BindingResult bresult, ModelMap map) {
	    if (bresult.hasErrors()) {
	        return "edit_book";
	    }

	    int rs = bookRepository.editBook(book);
	    if (rs == 0) {
	        map.addAttribute("error", "Book Edit Error");
	        return "edit_book";
	    } else {
	        return "redirect:/getbookall";
	    }
	}

	
	@GetMapping("/getbookall")
	public String displayBookALL(ModelMap map) {
		bookRepository = new BookRepository();
		List<BookBean> books = bookRepository.getBookAll();
		map.addAttribute("books" , books);
		return "showbook";
	}
	
	@GetMapping("/delete/{id}")
	public String softdeleteBook(@PathVariable int id) {
		bookRepository.softdeleteBook(id);
		return "redirect:/getbookall";
	}
	
	@GetMapping("/restore/{id}")
	public String restoreBook(@PathVariable int id) {
	    bookRepository.restoreBook(id); // Call the repository method to restore the book
	    return "redirect:/getbookall";  // Redirect to the book list page after restoring
	}

	@GetMapping("/restore")
	public String toRestore(ModelMap map) {
	    List<BookBean> deletedBooks = bookRepository.getDeletedBooks();
	    map.addAttribute("rebooks", deletedBooks); // 'rebooks' to match the JSP variable
	    return "restore";
	}

	
	
}
