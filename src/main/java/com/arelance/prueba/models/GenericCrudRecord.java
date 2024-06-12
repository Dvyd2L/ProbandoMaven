package com.arelance.prueba.models;

import java.util.Date;

import com.arelance.prueba.interfaces.IGenericCrudRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class GenericCrudRecord<T>
    implements IGenericCrudRecord<T> {
  private T id;
  private Date createdTimeUtc;
  private Date lastModifiedTimeUtc;
  private Date deletedTimeUtc;
  private boolean isDeleted;
}
