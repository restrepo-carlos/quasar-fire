package com.quasar.fire.service;

/**
 * Created by Carlos Restrepo on 6/11/2021.
 */
public interface MessageService {

  /**
   * Método encargado de recibir y generar un mensaje entre satélites.
   *
   * @param messages
   * @return
   */
  String getMessage(String[]... messages);
}
