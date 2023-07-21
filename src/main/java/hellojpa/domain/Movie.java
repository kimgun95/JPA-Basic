package hellojpa.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("사용하고싶은 이름")
public class Movie extends Item {
	private String director;
	private String actor;
}
