package com.example.ocmr.event

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject


object RxBus {
    val publisher: PublishSubject<MessageEvent> = PublishSubject.create()
    const val ON_HOME_CLICK = "ON_HOME_CLICK"
    const val ON_CHATTING_CLICK = "ON_CHATTING_CLICK"

    fun publish(messageEvent: MessageEvent) {
        publisher.onNext(messageEvent)
    }

    // Listen should return an Observable and not the publisher
    // Using ofType we filter only events that match that class type
    fun <T> listen(eventType: Class<T>): Observable<T> = publisher.ofType(eventType)
}