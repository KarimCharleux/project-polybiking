package polybiking.activemq;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.io.IOException;
import java.util.List;

public class ActiveMQManager {
    private final String brokerUrl;
    private final String queueName;
    private Connection connection;
    private Session session;
    private MessageConsumer consumer;
    private boolean isConnected;

    public ActiveMQManager() {
        this.brokerUrl = "tcp://localhost:61616";
        this.queueName = "PolyBikingTrip";
        this.isConnected = false;
    }

    /**
     * Establish the connection with ActiveMQ
     *
     * @throws JMSException if the connection failed
     */
    public void connect() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(this.brokerUrl);
        factory.setTrustedPackages(List.of("polybiking"));
        this.connection = factory.createConnection();
        this.connection.start();
        this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = this.session.createQueue(this.queueName);
        this.consumer = this.session.createConsumer(destination);
        this.isConnected = true;
    }

    /**
     * Receive a message from the queue and return it
     *
     * @return the message
     */
    public Path receiveMessage() {
        try {
            Message message = consumer.receive(1000);
            if (message instanceof TextMessage textMessage) {
                return parseMessage(textMessage.getText());
            }
        } catch (JMSException e) {
            return null;
        }
        return null;
    }

    /**
     * Close the connection with ActiveMQ
     *
     * @throws JMSException if the connection cannot be closed
     */
    public void close() throws JMSException {
        if (consumer != null) {
            consumer.close();
        }
        if (session != null) {
            session.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    private Path parseMessage(String messageJson) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(messageJson, Path.class);
        } catch (IOException e) {
            System.err.println("❌ Error with ActiveMQ : " + e.getMessage());
        }
        return null;
    }

    public boolean isConnected() {
        return isConnected;
    }
}
