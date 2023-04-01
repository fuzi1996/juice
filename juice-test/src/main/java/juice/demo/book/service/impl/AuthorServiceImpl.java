package juice.demo.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import juice.demo.book.entity.AuthorEntity;
import juice.demo.book.mapper.AuthorMapper;
import juice.demo.book.service.IAuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, AuthorEntity> implements IAuthorService {
}
