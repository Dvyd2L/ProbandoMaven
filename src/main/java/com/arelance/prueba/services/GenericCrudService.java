package com.arelance.prueba.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arelance.prueba.interfaces.IGenericCrudRecord;
import com.arelance.prueba.interfaces.IGenericCrudService;

@Service
public class GenericCrudService<T extends IGenericCrudRecord<TId>, TId>
    implements IGenericCrudService<T, TId> {
  protected final List<T> records = new ArrayList<T>();

  public List<T> get() {
    return records.stream().filter(u -> !u.isDeleted()).toList();
  }

  public Optional<T> getById(TId id) {
    return records.stream().filter(u -> u.getId().equals(id)).findFirst();
  }

  public void create(T record) {
    record.setCreatedTimeUtc(this.getCurrentTimeUtc());
    records.add(record);
  }

  public boolean update(T record) {
    boolean result = false;
    Optional<T> existingRecord = this.getById(record.getId());
    if (existingRecord.isPresent()) {
      T updatedRecord = existingRecord.get();
      updatedRecord.setLastModifiedTimeUtc(this.getCurrentTimeUtc());
      result = true;
    }
    return result;
  }

  public boolean softDelete(TId id) {
    Optional<T> existingRecord = this.getById(id);
    if (existingRecord.isPresent()) {
      existingRecord.get().setDeleted(true);
      existingRecord.get().setDeletedTimeUtc(this.getCurrentTimeUtc());
    }
    return existingRecord.get().isDeleted();
  }

  public boolean hardDelete(TId id) {
    return records.removeIf(x -> x.getId().equals(id));
  }

  protected Date getCurrentTimeUtc() {
    return Date.from(Instant.now());
  }
}
