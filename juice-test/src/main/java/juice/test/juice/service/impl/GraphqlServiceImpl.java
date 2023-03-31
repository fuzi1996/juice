package juice.test.juice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import juice.test.juice.entity.Graphql;
import juice.test.juice.mapper.GraphqlMapper;
import juice.test.juice.service.GraphqlService;
import org.springframework.stereotype.Service;

@Service
public class GraphqlServiceImpl extends ServiceImpl<GraphqlMapper, Graphql> implements GraphqlService {
}
