package com.example.demo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="EmailTable")
public class EmailClass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "user_id1")
	public UserClass sender;
//	private String sender;
	
	@ManyToOne
    @JoinColumn(name = "user_id2")
    private UserClass receiver;
//	private String receiver;
	private String subject;
	private String body;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserClass getSender() {
		return sender;
	}
	public void setSender(UserClass sender) {
		this.sender = sender;
	}
	public UserClass getReceiver() {
		return receiver;
	}
	public void setReceiver(UserClass receiver) {
		this.receiver = receiver;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
