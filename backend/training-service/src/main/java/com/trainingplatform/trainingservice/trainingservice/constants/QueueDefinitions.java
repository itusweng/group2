package com.trainingplatform.trainingservice.trainingservice.constants;

import lombok.Getter;

@Getter
public enum QueueDefinitions {

    /*  Define enums here    */
    UserParticipation_SendTrainingNotificationQueue(1, SendTrainingParticipationNotification.QUEUE_NAME,
            SendTrainingParticipationNotification.ROUTING_KEY,
            SendTrainingParticipationNotification.EXCHANGE);

    /*  Define static fields for each queue here    */
    public class SendTrainingParticipationNotification {
        public static final String QUEUE_NAME = "queueName_userParticipation_sendTrainingParticipationNotification";
        public static final String ROUTING_KEY = "routingKey_userParticipation_sendTrainingParticipationNotification";
        public static final String EXCHANGE = "exchange_userParticipation_sendTrainingParticipationNotification";
    }


    /* Required attributes to create a new queue */
    private final String queueName;
    private final String routingKey;
    private final String exchange;
    private final Integer queueId;

    QueueDefinitions(Integer queueId, String queueName, String routingKey, String exchange) {
        this.queueId = queueId;
        this.queueName = queueName;
        this.routingKey = routingKey;
        this.exchange = exchange;
    }
}
