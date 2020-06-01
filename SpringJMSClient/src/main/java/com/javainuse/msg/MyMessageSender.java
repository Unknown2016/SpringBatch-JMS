//package com.javainuse.msg;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import javax.annotation.PostConstruct;
//import javax.jms.BytesMessage;
//import javax.jms.ConnectionFactory;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.core.MessageCreator;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyMessageSender {
//
//	@Autowired
//	private ConnectionFactory connectionFactory;
//	private JmsTemplate jmsTemplate;
//
//	@PostConstruct
//	public void init() {
//		this.jmsTemplate = new JmsTemplate(connectionFactory);
//	}
//
//	public void sendMessage(String queueName, String message) {
//
//		System.out.println("sending: " + message);
//		jmsTemplate.send(queueName, new MessageCreator() {
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//
//				File file = new File("F:\\vb.txt");
//				BytesMessage bytesMessage = session.createBytesMessage();
//				
////				TextMessage bmsg;
//				try {
//					byte byt[] = new byte[(int)file.length()];
//					FileInputStream fis = new FileInputStream(file);
//					
//					fis.read(byt);
//					 
//					bytesMessage.setStringProperty("fileName",file.getName());
//					bytesMessage.writeBytes(byt);
//					
////					bmsg = session.createTextMessage("vijay");
//
//					// Employee emp = new Employee("1", "Vijay", "Bakare", "pune", "8446550810");
//					// byte[] by = emp.toString().getBytes();
//					//
//					//
//					//
//					// BytesMessage sd = session.createBytesMessage();
//					// sd.writeBytes(by);
//					fis.close();
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return bytesMessage;
//				// return session.createTextMessage(message);
//			}
//		});
//	}
//}
