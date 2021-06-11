package com.quasar.fire.service.impl;

import com.quasar.fire.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Carlos Restrepo on 6/11/2021.
 */
@Service
public class MessageServiceImpl implements MessageService {

  @Override
  public String getMessage(String[]... messages) {
    if (messages == null || messages.length == 0) {
      return null;
    }

    String[] words = new String[messages[0].length];
    for (String[] arrayMessage : messages) {
      for (int i = 0; i < arrayMessage.length; i++) {
        String word = arrayMessage[i].trim();
        if (word != null && !word.isEmpty()) {
          words[i] = word;
        }
      }
    }

    return StringUtils.arrayToDelimitedString(words, " ");
  }
}
