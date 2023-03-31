package juice.test.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import juice.test.user.entity.User;
import juice.test.user.mapper.UserMapper;
import juice.test.user.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
