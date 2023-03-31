package juice.test.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import juice.test.book.entity.BookEntity;
import juice.test.book.mapper.BookMapper;
import juice.test.book.service.IBookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookEntity> implements IBookService {
}
