package japshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class OrderItem {
	
	@Id @GeneratedValue
	private Long id;
}
