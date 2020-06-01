package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.javainuse.msg.MyMessageSender;

@SpringBootApplication
public class Application {
//	@Autowired
//	MyMessageSender myMessageSender;
//	
//	@Autowired
//	MyMessageReceiver myMessageReceiver;
	
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

//		JmsTemplate jms = ctx.getBean(JmsTemplate.class);
//		jms.convertAndSend("javainuse", "test message");
		
		
		String queueName = "Demo.queue";
		MyMessageSender myMessageSender = ctx.getBean(MyMessageSender.class);
		myMessageSender.sendMessage(queueName, "test message");

//		MyMessageReceiver myMessageReceiver = ctx.getBean(MyMessageReceiver.class);
//		myMessageReceiver.receiveMessage(queueName);
		
		
		
	}
}