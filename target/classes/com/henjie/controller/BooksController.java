package com.henjie.controller;

import com.henjie.pojo.Books;
import com.henjie.service.BooksService;
import com.henjie.service.BooksServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller //注册为bean，标记并适配为Controller
@RequestMapping("/book")    //提供浏览器请求的接口
public class BooksController {
    //Controller层调service层
    @Autowired  //自动装配，将service层的类通过set自动注入进来
    @Qualifier("BooksServiceImpl")  //service层如果有多个实现类，利用此注解指定具体需要注入进来的service层实现类
    private BooksService booksService;

    //为spring进行set的DL（依赖注入）提供方法
    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }

    //查询全部书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allbook")
    public String list(Model model){
        List<Books> booksList = booksService.queryAllBooks();
        model.addAttribute("msg",booksList);
        return "allBook";
    }

    //新增书籍
    //跳转的新增书籍页面
    @RequestMapping("/toaddbook")
    public String toAddPaper(){
        return "addBook";
    }
    //添加书籍请求
    @RequestMapping("/addbook")
    public String toAddBooks(Books books){
        System.out.println("addBook="+books);
        booksService.addBooks(books);
        return "redirect:/book/allbook";    //重定向给/book/allbook请求
    }

    //更新书籍
    //跳转的修改页面
    @RequestMapping("/toupdatebook")
    public String toUpdatePaper(int id,Model model){
        Books books = booksService.queryBooksByID(id);
        model.addAttribute("Qbook",books);
        return "updateBook";
    }
    //修改请求
    @RequestMapping("/updatebook")
    public String updateBook(Books books){
        System.out.println("updateBooks="+books);
        booksService.updateBooks(books);
        return "redirect:/book/allbook";
    }

    //删除请求 复习Restful
    @RequestMapping("/deletebook/{BID}")
    public String deletebook(@PathVariable("BID") int id){
        booksService.deleteBooksByID(id);
        return "redirect:/book/allbook";
    }

    //搜索书籍
    @RequestMapping("/searchbookname")
    public String searchBookName(String searchBookName,Model model){
        Books bookname = booksService.searchBooks(searchBookName);
        //因为前端以foreach来遍历数组，所以必须以数组形式传入。
        List<Books> booknames = new ArrayList<Books>();
        booknames.add(bookname);
        if(bookname == null){
            model.addAttribute("error","王珏是gay");
            booknames = booksService.queryAllBooks();
        }
        model.addAttribute("msg",booknames);
        return "allBook";
    }
}
