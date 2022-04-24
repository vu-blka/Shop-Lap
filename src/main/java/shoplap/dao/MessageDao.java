package shoplap.dao;

import java.util.List;

import shoplap.entity.Message;

public interface MessageDao {
	boolean insert(Message message);
	List<Message> getAll();
	List<Message> getUnSeen();
	List<Message> getSeen();
	Message get(String id);
	boolean update(String id);
}
