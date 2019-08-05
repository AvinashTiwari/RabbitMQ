package learn.avinash.rabbitmq.rabbitmqtestconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import learn.avinash.rabbitmq.rabbitmqtestconsumer.entity.Picture;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MyPictureImageConsumer {
    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.mypicture.image1")
    public void listern(String message) throws IOException {
        Picture p = objectMapper.readValue(message, Picture.class);
        if(p.getSize() > 9000){
            throw new AmqpRejectAndDontRequeueException("Picture size is too large " + p.getSize());
        }else {

            System.out.println("Message " + p);
        }

    }
}
