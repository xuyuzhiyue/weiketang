package com.ideabobo.model;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Changci implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Integer rid;
	private String rtitle;
	private Integer pid;
	private String ptitle;
	private String sites;
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
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getSites() {
		return sites;
	}
	public void setSites(String sites) {
		this.sites = sites;
	}
	
}