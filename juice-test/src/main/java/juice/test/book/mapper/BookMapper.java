package juice.test.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import juice.test.book.entity.BookEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<BookEntity> {

}
