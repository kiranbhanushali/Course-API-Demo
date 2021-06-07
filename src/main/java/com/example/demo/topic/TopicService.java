package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository tr;
	List<Topic> ls = new ArrayList<>(Arrays.asList(new Topic("101", "spring", "course about spring"),
			new Topic("102", "c++", "course about c++"), new Topic("103", "jaba", "course about java")));

	public List<Topic> getAllTopics() {
//		return ls;
		List<Topic> ls = new ArrayList<>();
		tr.findAll().forEach(ls::add);
		return ls;
	}

	public Topic getTopic(String id) {
//		return ls.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return tr.findById(id).get();
	}

	public void addTopic(Topic topic) {
//		ls.add(topic);
		tr.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		tr.save(topic);
	}

	public void deleteTopic(String id) {
		tr.deleteById(id);
	}
}
