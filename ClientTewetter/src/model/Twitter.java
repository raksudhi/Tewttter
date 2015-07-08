package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the TWITTER database table.
 * 
 */
@Entity
@Table(name="TWITTER", schema="GUITARSHOP")
@NamedQuery(name="Twitter.findAll", query="SELECT t FROM Twitter t")
public class Twitter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TWITTER_SLID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TWITTER_SLID_GENERATOR")
	@Column(unique=true, nullable=false)
	private long slid;

	@Column(name="\"MESSAGE\"", length=140)
	private String message;

	@Column(length=255)
	private String name;
	
	private Timestamp postdate;

	public Twitter() {
	}

	public long getSlid() {
		return this.slid;
	}

	public void setSlid(long slid) {
		this.slid = slid;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getPostdate() {
		return this.postdate;
	}

	public void setPostdate(Timestamp postdate) {
		this.postdate = postdate;
	}

}