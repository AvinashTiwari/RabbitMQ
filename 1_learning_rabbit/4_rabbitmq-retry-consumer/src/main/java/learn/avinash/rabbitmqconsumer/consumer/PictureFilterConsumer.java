package learn.avinash.rabbitmqconsumer.consumer;

import java.io.IOException;

import learn.avinash.rabbitmqconsumer.entity.Picture;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PictureFilterConsumer {

	private ObjectMapper objectMapper = new ObjectMapper();

	@RabbitListener(queues = "q.picture.filter")
	public void listen(String message)
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		var p = objectMapper.readValue(message, Picture.class);
		// process the image
		System.out.println("Applying image filter : " + p);
	}

}
