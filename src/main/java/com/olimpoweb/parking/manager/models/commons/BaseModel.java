package com.olimpoweb.parking.manager.models.commons;

import java.util.Date;
import java.util.UUID;

public abstract class BaseModel {
   private UUID id;
   protected String createdBy;
   protected Date createdAt;
   protected String lastModifiedBy;
   protected Date lastModifiedAt;

   public UUID getId() {
      return this.id;
   }

   public String getCreatedBy() {
      return this.createdBy;
   }

   public Date getCreatedAt() {
      return this.createdAt;
   }

   public String getLastModifiedBy() {
      return this.lastModifiedBy;
   }

   public Date getLastModifiedAt() {
      return this.lastModifiedAt;
   }

   public void setId(final UUID id) {
      this.id = id;
   }

   public void setCreatedBy(final String createdBy) {
      this.createdBy = createdBy;
   }

   public void setCreatedAt(final Date createdAt) {
      this.createdAt = createdAt;
   }

   public void setLastModifiedBy(final String lastModifiedBy) {
      this.lastModifiedBy = lastModifiedBy;
   }

   public void setLastModifiedAt(final Date lastModifiedAt) {
      this.lastModifiedAt = lastModifiedAt;
   }

   public BaseModel() {
   }

   public BaseModel(final UUID id, final String createdBy, final Date createdAt, final String lastModifiedBy, final Date lastModifiedAt) {
      this.id = id;
      this.createdBy = createdBy;
      this.createdAt = createdAt;
      this.lastModifiedBy = lastModifiedBy;
      this.lastModifiedAt = lastModifiedAt;
   }
}
