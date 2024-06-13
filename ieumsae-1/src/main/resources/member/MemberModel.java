package member;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity // JPA의 개체를 의미, MemberModel이라는 클래스가 JPA 엔티티임을 의미, DB 테이블과 매핑
@Table(name = "members") // DB 안에 테이블 이름을 설정
public class MemberModel {
    @Id // primaryKey를 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) // null 허용X, 중복허용 X
    private String userId;
    private String nickname;
    private String phoneNumber;
    private String email;
    
    @Column(nullable = true, unique = false) // null 허용O, 중복허용 O
    private String password;
    private boolean isAdult;
    private String gender;
    private String mbti;
    private String zipcode;
    private boolean privacyPolicyAccepted;
    
    
    
    @ElementCollection // 자료 타입이 List나 Map처럼 Collection형태이면 따로 테이블을 생성해서 관리
    @CollectionTable(name = "member_interests", joinColumns = @JoinColumn(name = "member_id"))
    @Column(name = "interest")
    private List<String> interests;

    @ElementCollection // 자료 타입이 List나 Map처럼 Collection형태이면 따로 테이블을 생성해서 관리
    @CollectionTable(name = "member_regions", joinColumns = @JoinColumn(name = "member_id"))
    @Column(name = "region")
    private List<String> regions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdult() {
		return isAdult;
	}

	public void setAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMbti() {
		return mbti;
	}

	public void setMbti(String mbti) {
		this.mbti = mbti;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public boolean isPrivacyPolicyAccepted() {
		return privacyPolicyAccepted;
	}

	public void setPrivacyPolicyAccepted(boolean privacyPolicyAccepted) {
		this.privacyPolicyAccepted = privacyPolicyAccepted;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public List<String> getRegions() {
		return regions;
	}

	public void setRegions(List<String> regions) {
		this.regions = regions;
	}

    // Getters and Setters
    
}
