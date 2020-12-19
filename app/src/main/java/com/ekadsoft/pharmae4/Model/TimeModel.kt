package com.ekadsoft.pharmae4.Model

class TimeModel(id: String, name : String, isAvailable: Boolean , isCheck: Boolean ) {
    var isAvailable: Boolean = false
    var isCheck: Boolean = false
    var id: String? = null
    var name: String? = null


    init {
        this.isAvailable = isAvailable
        this.name = name
        this.id = id
        this.isCheck = isCheck
    }


}