package com.omran.accesssystemfile

import java.util.*

class SendingData {

    companion object{
        private val data: MutableMap<String, Any> = HashMap()

        var comeFromHere: Boolean
            get() {
                val resault = data["SETDATA"]
                return resault as Boolean
            }

            set(value) {
               data.put("SETDATA",value)
            }

    }
}


