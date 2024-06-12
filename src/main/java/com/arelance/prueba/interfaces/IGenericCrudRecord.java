package com.arelance.prueba.interfaces;

public interface IGenericCrudRecord<T>
    extends IIdentificable<T>, ITraceable, ISoftDeleteable {
}