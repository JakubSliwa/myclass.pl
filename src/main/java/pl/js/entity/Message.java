package pl.js.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import pl.js.entity.users.Student;
import pl.js.entity.users.Tutor;

@Entity
@Table(name = "messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 1, max = 500)
	private String text;
	private LocalDateTime sent;
	private String readed;

	@ManyToOne
	private Student sendToStudent;

	@OneToOne
	private Student sendByStudent;

	@ManyToOne
	private Tutor sendToTutor;

	@OneToOne
	private Tutor sendByTutor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getReaded() {
		return readed;
	}

	public void setReaded(String readed) {
		this.readed = readed;
	}

	public Student getSendToStudent() {
		return sendToStudent;
	}

	public void setSendToStudent(Student sendToStudent) {
		this.sendToStudent = sendToStudent;
	}

	public Student getSendByStudent() {
		return sendByStudent;
	}

	public void setSendByStudent(Student sendByStudent) {
		this.sendByStudent = sendByStudent;
	}

	public Tutor getSendToTutor() {
		return sendToTutor;
	}

	public void setSendToTutor(Tutor sendToTutor) {
		this.sendToTutor = sendToTutor;
	}

	public Tutor getSendByTutor() {
		return sendByTutor;
	}

	public void setSendByTutor(Tutor sendByTutor) {
		this.sendByTutor = sendByTutor;
	}

	public LocalDateTime getSent() {
		return sent;
	}

	public void setSent(LocalDateTime sent) {
		this.sent = LocalDateTime.now();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((readed == null) ? 0 : readed.hashCode());
		result = prime * result + ((sendByStudent == null) ? 0 : sendByStudent.hashCode());
		result = prime * result + ((sendByTutor == null) ? 0 : sendByTutor.hashCode());
		result = prime * result + ((sendToStudent == null) ? 0 : sendToStudent.hashCode());
		result = prime * result + ((sendToTutor == null) ? 0 : sendToTutor.hashCode());
		result = prime * result + ((sent == null) ? 0 : sent.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (readed == null) {
			if (other.readed != null)
				return false;
		} else if (!readed.equals(other.readed))
			return false;
		if (sendByStudent == null) {
			if (other.sendByStudent != null)
				return false;
		} else if (!sendByStudent.equals(other.sendByStudent))
			return false;
		if (sendByTutor == null) {
			if (other.sendByTutor != null)
				return false;
		} else if (!sendByTutor.equals(other.sendByTutor))
			return false;
		if (sendToStudent == null) {
			if (other.sendToStudent != null)
				return false;
		} else if (!sendToStudent.equals(other.sendToStudent))
			return false;
		if (sendToTutor == null) {
			if (other.sendToTutor != null)
				return false;
		} else if (!sendToTutor.equals(other.sendToTutor))
			return false;
		if (sent == null) {
			if (other.sent != null)
				return false;
		} else if (!sent.equals(other.sent))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
