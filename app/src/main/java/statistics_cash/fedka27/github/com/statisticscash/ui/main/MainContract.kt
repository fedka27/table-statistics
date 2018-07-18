package statistics_cash.fedka27.github.com.statisticscash.ui.main

import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note
import statistics_cash.fedka27.github.com.statisticscash.ui.base.mvp.BaseContract

interface MainContract {
    interface View : BaseContract.View {

        fun setText(text: String)

        fun onError(message: String?)

    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onLoadPressed()

        fun insertNote(note: Note)

        fun onStop()

    }
}