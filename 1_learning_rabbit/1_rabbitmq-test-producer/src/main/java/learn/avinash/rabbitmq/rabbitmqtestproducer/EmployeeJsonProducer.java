package learn.avinash.rabbitmq.rabbitmqtestproducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import learn.avinash.rabbitmq.rabbitmqtestproducer.enitity.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();
    public void sendMessage(Employee employee) throws JsonProcessingException {
        String json  = objectMapper.writeValueAsString(employee);
        rabbitTemplate.convertAndSend("course.employee",json);


    }


}
