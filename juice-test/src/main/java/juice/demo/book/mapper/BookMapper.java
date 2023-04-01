package juice.demo.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import juice.demo.book.entity.BookEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<BookEntity> {

}
