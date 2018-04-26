package com.atsz.manager.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="category")
public class Category implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;

	@Column(name="parent_id")
	private Long parentId;
	
	@Column(name="sort_order")
	private Integer sortOrder;
	
	@Column(name="show_in_nav")
	private Integer showInNav;
	
	@Column(name="is_show")
	private Integer isShow;

	@Column(name="grade")
	private Integer grade;
	
	@Column(name="filter_attr")
	private String filterAttr;

	@Column(name="is_top_style")
	private Integer isTopStyle;
	
	@Column(name="top_style_tpl")
	private String topStyleTpl;
	
	@Column(name="style_icon")
	private String styleIcon;
	
	@Column(name="cat_icon")
	private String  catIcon;
	
	@Column(name="is_top_show")
	private Integer isTopShow;
	
	@Column(name="category_links")
	private String categoryLinks;

	@Column(name="category_topic")
	private String  categoryTopic;
	
	@Column(name="cat_alias_name")
	private String catAliasName;
	
	@Column(name="commission_rate")
	private Short commissionRate;
	
	@Column(name="touch_icon")
	private String touchIcon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getShowInNav() {
		return showInNav;
	}

	public void setShowInNav(Integer showInNav) {
		this.showInNav = showInNav;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getFilterAttr() {
		return filterAttr;
	}

	public void setFilterAttr(String filterAttr) {
		this.filterAttr = filterAttr;
	}

	public Integer getIsTopStyle() {
		return isTopStyle;
	}

	public void setIsTopStyle(Integer isTopStyle) {
		this.isTopStyle = isTopStyle;
	}

	public String getTopStyleTpl() {
		return topStyleTpl;
	}

	public void setTopStyleTpl(String topStyleTpl) {
		this.topStyleTpl = topStyleTpl;
	}

	public String getStyleIcon() {
		return styleIcon;
	}

	public void setStyleIcon(String styleIcon) {
		this.styleIcon = styleIcon;
	}

	public String getCatIcon() {
		return catIcon;
	}

	public void setCatIcon(String catIcon) {
		this.catIcon = catIcon;
	}

	public Integer getIsTopShow() {
		return isTopShow;
	}

	public void setIsTopShow(Integer isTopShow) {
		this.isTopShow = isTopShow;
	}

	public String getCategoryLinks() {
		return categoryLinks;
	}

	public void setCategoryLinks(String categoryLinks) {
		this.categoryLinks = categoryLinks;
	}

	public String getCategoryTopic() {
		return categoryTopic;
	}

	public void setCategoryTopic(String categoryTopic) {
		this.categoryTopic = categoryTopic;
	}

	public String getCatAliasName() {
		return catAliasName;
	}

	public void setCatAliasName(String catAliasName) {
		this.catAliasName = catAliasName;
	}

	public Short getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(Short commissionRate) {
		this.commissionRate = commissionRate;
	}

	public String getTouchIcon() {
		return touchIcon;
	}

	public void setTouchIcon(String touchIcon) {
		this.touchIcon = touchIcon;
	}

}
