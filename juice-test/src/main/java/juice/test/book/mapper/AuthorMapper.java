package juice.test.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import juice.test.book.entity.AuthorEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorMapper extends BaseMapper<AuthorEntity> {

}
