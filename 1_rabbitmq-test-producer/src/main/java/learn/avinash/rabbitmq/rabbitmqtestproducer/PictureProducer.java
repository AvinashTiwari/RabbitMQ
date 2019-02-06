package learn.avinash.rabbitmq.rabbitmqtestproducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import learn.avinash.rabbitmq.rabbitmqtestproducer.enitity.Picture;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ObjectMapper objectmapper = new ObjectMapper();

    public void send(Picture p) throws JsonProcessingException {
        String json = objectmapper.writeValueAsString(p);
        rabbitTemplate.convertAndSend("x.picture", p.getType(),json);

    }
}
