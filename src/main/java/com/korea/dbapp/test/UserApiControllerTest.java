package com.korea.dbapp.test;

import java.util.List;

<<<<<<< HEAD
import org.springframework.ui.Model;
=======
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.korea.dbapp.domain.user.User;
import com.korea.dbapp.domain.user.UserRepository;

@RestController
public class UserApiControllerTest {

<<<<<<< HEAD
	//final로 선언한 이유??
	//생성자 기억하게 하려고! 생성자 만들어야 DI가 된다.
	private final UserRepository userRepository;

	//의존성 주입(DI)
=======
	private final UserRepository userRepository;

	// 의존성 주입 (DI)
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
	public UserApiControllerTest(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
<<<<<<< HEAD
	//save하려면? PostMapping으로! (이 프로토콜은 안지켜도 되지만,,post로!)
	@PostMapping("/test/user")  //명사는 user, 동사는 post 
=======
	@GetMapping("/test/script")
	public String script() {
		return "<script>alert('hello');</script>";
	}
	
	@PostMapping("/test/user")
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
	public String save(User user) {
		userRepository.save(user);
		return "save ok";
	}
	
<<<<<<< HEAD
	//저장한 데이터 모두 찾아보자
	@GetMapping("/test/user")  //Get 이니까 postman사용 안해도 된다.
=======
	@GetMapping("/test/user")
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
<<<<<<< HEAD
	//1건만 찾아보자!
	// http://localhost:8000/user/2 이렇게 주소 입력하면,
	// parsing방법은?? request.getURI로 ,,, -> test해보자
	@GetMapping("/test/user/{id}")  //주소에 /user/1 이라고 하면? id=1이 넣어짐
	public String findById(@PathVariable int id) {
		// findById =>return타입이 Optional 이다~!
		//  Optional : 박스를  들고가서  붕어싸만코 달라고하고 있으면  그안에 넣고 없으면 빈 박스만 들고 옴
		// .get()은?? 무조건 있어!!라는 의미
		User userEntity=userRepository.findById(id).get();
//		System.out.println("1");
//		userEntity.getPosts().get(0).getTitle();
//		System.out.println("2");
		
		//toString이 호출된다!!!!! 이때 open in view가 false이면? toString에서  Lazy loading해서 가져와야해서 에러뜸
		//그런데, open in view : true이면? 그래서 에러뜸!!! 왜 서로 무한참조하니까!
		System.out.println(userEntity); 	
		return "ok"; 
	}
	
	
	//username이 "ssar" 인 데이터 찾아보자!
	//보통 회원가입할 때, username은 중복되지 않게함. 
	//즉 username검색하면 return은 0또는 1
	//username으로 찾는건 모두의 공통적인  게 아니니까! 내가 쿼리를 만들어야함
	//@GetMapping("/user/{username}") => 이렇게 적으면? 위에 id로 찾는 함수와 충돌!
	@GetMapping("/test/user/username/{username}")
	public User finByUsername(@PathVariable String username) {
		//mfindByUsername 새로운 함수를 만들어야 함. =>userRepository에서!
		return userRepository.mFindByUsername(username);
	}
	
	
	@PostMapping("/test/login")
	public String login(@RequestBody User user) { //json으로 던져보자!!! 
		
		//userEntity => DB로부터 return받은 값이라는 표시!
		User userEntity=userRepository.mLogin(user.getUsername(), user.getPassword());
		
		if(userEntity==null) {
			return "login fail";
			
		} else {
			return "login success";
			
		}
	}
	
	@DeleteMapping("/test/user/{id}") 
=======
	// http://localhost:8000/user/2
	@GetMapping("/test/user/{id}")
	public User findById(@PathVariable int id) {	
		return userRepository.findById(id).get();
	}
	
	@GetMapping("/test/user/username/{username}")
	public User findByUsername(@PathVariable String username) {
		return userRepository.mFindByUsername(username);
	}
	
	@PostMapping("/test/login")
	public String login(@RequestBody User user) {
		User userEntity = userRepository.mLogin(user.getUsername(), user.getPassword());
		if(userEntity == null) {
			return "login fail";
		}else {
			return "login success";
		}
	}
	
	@DeleteMapping("/test/user/{id}")
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
	public String deleteById(@PathVariable int id) {
		userRepository.deleteById(id);
		return "delete ok";
	}
	
<<<<<<< HEAD
	//restful API 방식(주소 표시하는 방식 중 하나) 프로토콜!!
	//변경할 데이터가 있다면??
	//전송할 데이터를 Body 에 들고간다!!
	//보통 주소에, where절에 들어가는 값을 넣을수 있도록  / {id} =>@PathVariable int id 로 !!
	// 1번 user를 수정하는 식으로! =>"/user/{id}"
	@PutMapping("/test/user/{id}") //업데이트 기능
	public String updateOne(@PathVariable int id, User user) { //user에 password,email 담아 보낼 예정
		//이렇게 하면?
		//현재 id,password,email을 받아서 user객체 만들고 save하면? username이 날라간다!
		//user.setId(id);
		
		//이대로 save하면?  insert된다!!
		//userRepository.save(user);
		
		//첫번째!  ID로 수정할 데이터를 SELECT한다!
		//1. id로 select하기
		User userEntity=userRepository.findById(id).get();
		
		//2.받은 body 데이터로 수정하기 
		userEntity.setPassword(user.getPassword());
		userEntity.setEmail(user.getEmail());
		
		//3.수정된 userEntity로 저장하기 
		//   save하기 (이때 꼭 id값이  db에 존재해야 update가 된다)
		userRepository.save(userEntity);
	
		return "update ok";
	}
	
	//https://www.juso.go.kr/addrlink/addrLinkUrl.do?confmKey=devU01TX0FVVEgyMDIxMDcwNTE3MjgyMzExMTM2MTE=&returnUrl=http://localhost:8000/juso	
	//다른 사람 서버에 요청해서 응답이 redirect이 localhost:8000/juso로!!
	
	//@PostMapping("/juso")
	public String juso(String roadFullAddr) {
		return roadFullAddr;
	}
	
}
=======
	@PutMapping("/test/user/{id}")
	public String updateOne(@PathVariable int id, User user) { // password, email
		// 1. id로 select 하기
		User userEntity = userRepository.findById(id).get();
		
		// 2. 받은 body 데이터로 수정하기
		userEntity.setPassword(user.getPassword());
		userEntity.setEmail(user.getEmail());
		
		// 3. save하면 된다. (이때 꼭 id값이 db에 존재해야 update가 된다)
		userRepository.save(userEntity);
		
		return "update ok";
	}
	
	
}




>>>>>>> 036f4e5 (1. ORM 매핑 시작)
