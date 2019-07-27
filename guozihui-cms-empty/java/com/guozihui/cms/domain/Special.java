package com.guozihui.cms.domain;

import java.io.Serializable;

public class Special implements Serializable{
	private Integer id;
	private String title;
	private String abstracted;
	private String created;
	private Integer acount;
	
	public Integer getAcount() {
		return acount;
	}
	public void setAcount(Integer acount) {
		this.acount = acount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbstracted() {
		return abstracted;
	}
	public void setAbstracted(String abstracted) {
		this.abstracted = abstracted;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public Special() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((abstracted == null) ? 0 : abstracted.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Special other = (Special) obj;
		if (abstracted == null) {
			if (other.abstracted != null)
				return false;
		} else if (!abstracted.equals(other.abstracted))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Special [id=" + id + ", title=" + title + ", abstracted="
				+ abstracted + ", created=" + created + ", acount=" + acount
				+ "]";
	}
	
	
}
