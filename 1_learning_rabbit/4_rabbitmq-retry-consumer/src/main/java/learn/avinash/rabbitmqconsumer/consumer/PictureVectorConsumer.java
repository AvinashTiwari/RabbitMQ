package learn.avinash.rabbitmqconsumer.consumer;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import learn.avinash.rabbitmqconsumer.entity.Picture;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PictureVectorConsumer {

	private ObjectMapper objectMapper = new ObjectMapper();

	@RabbitListener(queues = "q.picture.vector")
	public void listen(String message)
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		var p = objectMapper.readValue(message, Picture.class);
		// process the picture
		System.out.println("Convert to image, creating thumbnail, & publishing : " + p);
	}

}
