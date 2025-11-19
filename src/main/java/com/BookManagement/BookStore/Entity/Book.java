package com.BookManagement.BookStore.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

 @NotBlank
  private String title;

 @Positive
  private double price;


 @ManyToOne
 @JoinColumn(name = "category_id" )
  private Category category;
}
