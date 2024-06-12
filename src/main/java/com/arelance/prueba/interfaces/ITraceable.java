package com.arelance.prueba.interfaces;

import java.util.Date;

public interface ITraceable {
  Date getCreatedTimeUtc();
  void setCreatedTimeUtc(Date timeUtc);

  Date getLastModifiedTimeUtc();
  void setLastModifiedTimeUtc(Date timeUtc);
}