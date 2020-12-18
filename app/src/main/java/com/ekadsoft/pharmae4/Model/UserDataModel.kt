package com.ekadsoft.pharmae4.Model

import java.io.Serializable

class UserDataModel : Serializable {
    var id: String? = null
    var name: String? = null
    var email: String? = null
    var phone_number: String? = null
    var profile_image = ""
    var national_id_image = ""
    var tax_id_image = ""
    var commercial_id_image = ""
    var shop_name: String? = null
    var city_id: String? = null
    var city_name: String? = null
    var region_id: String? = null
    var region_name: String? = null
    var map_address = ""
    var address: String? = null
    var cart_id: String? = null
    var is_verified = ""
}