package learn.avinash.rabbitmq.rabbitmqtestconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FixedRateConsumer {

    @RabbitListener(queues = "course.fixedrate")
    public void listen(String message){
        System.out.println("Consuming  : " + message);
    }
}
