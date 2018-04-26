package com.atsz.manager.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

@Table(name = "product")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "sellpoint")
	private String sellpoint;

	@Column(name = "price")
	private Long price;

	@Column(name = "num")
	private Integer num;

	@Column(name = "image")
	private String image;

	@Column(name = "cid")
	private Long cid;

	@Column(name = "status")
	private Boolean status=true;
	
	// 在映射数据库表的时候，忽略该属性
        @Transient
        private String[] images;

        public String[] getImages() {
                if (StringUtils.isNotBlank(this.image)) {
                        return StringUtils.split(this.image, ",");
                }
                return null;
        }

        public void setImages(String[] images) {
                this.images = images;
        }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSellpoint() {
		return sellpoint;
	}

	public void setSellpoint(String sellpoint) {
		this.sellpoint = sellpoint;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", sellPoint="
				+ sellpoint + ", price=" + price + ", num=" + num + ", image="
				+ image + ", cid=" + cid + ", status=" + status + "]";
	}

}
