package bg.softuni.MobiLeLe.config;

import bg.softuni.MobiLeLe.service.OfferService;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class MobileleMethodSecurityExpressionHandler extends
    DefaultMethodSecurityExpressionHandler {

  private final OfferService offerService;

  public MobileleMethodSecurityExpressionHandler(OfferService offerService) {
    this.offerService = offerService;
  }

  @Override
  protected MethodSecurityExpressionOperations createSecurityExpressionRoot(
      Authentication authentication, MethodInvocation invocation) {
    OwnerSecurityExpressionRoot root = new OwnerSecurityExpressionRoot(authentication);

    root.setOfferService(offerService);
    root.setPermissionEvaluator(getPermissionEvaluator());
    root.setTrustResolver(new AuthenticationTrustResolverImpl());
    root.setRoleHierarchy(getRoleHierarchy());

    return root;

  }
}
