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

    public void sendMessage(Picture p) throws JsonProcessingException {
        StringBuilder sb = new StringBuilder();
        // 1st word is “mobile” or “web”, which is picture source
        sb.append(p.getSource());
        sb.append('.');

        // 2nd word is “large” or “small”, which is based on picture size. Picture with
        // size more than 4000 are considered “large”
        if (p.getSize() > 4000) {
            sb.append("large");
        } else {
            sb.append("small");
        }
        sb.append('.');

        // 3rd word is picture type (jpg, png, or svg)
        sb.append(p.getType());

        String routingKey = sb.toString();
        String json = objectmapper.writeValueAsString(p);
        rabbitTemplate.convertAndSend("x.picture2", routingKey, json);
    }

}
