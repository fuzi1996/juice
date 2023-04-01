package juice.demo.juice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import juice.demo.juice.entity.Graphql;
import juice.demo.juice.mapper.GraphqlMapper;
import juice.demo.juice.service.GraphqlService;
import org.springframework.stereotype.Service;

@Service
public class GraphqlServiceImpl extends ServiceImpl<GraphqlMapper, Graphql> implements GraphqlService {
}
