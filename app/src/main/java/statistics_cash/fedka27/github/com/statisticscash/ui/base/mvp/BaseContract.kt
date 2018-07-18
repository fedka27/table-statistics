package statistics_cash.fedka27.github.com.statisticscash.ui.base.mvp

interface BaseContract {
    interface View {

    }

    interface Presenter<V : View> {
        val view: V
    }
}