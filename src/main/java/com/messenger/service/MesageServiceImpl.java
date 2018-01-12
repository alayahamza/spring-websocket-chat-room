package com.messenger.service;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.messenger.model.Message;
import com.messenger.repository.MessageRepository;

@Service
public class MesageServiceImpl implements MessageService {

	@Autowired
	MessageRepository messageRepository;

	@Override
	public Message save(Message message) {
		return messageRepository.save(message);
	}

	@Override
	public void delete(int id) {
		Message messageToDelete = messageRepository.findById(id);
		if (messageToDelete != null) {
			messageRepository.delete(messageToDelete);
		}
	}

	@Override
	public Message findMessageById(int id) {
		return messageRepository.findById(id);
	}

	@Override
	public List<Message> findAll() {
		List<Message> list  = messageRepository.findAll();
		 list.stream().forEach(msg -> { 
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			msg.setDate(formatter.format(new Date() ));
		});
		 return list;
		 
	}

}
