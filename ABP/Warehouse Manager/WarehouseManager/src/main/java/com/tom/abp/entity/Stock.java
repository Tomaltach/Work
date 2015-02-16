package com.tom.abp.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@XmlRootElement
@Table(name="stock")
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Size(min=4, max=25)
	private String boxNumber;
	@NotEmpty
	@Size(min=4, max=25)
	private String name;
	@NotEmpty
	@Size(min=4, max=255)
	private String description;
	@NotEmpty
	@Size(min=4, max=255)
	private List<String> tag;
	@NotNull
	@DateTimeFormat
	private Date dateAdded;
	@NotNull
	@DateTimeFormat
	private Date dateRemoved;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBoxNumber() {
		return boxNumber;
	}
	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag.add(tag);
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Date getDateRemoved() {
		return dateRemoved;
	}
	public void setDateRemoved(Date dateRemoved) {
		this.dateRemoved = dateRemoved;
	}	
}
