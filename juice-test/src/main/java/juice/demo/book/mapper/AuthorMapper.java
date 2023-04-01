package juice.demo.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import juice.demo.book.entity.AuthorEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorMapper extends BaseMapper<AuthorEntity> {

}
