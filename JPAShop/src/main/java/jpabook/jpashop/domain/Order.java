package jpabook.jpashop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {
	
	@Id @GeneratedValue
	@Column(name ="ORDER_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private Member member;	
	
	private LocalDateTime orderDateTime;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItmes =new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private	OrderStatus status;
	
	public void addOrderItem(OrderItem orderItem) {
		orderItmes.add(orderItem);
		orderItem.setOrder(this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Member getMemerId() {
		return member;
	}

	public void setMemerId(Member member) {
		this.member = member;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	
}