package com.vektorel.kafkaproducer.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServer;

    private AdminClient getAdminClient() {

        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        return AdminClient.create(properties);
    }

    public void createTopic(String topicName, int partitions, short replication) {
        try {
            AdminClient adminClient = getAdminClient();

            NewTopic topic = new NewTopic(topicName,partitions,replication);
            adminClient.createTopics(Collections.singleton(topic));

            adminClient.close();

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("---- Create topic failed ----");
        }

    }



    public Set<String> listTopics() {

        try (AdminClient adminClient = getAdminClient())  {


            Set<String> topicListesi= adminClient.listTopics().names().get();

            return topicListesi;

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("---- List topic failed ----");
        }

    }





}
