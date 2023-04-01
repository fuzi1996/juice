package juice.demo.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import juice.demo.book.entity.BookEntity;
import juice.demo.book.mapper.BookMapper;
import juice.demo.book.service.IBookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookEntity> implements IBookService {
}
