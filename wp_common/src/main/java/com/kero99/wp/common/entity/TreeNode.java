package com.kero99.wp.common.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNode {
	private Long id;
	private String text;
	private String state;
	private Boolean checked;
	private Map<String, Object> attributes;
	private List<TreeNode> children;
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		if(attributes==null){
			attributes=new HashMap<>();
		}
		attributes.put("url", url);
		this.url = url;
	}
	public TreeNode() {
		state="open";
		checked=true;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
}
