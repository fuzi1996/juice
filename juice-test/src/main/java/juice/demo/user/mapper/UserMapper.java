package juice.demo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import juice.demo.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
		List<User> findUser();
}
