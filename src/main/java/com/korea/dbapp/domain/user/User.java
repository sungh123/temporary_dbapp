package com.korea.dbapp.domain.user;

<<<<<<< HEAD
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.korea.dbapp.domain.post.Post;

@Entity
public class User {
	//primary key표시
	@Id																						
	//auto increament설정 -IDENTITY는?정체성을 따라가라
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;							//프라이머리키(기본키)
	
	@Column(unique=true, length =20)			//username에 unique걸어주면 ? 똑같은 아이디로 회원가입 안됨
																				//길이를 20자로 제한
	private String username;								//id로 사용할 예정
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 프라이머리키 (기본키)
	
	@Column(unique = true, length = 20)
	private String username;
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
	private String password;
	private String email;
	private String address;
	
<<<<<<< HEAD
	
	//join해서 post안에 있는 user넣어줄때, user를 넣지 말아라(json으로 파싱하지 말아라) 
	@JsonIgnoreProperties({"user"})				
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)				//나는 Fk키가 아니다! 주인은 user(Post클래서에서 User 변수)이다라는 의미
	private List<Post> posts;								//이대로 FK키를 안만들게 해야한다!! 그러면 원자성이 깨진다.
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", posts=" + posts + "]";
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
=======
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
<<<<<<< HEAD
	
=======
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
