package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils;

public class Constants {
  public static String USER_NOT_FOUND_ERROR_MESSAGE = "El id de este usuario no se encuentra registrado";
  public static String SELLER_NOT_FOUND_ERROR_MESSAGE = "El id del vendedor no se encuentra registrado";
  public static String SELLER_TO_FOLLOW_NOT_FOUND_ERROR_MESSAGE = "El id del vendedor a seguir no se encuentra registrado";
  public static String USER_IS_NOT_SELLER_ERROR_MESSAGE = "El id del usuario no corresponde a un vendedor";
  public static String ALREADY_FOLLOWED_SELLER_ERROR_MESSAGE = "El usuario ya sigue al vendedor con ese id";
  public static String NOT_FOLLOWED_SELLER_ERROR_MESSAGE = "El usuario no sigue al vendedor con ese id";
  public static String USER_FOLLOW_TO_HIMSELF_ERROR_MESSAGE = "El usuario no se puede seguir a si mismo";
  public static String USER_DONT_FOLLOW_ANYONE_ERROR_MESSAGE = "El usuario no sigue a ningun vendedor";
  public static String SELLER_DONT_HAVE_FOLLOWERS_ERROR_MESSAGE = "El usuario no tiene seguidores";
  public static String BAD_NAME_ORDER_TYPE_ERROR_MESSAGE = "El metodo de ordenamiento debe estar entre name_asc, name_desc o no tener ninguno";
  public static String BAD_DATE_ORDER_TYPE_ERROR_MESSAGE = "El metodo de ordenamiento debe estar entre date_asc, date_desc o no tener ninguno";
  public static String PRODUCT_ALREADY_HAVE_POST_ERROR_MESSAGE = "Ya existe un post para este producto";
  public static String FOLLOWED_DONT_HAVE_POSTS_ERROR_MESSAGE = "Ninguno de los seguidos de este usuario ha realizado publicaciones en las últimas dos semanas";
  public static final String ORDER_NAME_ASC = "name_asc";
  public static final String ORDER_NAME_DESC = "name_desc";
  public static final String ORDER_DATE_ASC = "date_asc";
  public static final String ORDER_DATE_DESC = "date_desc";
  public static final String NOT_ORDER = "none";
}
