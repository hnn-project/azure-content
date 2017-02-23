package kr.co.ds_etrade.storage_demo;

import com.microsoft.azure.storage.table.TableServiceEntity;

public class TestEntity extends TableServiceEntity {
    public TestEntity(String lastName, String firstName) {
        this.partitionKey = lastName;
        this.rowKey = firstName;
    }

    public TestEntity() { }

    String description;
    String dueDate;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}