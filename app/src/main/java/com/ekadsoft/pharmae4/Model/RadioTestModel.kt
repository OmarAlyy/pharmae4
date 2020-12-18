package com.ekadsoft.pharmae4.Model

class RadioTestModel(id: String , name : String , check: Boolean) {
    var check: Boolean = false
    var id: String? = null
    var name: String? = null


    init {
        this.check = check
        this.name = name
        this.id = id
    }


}