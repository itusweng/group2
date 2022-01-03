package com.trainingplatform.trainingservice.trainingservice.config;

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

    public static final String QUEUE_UPLOAD = "OfflineLessonUploadQueue";
    public static final String QUEUE_DELETE = "OfflineLessonDeleteQueue";
    public static final String EXCHANGE = "OfflineLessonStreamingExchange";
    public static final String ROUTING_KEY_UPLOAD = "OfflineLessonUploadRoutingKey";
    public static final String ROUTING_KEY_DELETE = "OfflineLessonDeleteRoutingKey";

    @Bean
    public Queue queueUpload() {
        return new Queue(QUEUE_UPLOAD);
    }

    @Bean
    public Queue queueDelete() { return new Queue(QUEUE_DELETE); }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingUpload(@Qualifier("queueUpload") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_UPLOAD);
    }

    @Bean
    public Binding bindingDelete(@Qualifier("queueDelete") Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_DELETE);
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
