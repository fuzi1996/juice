package juice.test.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import juice.test.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
		List<User> findUser();
}
