package com.arelance.prueba.interfaces;

import java.util.Date;

public interface ISoftDeleteable {
  boolean isDeleted();
  void setDeleted(boolean deleted);

  Date getDeletedTimeUtc();
  void setDeletedTimeUtc(Date timeUtc);
}
