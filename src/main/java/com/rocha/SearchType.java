package com.rocha;

/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

public enum SearchType {
  DOCUMENT_ID("cc"),
  PHONE("phone");

  private final String code;

  SearchType(final String code) {

    this.code = code;
  }

  public String getCode() {

    return code;
  }
}

