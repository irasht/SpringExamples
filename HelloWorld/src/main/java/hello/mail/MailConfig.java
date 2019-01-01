package hello.mail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration //@Component
public class MailConfig {
    @Bean
//    @Profile("dev")
    @ConditionalOnProperty(name = "spring.mail.host",
            havingValue = "f00",matchIfMissing = true)
    public MailSender mockMailSender() {
        return new MockMailSender();
    }

    @Bean
//    @Profile("!dev")
    @ConditionalOnProperty("spring.mail.host")
    public MailSender smtpMailSender() {
        return new SmtpMailSender();
    }
}