package com.ekadsoft.pharmae4.View.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ekadsoft.pharmae4.R
import com.ekadsoft.pharmae4.ScheduleHistoryViewModel
import com.ekadsoft.pharmae4.databinding.ActivityScheduleHistoryBinding
import com.michalsvec.singlerowcalendar.calendar.CalendarChangesObserver
import com.michalsvec.singlerowcalendar.calendar.CalendarViewManager
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendarAdapter
import com.michalsvec.singlerowcalendar.selection.CalendarSelectionManager
import com.michalsvec.singlerowcalendar.utils.DateUtils
import kotlinx.android.synthetic.main.calendar_item.view.*
import java.util.*

class ScheduleHistoryActivity : AppCompatActivity() {



    lateinit var binding: ActivityScheduleHistoryBinding

    lateinit var viewmodel: ScheduleHistoryViewModel
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_schedule_history)
        viewmodel = ViewModelProviders.of(this).get(ScheduleHistoryViewModel::class.java)

         viewmodel.activity = this
         binding.viewmodel = viewmodel
        viewmodel.getData()

        binding.back.setOnClickListener {
            finish()

        }

        initSingleRowCalendar()

    }

    fun initSingleRowCalendar() {

        val calendar = Calendar.getInstance()
        var currentMonth = 0
        calendar.time = Date()
        currentMonth = calendar[Calendar.MONTH]


        // calendar view manager is responsible for our displaying logic
        val myCalendarViewManager = object :
            CalendarViewManager {
            override fun setCalendarViewResourceId(
                position: Int,
                date: Date,
                isSelected: Boolean
            ): Int {
                // set date to calendar according to position where we are
                val cal = Calendar.getInstance()
                cal.time = date
                // if item is selected we return this layout items
                // in this example. monday, wednesday and friday will have special item views and other days
                // will be using basic item view
                if (isSelected)
                    return R.layout.selected_calendar_item
                else
                    return R.layout.calendar_item


                // NOTE: if we don't want to do it this way, we can simply change color of background
                // in bindDataToCalendarView method
            }

            override fun bindDataToCalendarView(
                holder: SingleRowCalendarAdapter.CalendarViewHolder,
                date: Date,
                position: Int,
                isSelected: Boolean
            ) {
                // using this method we can bind data to calendar view
                // good practice is if all views in layout have same IDs in all item views
                holder.itemView.tv_date_calendar_item.text = DateUtils.getDayNumber(date)
                holder.itemView.tv_day_calendar_item.text = DateUtils.getDay3LettersName(date)

            }
        }

        // using calendar changes observer we can track changes in calendar
        val myCalendarChangesObserver = object :
            CalendarChangesObserver {
            // you can override more methods, in this example we need only this one
            override fun whenSelectionChanged(isSelected: Boolean, position: Int, date: Date) {
                binding!!.tvDate.text =
                    "${DateUtils.getMonthName(date)} ${DateUtils.getYear(date)}  "
                super.whenSelectionChanged(isSelected, position, date)
            }


        }

        // selection manager is responsible for managing selection
        val mySelectionManager = object : CalendarSelectionManager {
            override fun canBeItemSelected(position: Int, date: Date): Boolean {
                // set date to calendar according to position
                val cal = Calendar.getInstance()
                cal.time = date
                // in this example sunday and saturday can't be selected, others can
                return when (cal[Calendar.DAY_OF_WEEK]) {

                    else -> true
                }
            }
        }


        val singleRowCalendar = binding!!.mainSingleRowCalendar.apply {
            calendarViewManager = myCalendarViewManager
            calendarChangesObserver = myCalendarChangesObserver
            calendarSelectionManager = mySelectionManager
            //  setDates(getFutureDatesOfCurrentMonth())
            futureDaysCount = 60
            includeCurrentDate = true
            init()
        }

        singleRowCalendar.select(0)


    }



}