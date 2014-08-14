package no.web.jms.producer;

import org.hornetq.api.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

public class JMSProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public JmsTemplate getJmsTemplate() {
        return this.jmsTemplate;
    }

    public void sendMessages() throws JMSException {

        jmsTemplate.send(new MessageCreator() {

            public TextMessage createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage("test message");
                message.setStringProperty("textToHornetFromMySpring", "Thou shall not pass. Mvh Gandalf");
                return message;
            }

        });
    }

    public String receiveMessages() throws JMSException {
        return jmsTemplate.receive().getStringProperty("textToHornetFromMySpring");
    }
}