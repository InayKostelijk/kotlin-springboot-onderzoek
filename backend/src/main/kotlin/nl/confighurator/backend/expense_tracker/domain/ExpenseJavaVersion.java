package nl.confighurator.backend.expense_tracker.domain;

import jakarta.persistence.*;
import nl.confighurator.backend.expense_tracker.domain.enums.ExpenseCategory;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


    @Entity
    public class ExpenseJavaVersion {

        @Id
        @GeneratedValue
        private long id;
        private String title;

        @Enumerated(EnumType.STRING)
        private ExpenseCategory category;

        private Double price;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;

        public ExpenseJavaVersion() {
        }
        public void update(String title, ExpenseCategory category, Double price, LocalDateTime createdAt, LocalDateTime updatedAt) {
            this.title = title;
            this.category = category;
            this.price = price;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        public ExpenseJavaVersion(long id, String title, ExpenseCategory category, Double price, LocalDateTime createdAt, LocalDateTime updatedAt) {
            this.id = id;
            this.title = title;
            this.category = category;
            this.price = price;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        public long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public ExpenseCategory getCategory() {
            return category;
        }

        public Double getPrice() {
            return price;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }
    }





