package bg.softuni.MobiLeLe.config;

import bg.softuni.MobiLeLe.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends GlobalMethodSecurityConfiguration {

  @Autowired
  private MobileleMethodSecurityExpressionHandler mobileleMethodSecurityExpressionHandler;

  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
    return mobileleMethodSecurityExpressionHandler;
  }

  @Bean
  public MobileleMethodSecurityExpressionHandler createExpressionHandler(OfferService offerService) {
    return new MobileleMethodSecurityExpressionHandler(offerService);
  }

}

