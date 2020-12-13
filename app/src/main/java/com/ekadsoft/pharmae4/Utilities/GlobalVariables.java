package com.ekadsoft.pharmae4.Utilities;



public abstract class GlobalVariables {
    public static final float TOOLBAR_ELEVATION = 4f;
    public static final int LOCATION_REQUEST_PERMISSION = 6518;


    public static final int DEFAULT_USER_TYPE = 0;


    public static int country_id = -1;
    public static String country_name = "";


    public static int region_id = -1;
    public static String region_name = "";


    public static int city_id = -1;
    public static String city_name = "";


    public static String nameCat = "";
    public static int positionCat = -1;
    public static int idCat = -1;


    public static String delivery_fees = "";
    public static String notifications_count = "0";
    public static String cart_items_count = "0";
    public static boolean fromNoti = false ;
    public static String otp ="";
    public static boolean openCompany = false;
    public static boolean cart_delete =false ;



    public static final int SKIP_USER_TYPE = 3;
    public static final int DEFAULT_USER_TYPE_NOT_COMPLETE_REGERSTER = 4;



    public static void clearData() {

        country_id = -1;
        country_name = "";
        region_id = -1;
        region_name = "";
        city_id = -1;
        city_name = "";
        nameCat = "";
        positionCat = -1;
        idCat = -1;
    }



}
