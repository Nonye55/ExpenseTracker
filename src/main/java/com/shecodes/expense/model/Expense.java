package com.shecodes.expense.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name="expense")
public class Expense {

    @Id
    private Long id;
    private String descipt;
    private Instant expensedate;
    private String  location;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ExpenseUser expenseUser;




}
