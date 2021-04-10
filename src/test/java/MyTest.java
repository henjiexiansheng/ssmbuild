import com.henjie.pojo.Books;
import com.henjie.service.BooksService;
import com.henjie.service.BooksServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Auther: henjie
 * @Date: 2021/4/4 - 04 - 04 - 13:34
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksService booksServiceImpl = context.getBean("BooksServiceImpl", BooksService.class);
        List<Books> books = booksServiceImpl.queryAllBooks();
        for (Books book : books) {
            System.out.println(book);
        }
    }
}
