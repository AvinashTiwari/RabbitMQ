package learn.avinash.rabbitmq.rabbitmqtestconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import learn.avinash.rabbitmq.rabbitmqtestconsumer.entity.Picture;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class MyPictureImageConsumer2 {
    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.mypicture.image")
    public void listern(Message message, Channel channel) throws IOException {
        Picture p = objectMapper.readValue(message.getBody(), Picture.class);
        if(p.getSize() > 9000){
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
          //  throw new AmqpRejectAndDontRequeueException("Picture size is too large " + p.getSize());
        }else {

            System.out.println("Message " + p);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        }

    }
}
