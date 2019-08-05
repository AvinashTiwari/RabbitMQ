package learn.avinash.rabbitmq.rabbitmqtestconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import learn.avinash.rabbitmq.rabbitmqtestconsumer.entity.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeJsonConsumer {
    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "course.employee")
    public void listen(String Message) throws IOException {
        Employee e = objectMapper.readValue(Message, Employee.class);
       System.out.println(e);
    }
}
