/*
package link_tracker.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperUtil {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean("mergerMapper")
    public ModelMapper mergerMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setPropertyCondition(Conditions.isNotNull());
        return mapper;
    }

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return  objectMapper;
    }
}
*/
