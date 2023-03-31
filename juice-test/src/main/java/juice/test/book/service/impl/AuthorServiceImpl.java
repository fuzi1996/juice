package juice.test.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import juice.test.book.entity.AuthorEntity;
import juice.test.book.mapper.AuthorMapper;
import juice.test.book.service.IAuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, AuthorEntity> implements IAuthorService {
}
