package hellojpa.domain;

import static javax.persistence.FetchType.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;
  private String name;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "TEAM_ID")
  private Team team;
  @Embedded
  private Address address;

  @OneToMany(mappedBy = "member")
  private List<Order> orders = new ArrayList<>();

  public void setTeam(Team team) {
    this.team = team;
    team.getMembers().add(this);
  }

  public Member(String name) {
    this.name = name;
  }

  public Member() {

  }

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

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
