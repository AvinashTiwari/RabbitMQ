package learn.avinash.rabbitmq.rabbitmqtestconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import learn.avinash.rabbitmq.rabbitmqtestconsumer.entity.Picture;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PictureVectorConsumer {
    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.picture.vector")
    public void listern(String message) throws IOException {
        Picture p = objectMapper.readValue(message, Picture.class);
        System.out.println("Message from vector " + p);

    }
}
