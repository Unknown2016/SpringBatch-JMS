package com.javainuse.msg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.jms.BytesMessage;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyMessageReceiver {

	@Autowired
	private ConnectionFactory connectionFactory;
	private JmsTemplate jmsTemplate;

	@PostConstruct
	public void init() {
		this.jmsTemplate = new JmsTemplate(connectionFactory);
	}

	public void receiveMessage(String queueName) {
		Message message = jmsTemplate.receive(queueName);
//		TextMessage textMessage = (TextMessage) message;
//		try {
//			String text = textMessage.getText();
//			System.out.println("received: " + text);
//		} catch (JMSException e) {
//			e.printStackTrace();
//		}
		
//		MapMessage map = (MapMessage)message;
		
		try {
			BytesMessage bytesMessage = (BytesMessage) message;
		      byte[] data = new byte[(int) bytesMessage.getBodyLength()];
		      bytesMessage.readBytes(data);
		      
		      String fileName = bytesMessage.getStringProperty("fileName");
//		      String str = new String(data);
		      File file = new File("f:\\ans"+fileName);
		      if(!file.exists()) {
		    	  try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		      try {
				FileOutputStream fos= new FileOutputStream(file);
				  
				fos.write(data);
				
				
				
				
				  fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      System.out.println("received:"+fileName);
//		      System.out.println(str);
		      
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		


		
		
		
		
		
		
	}
}
