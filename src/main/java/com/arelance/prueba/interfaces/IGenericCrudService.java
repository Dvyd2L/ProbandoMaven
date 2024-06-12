package com.arelance.prueba.interfaces;

import java.util.List;
import java.util.Optional;

public interface IGenericCrudService<T extends IGenericCrudRecord<TId>, TId> {
  /**
   * Obtiene todos los registros.
   * @return Lista con todos los registros.
   */
  List<T> get();

  /**
   * Recupera un registro de la lista de registros por su id.
   * @param id Id del registro que queremos recuperar.
   * @return El registro que queremos recuperar.
   */
  Optional<T> getById(TId id);

  /**
   * Crea un nuevo registro en la lista de registros.
   * @param record El registro que vamos a crear
   */
  void create(T record);

  /**
   * Actualiza los datos de un registro existente.
   * @param record registro a actualizar
   * @return true si se ha actualizado, false en caso contrario
   */
  boolean update(T record);

  /**
   * Marca como eliminado a un registro de la lista de registros.
   * @param id Id del registro a eliminar
   * @return true si se ha eliminado, false en caso contrario
   */
  boolean softDelete(TId id);

  /**
   * Elimina a un registro de la lista de registros.
   * @param id Id del registro a eliminar
   * @return true si se ha eliminado, false en caso contrario
   */
  boolean hardDelete(TId id);
}
