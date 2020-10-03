package com.shecodes.expense.model;

import com.sun.istack.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category")
@Data
public class Category {
	@Id
	private Long id;

	@NotNull
	private String name;


}
