package com.trainingplatform.uploadingservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQMessagingConfig {

    public static final String QUEUE_UPLOAD_PP = "UserProfilePictureUploadQueue";
    public static final String QUEUE_DELETE_PP = "UserProfilePictureDeleteQueue";
    public static final String QUEUE_UPLOAD_TRAINING_THUMBNAIL = "TrainingThumbnailUploadQueue";
    public static final String QUEUE_DELETE_TRAINING_THUMBNAIL = "TrainingThumbnailDeleteQueue";
    public static final String EXCHANGE = "OfflineLessonStreamingExchange";
    public static final String ROUTING_KEY_UPLOAD_PP = "UserProfilePictureUploadRoutingKey";
    public static final String ROUTING_KEY_DELETE_PP = "UserProfilePictureDeleteRoutingKey";
    public static final String ROUTING_KEY_UPLOAD_TRAINING_THUMBNAIL = "TrainingThumbnailUploadRoutingKey";
    public static final String ROUTING_KEY_DELETE_TRAINING_THUMBNAIL = "TrainingThumbnailDeleteRoutingKey";

    @Bean
    public Queue queueUploadPP() {
        return new Queue(QUEUE_UPLOAD_PP);
    }

    @Bean
    public Queue queueDeletePP() {
        return new Queue(QUEUE_DELETE_PP);
    }

    @Bean
    public Queue queueUploadTrainingThumbnail() {
        return new Queue(QUEUE_UPLOAD_TRAINING_THUMBNAIL);
    }

    @Bean
    public Queue queueDeleteTrainingThumbnail() {
        return new Queue(QUEUE_DELETE_TRAINING_THUMBNAIL);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingUpload(@Qualifier("queueUploadPP") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_UPLOAD_PP);
    }

    @Bean
    public Binding bindingDelete(@Qualifier("queueDeletePP") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_DELETE_PP);
    }

    @Bean
    public Binding bindingUploadTrainingThumbnail(@Qualifier("queueUploadTrainingThumbnail") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_UPLOAD_TRAINING_THUMBNAIL);
    }

    @Bean
    public Binding bindingDeleteTrainingThumbnail(@Qualifier("queueDeleteTrainingThumbnail") Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_DELETE_TRAINING_THUMBNAIL);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }
}
